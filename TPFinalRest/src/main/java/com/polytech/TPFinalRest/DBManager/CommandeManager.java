package com.polytech.TPFinalRest.DBManager;

import com.polytech.TPFinalRest.Model.Client;
import com.polytech.TPFinalRest.Model.Commande;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;

import static com.polytech.TPFinalRest.DBManager.HibernateFactory.getSession;

public class CommandeManager {
    public Commande create(Commande commande) {
        Session session = getSession();
        session.beginTransaction();
        session.save(commande);
        session.getTransaction().commit();
        Query query = session.createQuery("select commande from Commande as commande where commande.id =:id");
        query.setParameter("id", commande.getId());
        return (Commande) query.getSingleResult();
    }

    public List<Commande> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select commande from Commande as commande");
        return query.getResultList();
    }

    public Commande getById(int id){
        Session session = getSession();
        Query query = session.createQuery("select commande from Commande as commande where commande.id=:id");
        query.setParameter("id",id);
        return (Commande) query.getSingleResult();
    }

    public Commande update(Commande c) {
        Session session = getSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
        return c;
    }

    public Response delete(Commande c) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}
