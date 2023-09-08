/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
import model.StudentTable;

/**
 *
 * @author Lenovo
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Student Punnawat = new Student(64050150, "Punnawat", 3.00);
        Student Pita = new Student(64050151, "Pita", 4.00);
        //StudentTable.insertStudent(Pita);
        Punnawat.setGpa(3.20);
        StudentTable.updateStudent(Punnawat);
        System.out.println(StudentTable.findStudentById(64050150));
        System.out.println(StudentTable.findStudentByName("Pita"));
        System.out.println(StudentTable.findAllStudent());
        //StudentTable.removeStudent(Pita);
        //System.out.println(StudentTable.findStudentByName("Pita"));
    }
    
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentJPAPU");
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
