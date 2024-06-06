package marinalucentini.entities;

import jakarta.persistence.*;
import marinalucentini.enums.StatoType;

import java.util.UUID;

@Entity
@Table
public class Partecipazioni {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Persona partecipazioni;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private StatoType statoType;


    public Partecipazioni() {

    }

    public Partecipazioni(Persona persona, Evento evento, StatoType statoType) {
        this.partecipazioni = persona;
        this.evento = evento;
        this.statoType = statoType;
    }

    public Persona getPersonaList() {
        return partecipazioni;
    }

    public void setPersonaList(Persona persona) {
        this.partecipazioni = persona;
    }

    public UUID getId() {
        return id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoType getStatoType() {
        return statoType;
    }

    public void setStatoType(StatoType statoType) {
        this.statoType = statoType;
    }

    @Override
    public String toString() {
        return "Partecipazioni{" +
                "id=" + id +

                ", evento='" + evento + '\'' +
                ", statoType=" + statoType +
                '}';
    }
}
