package fr.polytech.TPRest.Servlet;



import fr.polytech.TPRest.Models.Person;
import fr.polytech.TPRest.Models.Pokemon;
import fr.polytech.TPRest.Models.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.print.attribute.standard.Media;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloServlet extends HttpServlet {

    static List<Product> liste = new ArrayList<>();
    static {
        liste.add(new Product(1,"test1",50));
        liste.add(new Product(2,"test2", 60));
        liste.add(new Product(3,"test3", 70));
        liste.add(new Product(4,"test4",80));
    }

    @GET
    @Path("sayHello")
    public String sayHello() {
        return "hello";
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @GET
    @Path("getPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(String nom) {
        Person p = new Person("nom","prenom");
        // Ici on peut récupérer par exemple la personne avec son nom, ou son id,...
        return Response.ok().entity(p).build();
    }

    @POST
    @Path("ajouterunproduit/{code}/{designation}/{prix}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product ajouterUnProduit(@PathParam("code") int code, @PathParam("designation") String designation, @PathParam("prix") double prix) {
        Product p = new Product(code,designation,prix);
        liste.add(p);
        return p;
    }

    // ecrire une methode permettant d'ajouter un produit passé au format json et le renvoyer en xml

    @POST
    @Path("ajouterunproduitBis")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_XML)
    public Product ajouterUnProduitBis(Product p){
        liste.add(p);
        return p;
    }

    @PUT
    @Path("putPerson")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response putPerson(Person person) {
        return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }

    @DELETE
    @Path("deletePerson")
    @Consumes("text/plain")
    @Produces("text/plain")
    public Response deletePerson(String nom) {
        // exemple de suppression si on avait une liste/db de Person
        /*
        if(dataservice.suppressionPersonneFromNom(nom);
            return Response.ok().entity("Supprimé").build();
        else return return Response.ok().entity("Pas supprimé").build();
         */
        return Response.ok().entity("Supprimé").build();
    }
}
