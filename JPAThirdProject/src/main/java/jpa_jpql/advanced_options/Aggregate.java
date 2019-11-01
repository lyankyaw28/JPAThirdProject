package jpa_jpql.advanced_options;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Aggregate {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q1 = em.createQuery("Select count(s) from StudentJPQLAdvancedOptions s");
		System.out.println("Number of Student : " + q1.getSingleResult());
		Query q2 = em.createQuery("Select MAX(s.s_age) from StudentJPQLAdvancedOptions s");
		System.out.println("Maximum age : " + q2.getSingleResult());
		Query q3 = em.createQuery("Select MIN(s.s_age) from StudentJPQLAdvancedOptions s");
		System.out.println("Minimum age : " + q3.getSingleResult());
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
