package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class _05_ContainsEmployee {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String inputName = reader.nextLine();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query jpqlQuery = em.createQuery("SELECT e FROM Employee AS e ");
        List<Employee> employees = jpqlQuery.getResultList();
        boolean isInTable = false;
        for (Employee employee : employees) {
            String employeeName = employee.getFirstName() + " " + employee.getLastName();
            if(inputName.equals(employeeName)){
                isInTable = true;
                break;
            }
        }

        if(isInTable){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
