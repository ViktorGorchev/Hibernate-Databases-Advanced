package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class _10_DatabaseSearchQueries {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //query 1
//        Query jpqlQuery = em.createQuery("SELECT e FROM Employee AS e");
//        List<Employee> employees = jpqlQuery.getResultList();
//
//        StringBuilder result = new StringBuilder();
//        for (Employee employee : employees) {
//            if(employee.getProjects().size() == 0){
//                continue;
//            }
//
//            result.append(employee.getFirstName() + " " + employee.getLastName());
//            result.append(", manager: ");
//            if(employee.getManagerId() != null){
//                result.append(
//                        employee.getManagerId().getFirstName() + " " + employee.getManagerId().getLastName() + " ");
//            }else{
//                result.append("No manager ");
//            }
//
//            for (Project employeeProject : employee.getProjects()) {
//                Calendar cal = Calendar.getInstance();
//                cal.setTime(employeeProject.getStartDate());
//                int year = cal.get(Calendar.YEAR);
//
//                if(year < 2001 || year > 2003){
//                    continue;
//                }
//
//                result.append("Projects: " + employeeProject.getName());
//                result.append(", start date: " + employeeProject.getStartDate());
//                result.append(", end date: " + employeeProject.getEndDate() + " ");
//            }
//
//            result.append(System.lineSeparator());
//        }
//
//        System.out.println(result);


        //query 2
        Query nativeQuery = em.createNativeQuery("SELECT\n " +
                                                "  a.address_text,\n" +
                                                "  t.name\n" +
                                                "  -- COUNT(e.employee_id) AS employee_count\n" +
                                                "FROM employees AS e\n" +
                                                "LEFT JOIN addresses AS a\n" +
                                                "  ON e.address_id = a.address_id\n" +
                                                "LEFT JOIN towns AS t\n" +
                                                "  ON a.town_id = t.town_id\n" +
                                                "GROUP BY a.address_id\n" +
                                                "ORDER BY\n" +
                                                "  -- employee_count DESC,\n" +
                                                "  t.name ASC\n" +
                                                "LIMIT 10\n");

        List<Object[]> data = nativeQuery.getResultList();
        for (int i = 0; i < data.size(); i++) {
            Object addressText = data.get(i)[0];
            Object townName = data.get(i)[1];
            //Object employeeCount = data.get(i)[2];

            System.out.printf("%s, %s - %s employees%n", addressText, townName, "");

        }

//                Query nativeQuery = em.createNativeQuery("SELECT * FROM towns AS t WHERE LENGTH(t.name) > 5");
//        List<Object[]> towns = nativeQuery.getResultList();
//
//        for (Object[] object : towns) {
//            int pk = (int) object[0];
//            Town town = em.find(Town.class,pk);
//            em.detach(town);
//            System.out.println(town.getName());
//        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
