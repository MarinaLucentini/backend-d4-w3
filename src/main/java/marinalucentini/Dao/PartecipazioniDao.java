package marinalucentini.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import marinalucentini.entities.Partecipazioni;
import marinalucentini.exception.eventoException;

import java.util.UUID;

public class PartecipazioniDao {
    private final EntityManager em;

    public PartecipazioniDao(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazioni partecipazioni) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazioni);
        transaction.commit();
        System.out.println("La partecipazione con id" + partecipazioni.getId() + "è stato aggiunto con successo");
    }

    public Partecipazioni findById(String id) {
        Partecipazioni partecipazioni = em.find(Partecipazioni.class, UUID.fromString(id));
        if (partecipazioni == null) throw new eventoException(UUID.fromString(id));
        return partecipazioni;
    }

    public void findAndRemovedById(String id) {
        Partecipazioni found = this.findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found);
        transaction.commit();
        System.out.println("L'evento " + found.getId() + "è stato eliminato");
    }
}
