package marinalucentini.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marinalucentini.entities.Evento;
import marinalucentini.exception.eventoException;

import java.util.UUID;

public class EventoDao {
    private final EntityManager em;

    public EventoDao(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("L'evento" + evento.getTitolo() + "è stato aggiunto con successo");
    }

    public Evento findById(String id) {
        Evento evento = em.find(Evento.class, UUID.fromString(id));
        if (evento == null) throw new eventoException(UUID.fromString(id));
        return evento;
    }

    public void findAndRemovedById(String id) {
        Evento found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getTitolo() + "è stato eliminato");
    }
}
