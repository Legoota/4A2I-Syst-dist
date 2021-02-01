package fr.polytech.TPRest.Servlet;



import fr.polytech.TPRest.Models.Person;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloServlet extends HttpServlet {

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
