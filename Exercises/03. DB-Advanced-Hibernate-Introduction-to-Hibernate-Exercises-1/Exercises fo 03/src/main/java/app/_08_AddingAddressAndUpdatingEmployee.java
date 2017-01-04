package app;

import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class _08_AddingAddressAndUpdatingEmployee {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Address address = new Address();
        address.setAddressText("Vitoshka 15");
        address.setTownId(em.find(Town.class, 32));
        em.persist(address);

        Query jpqlQuery = em.createQuery("SELECT e FROM Employee AS e where e.lastName = 'Nakov' ");
        Employee employeeNakov = (Employee) jpqlQuery.getSingleResult();
        employeeNakov.setAddressId(em.find(Address.class, 296));
        em.persist(employeeNakov);

        Employee nakov = (Employee) jpqlQuery.getSingleResult();
        System.out.println(nakov.getAddressId().getAddressText());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
