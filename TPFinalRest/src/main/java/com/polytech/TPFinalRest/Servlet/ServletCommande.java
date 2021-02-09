package com.polytech.TPFinalRest.Servlet;

import com.polytech.TPFinalRest.DBManager.ClientManager;
import com.polytech.TPFinalRest.DBManager.CommandeManager;
import com.polytech.TPFinalRest.Model.Client;
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

    @GET
    @Path("commandes/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Commande getCommandeFromId(@PathParam("id") int id){
        CommandeManager cm = new CommandeManager();
        return cm.getById(id);
    }

    @GET
    @Path("paid")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getAllPaidCommande(){
        CommandeManager cm = new CommandeManager();
        return cm.getAllPaid();
    }

    @GET
    @Path("pending")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getAllPendingCommande(){
        CommandeManager cm = new CommandeManager();
        return cm.getAllPending();
    }

    @POST
    @Path("commandes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Commande createCommande(Commande c) {
        CommandeManager cm = new CommandeManager();
        return cm.create(c);
    }

    @POST
    @Path("commandes/validate/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Commande validateCommande(@PathParam("id")int id) {
        CommandeManager cm = new CommandeManager();
        return cm.validateCommande(id);
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
