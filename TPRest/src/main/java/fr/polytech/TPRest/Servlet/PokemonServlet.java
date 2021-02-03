package fr.polytech.TPRest.Servlet;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.polytech.TPRest.DBManager.PokemonManager;
import fr.polytech.TPRest.Models.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Path("/pokemon")
public class PokemonServlet extends HttpServlet {

    static List<Pokemon> pokemons = new ArrayList<>();
    static {
        pokemons.add(new Pokemon("pikachu",50));
        pokemons.add(new Pokemon("salameche", 60));
        pokemons.add(new Pokemon("carapuce", 70));
        pokemons.add(new Pokemon("bulbizarre",80));
    }

    @GET
    @Path("pokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemonsFromDB() {
        PokemonManager pm = new PokemonManager();
        return pm.getAll();
    }

    @PUT
    @Path("addPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean addPokemon(Pokemon p) {
        return pokemons.add(p);
    }

    @GET
    @Path("getPokemons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @GET
    @Path("getPokemon/{nom}")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemon(@PathParam("nom") String nom) {
        for(Pokemon p: pokemons){
            if(p.getNom().equals(nom))
                return Response.ok().entity(p).build();;
        }
        return Response.noContent().build();
    }

    @POST
    @Path("editPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean editPokemon(Pokemon pok) {
        for(Pokemon p: pokemons){
            if(p.getNom().equals(pok.getNom())){
                p.setNiveau(pok.getNiveau()); // change le niveau du pokemon
                return true;
            }
        }
        return false;
    }

    @DELETE
    @Path("delPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public boolean delPokemon(Pokemon p) {
        return pokemons.remove(p);
    }
}
