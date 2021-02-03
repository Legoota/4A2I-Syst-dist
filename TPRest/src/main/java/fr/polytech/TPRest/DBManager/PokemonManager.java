package fr.polytech.TPRest.DBManager;

import fr.polytech.TPRest.Models.Pokemon;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;
import static fr.polytech.TPRest.DBManager.HibernateFactory.getSession;
public class PokemonManager {

    public Pokemon create(Pokemon pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.save(pokemon);
        session.getTransaction().commit();
        Query query = session.createQuery("select pokemon from Pokemon as pokemon where pokemon.id =:id");
        query.setParameter("id", pokemon.getId());
        return (Pokemon) query.getSingleResult();
    }

    public List<Pokemon> getAll() {
        Session session = getSession();
        Query query = session.createQuery("select pokemon from Pokemon as pokemon");
        return query.getResultList();
    }

    public Pokemon update(Pokemon pokemon) {
        Session session = getSession();
        session.beginTransaction();
        session.update(pokemon);
        session.getTransaction().commit();
        Query query = session.createQuery("select pokemon from Pokemon as pokemon where pokemon.id =:id");
        query.setParameter("id", pokemon.getId());
        return (Pokemon) query.getSingleResult();
    }
}