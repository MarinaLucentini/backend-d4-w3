package marinalucentini.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marinalucentini.entities.Location;
import marinalucentini.exception.eventoException;

import java.util.UUID;

public class LocationDao {
    private final EntityManager em;

    public LocationDao(EntityManager em) {
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("La location" + location.getNome() + "è stato aggiunto con successo");
    }

    public Location findById(String id) {
        Location location = em.find(Location.class, UUID.fromString(id));
        if (location == null) throw new eventoException(UUID.fromString(id));
        return location;
    }

    public void findAndRemovedById(String id) {
        Location found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getNome() + "è stato eliminato");
    }
}
