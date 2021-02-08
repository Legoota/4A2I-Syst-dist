package com.polytech.TPFinalRest.Servlet;

import com.polytech.TPFinalRest.DBManager.FabricationManager;
import com.polytech.TPFinalRest.Model.Fabrication;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fabrication")
public class ServletFabrication extends HttpServlet {

    @GET
    @Path("fabrications")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fabrication> getAllFabrications() {
        FabricationManager fm = new FabricationManager();
        return fm.getAll();
    }

    @POST
    @Path("fabrications")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fabrication createFabrication(Fabrication p) {
        FabricationManager fm = new FabricationManager();
        return fm.create(p);
    }

    @PUT
    @Path("fabrications")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Fabrication updateFabrication(Fabrication p){
        FabricationManager fm = new FabricationManager();
        return fm.update(p);
    }

    @DELETE
    @Path("fabrications")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFabrication(Fabrication f) {
        FabricationManager fm = new FabricationManager();
        return fm.delete(f);
    }
}
