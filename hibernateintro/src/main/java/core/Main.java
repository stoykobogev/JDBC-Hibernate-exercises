package core;

import entities.enums.Predictions;

import javax.persistence.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("efbet");
        EntityManager em = emf.createEntityManager();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        em.getTransaction().begin();

        em.getTransaction().commit();

        em.close();
        emf.close();
        System.exit(0);
    }
}
