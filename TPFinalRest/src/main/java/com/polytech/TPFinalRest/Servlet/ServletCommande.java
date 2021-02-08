package com.polytech.TPFinalRest.Servlet;

import com.polytech.TPFinalRest.DBManager.CommandeManager;
import com.polytech.TPFinalRest.Model.Commande;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/commande")
public class ServletCommande extends HttpServlet {
    @GET
    @Path("commandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getAllCommandes() {
        CommandeManager cm = new CommandeManager();
        return cm.getAll();
    }

    @POST
    @Path("commandes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Commande createCommande(Commande c) {
        CommandeManager cm = new CommandeManager();
        return cm.create(c);
    }

    @PUT
    @Path("commandes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Commande updateCommande(Commande c){
        CommandeManager cm = new CommandeManager();
        return cm.update(c);
    }

    @DELETE
    @Path("commandes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCommande(Commande c) {
        CommandeManager cm = new CommandeManager();
        return cm.delete(c);
    }
}
