package marinalucentini.entities;

import jakarta.persistence.*;
import marinalucentini.enums.GenereConcerto;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concerto")
public class Concerto extends Evento {
    @Column(nullable = false, name = "genere_concerto")
    @Enumerated(EnumType.STRING)
    private GenereConcerto genereConcerto;
    @Column(nullable = false)
    private boolean in_streaming;

    public Concerto() {

    }

    public Concerto(String titolo, LocalDate dataevento, String descrizione, marinalucentini.enums.tipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, GenereConcerto genereConcerto, boolean in_streaming) {
        super(titolo, dataevento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genereConcerto = genereConcerto;
        this.in_streaming = in_streaming;
    }

    public GenereConcerto getGenereConcerto() {
        return genereConcerto;
    }

    public void setGenereConcerto(GenereConcerto genereConcerto) {
        this.genereConcerto = genereConcerto;
    }

    public boolean isIn_streaming() {
        return in_streaming;
    }

    public void setIn_streaming(boolean in_streaming) {
        this.in_streaming = in_streaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genereConcerto=" + genereConcerto +
                ", in_streaming=" + in_streaming +
                '}';
    }
}
