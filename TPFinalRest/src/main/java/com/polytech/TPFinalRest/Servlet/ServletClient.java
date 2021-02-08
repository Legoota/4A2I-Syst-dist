package com.polytech.TPFinalRest.Servlet;

import com.polytech.TPFinalRest.DBManager.ClientManager;
import com.polytech.TPFinalRest.Model.Client;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/client")
public class ServletClient extends HttpServlet {
    @GET
    @Path("clients")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Client> getClientsFromDB() {
        ClientManager cm = new ClientManager();
        return cm.getAll();
    }

    @POST
    @Path("clients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client createClientDB(Client c) {
        ClientManager cm = new ClientManager();
        return cm.create(c);
    }

    @PUT
    @Path("clients")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Client updateClientDB(Client c){
        ClientManager cm = new ClientManager();
        return cm.update(c);
    }

    @DELETE
    @Path("clients")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteClient(Client client)
    {
        ClientManager cm = new ClientManager();
        return cm.delete(client);
    }
}
