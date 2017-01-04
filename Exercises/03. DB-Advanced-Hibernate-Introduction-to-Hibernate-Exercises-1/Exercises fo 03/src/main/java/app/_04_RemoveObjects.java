package app;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _04_RemoveObjects {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query jpqlQuery = em.createQuery("SELECT t FROM Town AS t ");
        List<Town> towns = jpqlQuery.getResultList();
        for (Town town : towns) {
            em.persist(town);
            if(town.getName().length() > 5){
                em.detach(town);
            }

            town.setName(town.getName().toLowerCase());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
