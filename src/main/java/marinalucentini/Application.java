package marinalucentini;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("d4-w3");

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
