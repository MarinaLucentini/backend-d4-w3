package marinalucentini.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marinalucentini.entities.Persona;
import marinalucentini.exception.eventoException;

import java.util.UUID;

public class PersonaDao {
    private final EntityManager em;

    public PersonaDao(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Il sig./ra" + persona.getNome() + persona.getCognome() + "è stato aggiunto con successo");
    }

    public Persona findById(String id) {
        Persona persona = em.find(Persona.class, UUID.fromString(id));
        if (persona == null) throw new eventoException(UUID.fromString(id));
        return persona;
    }

    public void findAndRemovedById(String id) {
        Persona found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getNome() + found.getCognome() + "è stato eliminato");
    }
}
