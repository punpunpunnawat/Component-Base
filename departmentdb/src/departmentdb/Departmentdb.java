
package departmentdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

public class Departmentdb {


    public static void main(String[] args) {
        Department d1 = new Department(001, "IT");
        Department d2 = new Department(002, "HR");
        Employee e1 = new Employee(001, "Pun", "Programmer", 30000, d1);
        Employee e2 = new Employee(002, "Sarai", "Admin", 30000, d2);
        persist(d1);
        persist(d2);
        persist(e1);
        persist(e2);
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
    
}
