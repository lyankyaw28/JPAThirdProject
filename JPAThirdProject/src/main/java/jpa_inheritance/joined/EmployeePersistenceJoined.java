package jpa_inheritance.joined;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeePersistenceJoined {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ActiveEmployeeJoined ae1 = new ActiveEmployeeJoined(101, "Karun", 10000, 5);
		ActiveEmployeeJoined ae2 = new ActiveEmployeeJoined(102, "Rishab", 12000, 7);
		RetiredEmployeeJoined re1 = new RetiredEmployeeJoined(103, "Ramesh", 5000);
		RetiredEmployeeJoined re2 = new RetiredEmployeeJoined(104, "Raj", 4000);
		em.persist(ae1);
		em.persist(ae2);
		em.persist(re1);
		em.persist(re2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
