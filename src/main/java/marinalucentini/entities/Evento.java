package marinalucentini.entities;

import jakarta.persistence.*;
import marinalucentini.enums.tipoEvento;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "evento")

public class Evento {
    @Id
    @GeneratedValue
    private UUID id;
    @Column(name = "title")
    private String titolo;
    @Column(name = "date")
    private LocalDate dataevento;
    @Column(name = "description")
    private String descrizione;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private tipoEvento tipoEvento;
    @Column(name = "maxusers")
    private int numeroMassimoPartecipanti;
    @ManyToOne
    @JoinColumn(name = "location_id", unique = true)
    private Location location;
    @OneToMany(mappedBy = "evento")

    private List<Partecipazioni> partecipazioniList;

    public Evento() {

    }

    public Evento(String titolo, LocalDate dataevento, String descrizione, marinalucentini.enums.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location) {
        this.titolo = titolo;
        this.dataevento = dataevento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataevento() {
        return dataevento;
    }

    public void setDataevento(LocalDate dataevento) {
        this.dataevento = dataevento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public marinalucentini.enums.tipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(marinalucentini.enums.tipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataevento=" + dataevento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
