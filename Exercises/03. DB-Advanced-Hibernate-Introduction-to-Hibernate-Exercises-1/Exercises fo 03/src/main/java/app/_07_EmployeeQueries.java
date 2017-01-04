package app;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _07_EmployeeQueries {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Step 1
        Query jpqlQuery = em.createQuery("SELECT e.firstName FROM Employee AS e where e.salary > 50000");
        List<String> employeeNames = jpqlQuery.getResultList();
        employeeNames.stream().forEach(System.out::println);

        //Step 2
        Query jpqlQuery2 = em.createQuery(
                        "SELECT e FROM Employee AS e " +
                        "where e.departmentId.name = 'Research and Development' " +
                        "order by e.salary asc, e.firstName desc ");
        List<Employee> employeeNames2 = jpqlQuery2.getResultList();

        for (Employee employee: employeeNames2) {
            System.out.printf("%s %s from %s - $%s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartmentId().getName(),
                    employee.getSalary().setScale(2).toPlainString());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
