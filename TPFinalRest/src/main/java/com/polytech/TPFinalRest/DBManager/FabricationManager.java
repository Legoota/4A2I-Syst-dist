package com.polytech.TPFinalRest.DBManager;

import com.polytech.TPFinalRest.Model.Fabrication;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;
import static com.polytech.TPFinalRest.DBManager.HibernateFactory.getSession;

public class FabricationManager {
    public Fabrication create(Fabrication pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.save(pokemon);
        session.getTransaction().commit();
        Query query = session.createQuery("select fabrication from Fabrication as fabrication where fabrication.id =:id");
        query.setParameter("id", pokemon.getId());
        return (Fabrication) query.getSingleResult();
    }

    public List<Fabrication> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select fabrication from Fabrication as fabrication");
        return query.getResultList();
    }

    public Fabrication getById(int id){
        Session session = getSession();
        Query query = session.createQuery("select fabrication from Fabrication as fabrication where fabrication.id=:id");
        query.setParameter("id",id);
        return (Fabrication) query.getSingleResult();
    }

    public Fabrication update(Fabrication fab) {
        Session session = getSession();
        session.beginTransaction();
        session.update(fab);
        session.getTransaction().commit();
        return fab;
    }

    public Response delete(Fabrication fab) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(fab);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}
