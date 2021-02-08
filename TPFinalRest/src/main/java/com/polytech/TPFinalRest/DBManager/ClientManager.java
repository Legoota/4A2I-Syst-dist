package com.polytech.TPFinalRest.DBManager;

import com.polytech.TPFinalRest.Model.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.Response;
import java.util.List;

import static com.polytech.TPFinalRest.DBManager.HibernateFactory.getSession;

public class ClientManager {
    public Client create(Client client) {
        Session session = getSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        Query query = session.createQuery("select client from Client as client where client.id =:id");
        query.setParameter("id", client.getId());
        return (Client) query.getSingleResult();
    }

    public List<Client> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select client from Client as client");
        return query.getResultList();
    }

    public Client update(Client client) {
        Session session = getSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        return client;
    }

    public Response delete(Client client) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        return Response.ok().build();
    }
}
