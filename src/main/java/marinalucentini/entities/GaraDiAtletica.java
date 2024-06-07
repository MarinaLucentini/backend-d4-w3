package marinalucentini.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("gara_di_atletica")
public class GaraDiAtletica extends Evento {
    @Column(nullable = false)
    @OneToMany(mappedBy = "garaDiAtletica")
    private List<Persona> atleti;
    @OneToOne
    //onetomany
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, LocalDate dataevento, String descrizione, marinalucentini.enums.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Persona> atleti) {
        super(titolo, dataevento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.atleti = atleti;
    }

    public List<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(List<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +

                ", vincitore=" + vincitore +
                '}';
    }
}
