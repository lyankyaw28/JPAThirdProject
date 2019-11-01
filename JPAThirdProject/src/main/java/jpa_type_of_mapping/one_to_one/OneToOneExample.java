package jpa_type_of_mapping.one_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneExample {
	public static void main(String[] args) {  
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "JPAThirdProject" );  
           EntityManager em = emf.createEntityManager( );  
           em.getTransaction( ).begin( );  
          
           StudentOTO st1=new StudentOTO();  
           st1.setS_id(1);  
           st1.setS_name("Vipul");  
             
           StudentOTO st2=new StudentOTO();  
           st2.setS_id(2);  
           st2.setS_name("Vimal");  
             
           em.persist(st1);  
           em.persist(st2);  
             
           LibraryOTO lib1=new LibraryOTO();  
           lib1.setB_id(101);  
           lib1.setB_name("Data Structure");  
           lib1.setStud(st1);  
             
           LibraryOTO lib2=new LibraryOTO();  
           lib2.setB_id(102);  
           lib2.setB_name("DBMS");  
           lib2.setStud(st2);  
             
           em.persist(lib1);  
           em.persist(lib2);  
             
           em.getTransaction().commit();  
             
           em.close();  
           emf.close();  
    }  
}
