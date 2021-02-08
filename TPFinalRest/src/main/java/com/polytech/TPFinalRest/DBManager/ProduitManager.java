package com.polytech.TPFinalRest.DBManager;

import com.polytech.TPFinalRest.Model.Produit;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;

import static com.polytech.TPFinalRest.DBManager.HibernateFactory.getSession;

public class ProduitManager {
    public Produit create(Produit produit) {
        Session session = getSession();
        session.beginTransaction();
        session.save(produit);
        session.getTransaction().commit();
        Query query = session.createQuery("select produit from Produit as produit where produit.id =:id");
        query.setParameter("id", produit.getId());
        return (Produit) query.getSingleResult();
    }

    public List<Produit> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select produit from Produit as produit");
        return query.getResultList();
    }

    public Produit update(Produit produit) {
        Session session = getSession();
        session.beginTransaction();
        session.update(produit);
        session.getTransaction().commit();
        return produit;
    }

    public Response delete(Produit produit) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(produit);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}
