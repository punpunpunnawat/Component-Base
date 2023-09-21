package departmentdb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;


public class DepartmentReport {
    public static void main (String [] args)
    {
        List<Employee> empList = findAllEmployeeByID();
        System.out.print("All employee (by ID)");
        for(Employee i : empList)
        {
            System.out.print(i);
        }
        
        System.out.print("All employee (by Department)");
        for(Department i : findAllDepartment())
        {
            System.out.print(i);
            for(Employee j : findAllEmployeeByID())
            {
                if(i.equals(j.getDepartmentid()))
                {
                    System.out.print(j);
                }
                
            }
        }
        System.out.println("\n-------------------------");
        
    }
    
    public static List<Employee> findAllEmployeeByID()
    {
  
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
    
        List<Employee> empList = (List<Employee>) em.createNamedQuery("Employee.findAll").getResultList();
        em.close();
        
        
       return empList; 
    }
    
    public static List<Department> findAllDepartment()
    {
  
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentdbPU");
        EntityManager em = emf.createEntityManager();
    
        List<Department> depList = (List<Department>) em.createNamedQuery("Department.findAll").getResultList();
        em.close();
        
        
       return depList; 
    }
 
    
}
