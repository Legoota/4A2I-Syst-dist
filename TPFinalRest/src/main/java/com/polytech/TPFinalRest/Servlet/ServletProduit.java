package com.polytech.TPFinalRest.Servlet;

import com.polytech.TPFinalRest.DBManager.ClientManager;
import com.polytech.TPFinalRest.DBManager.ProduitManager;
import com.polytech.TPFinalRest.Model.Client;
import com.polytech.TPFinalRest.Model.Produit;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/produit")
public class ServletProduit extends HttpServlet {
    @GET
    @Path("produits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produit> getProductsFromDB() {
        ProduitManager pm = new ProduitManager();
        return pm.getAll();
    }

    @GET
    @Path("produits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produit getProduitFromId(@PathParam("id") int id){
        ProduitManager pm = new ProduitManager();
        return pm.getById(id);
    }

    @POST
    @Path("produits")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produit createProductDB(Produit p) {
        ProduitManager pm = new ProduitManager();
        return pm.create(p);
    }

    @PUT
    @Path("produits")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Produit updateProductDB(Produit p){
        ProduitManager pm = new ProduitManager();
        return pm.update(p);
    }

    @DELETE
    @Path("produits")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProduct(Produit p)
    {
        ProduitManager pm = new ProduitManager();
        return pm.delete(p);
    }
}
