package app;

import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Date;

public class _03_CreateObjects {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department departmentTraining = new Department();
        departmentTraining.setName("Training");
        departmentTraining.setManagerId(em.find(Employee.class, 3));
        em.persist(departmentTraining);

        Town townBurgas = new Town();
        townBurgas.setName("Burgas");
        em.persist(townBurgas);

        Address address1 = new Address();
        address1.setAddressText("Chaika 6");
        address1.setTownId(em.find(Town.class, 33));
        em.persist(address1);

        Address address2 = new Address();
        address2.setAddressText("Glarus 5");
        address2.setTownId(em.find(Town.class, 33));
        em.persist(address2);

        Employee pesho = new Employee();
        pesho.setFirstName("Pesho");
        pesho.setLastName("Peshov");
        pesho.setMiddleName("Ivanov");
        pesho.setJobTitle("Engineering");
        pesho.setDepartmentId(em.find(Department.class, 20));
        pesho.setManagerId(em.find(Employee.class, 3));
        pesho.setHireDate(new Date());
        pesho.setSalary(new BigDecimal("1500"));
        pesho.setAddressId(em.find(Address.class, 292));
        em.persist(pesho);

        Employee gosho = new Employee();
        gosho.setFirstName("Gosho");
        gosho.setLastName("Goshov");
        gosho.setMiddleName("Ivanov");
        gosho.setJobTitle("Engineering");
        gosho.setDepartmentId(em.find(Department.class, 20));
        gosho.setManagerId(em.find(Employee.class, 3));
        gosho.setHireDate(new Date());
        gosho.setSalary(new BigDecimal("1500"));
        gosho.setAddressId(em.find(Address.class, 292));
        em.persist(gosho);

        Employee tosho = new Employee();
        tosho.setFirstName("Tosho");
        tosho.setLastName("Toshov");
        tosho.setMiddleName("Ivanov");
        tosho.setJobTitle("Engineering");
        tosho.setDepartmentId(em.find(Department.class, 20));
        tosho.setManagerId(em.find(Employee.class, 3));
        tosho.setHireDate(new Date());
        tosho.setSalary(new BigDecimal("1500"));
        tosho.setAddressId(em.find(Address.class, 293));
        em.persist(tosho);

        Employee mincho = new Employee();
        mincho.setFirstName("Mincho");
        mincho.setLastName("Minchov");
        mincho.setMiddleName("Ivanov");
        mincho.setJobTitle("Engineering");
        mincho.setDepartmentId(em.find(Department.class, 20));
        mincho.setManagerId(em.find(Employee.class, 3));
        mincho.setHireDate(new Date());
        mincho.setSalary(new BigDecimal("1500"));
        mincho.setAddressId(em.find(Address.class, 293));
        em.persist(mincho);

        Employee siika = new Employee();
        siika.setFirstName("Siika");
        siika.setLastName("Toshova");
        siika.setMiddleName("Ivanova");
        siika.setJobTitle("Engineering");
        siika.setDepartmentId(em.find(Department.class, 20));
        siika.setManagerId(em.find(Employee.class, 3));
        siika.setHireDate(new Date());
        siika.setSalary(new BigDecimal("1500"));
        siika.setAddressId(em.find(Address.class, 293));
        em.persist(siika);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}