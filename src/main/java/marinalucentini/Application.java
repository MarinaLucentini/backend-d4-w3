package marinalucentini;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marinalucentini.Dao.EventoDao;
import marinalucentini.Dao.LocationDao;
import marinalucentini.entities.Concerto;
import marinalucentini.entities.Location;
import marinalucentini.entities.PartitaDiCalcio;
import marinalucentini.enums.GenereConcerto;
import marinalucentini.enums.tipoEvento;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("d4-w3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        Location location = new Location("Olimpico", "Roma");
        LocationDao lc = new LocationDao(em);
        // lc.save(location);
        Location locationfound = lc.findById("b311f1da-b2d1-46fc-97e2-d37c7955c445");

        PartitaDiCalcio napoliMilan = new PartitaDiCalcio("Napoli vs Milan", LocalDate.of(2024, 9, 15), "partita di calcio", tipoEvento.PUBBLICO, 250, locationfound, "Napoli", "Milan");
        Concerto vascoRossi = new Concerto("Concerto di Vasco Rossi", LocalDate.of(2024, 8, 16), "Concerto di Vasco Rossi", tipoEvento.PUBBLICO, 100, locationfound, GenereConcerto.ROCK, true);
        Concerto lauraPausini = new Concerto("Concerto di Laura Pausini", LocalDate.of(2024, 8, 22), "Concerto di Laura Pausini", tipoEvento.PUBBLICO, 100, locationfound, GenereConcerto.POP, true);
        Concerto beethoven = new Concerto("Concerto di Beethoven", LocalDate.of(2024, 8, 22), "Concerto di Beethoven", tipoEvento.PUBBLICO, 100, locationfound, GenereConcerto.CLASSICO, false);
        EventoDao ev = new EventoDao(em);
//        ev.save(napoliMilan);
//        ev.save(vascoRossi);
//        ev.save(lauraPausini);
//        ev.save(beethoven);
        
        System.out.println("Hello World!");


    }
}
