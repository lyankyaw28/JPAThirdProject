package jpa_inheritance.single_table;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeePersistSingleTable {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		ActiveEmployeeSingleTable ae1 = new ActiveEmployeeSingleTable(101, "Karun", 10000, 5);
		ActiveEmployeeSingleTable ae2 = new ActiveEmployeeSingleTable(102, "Rishab", 12000, 7);
		RetiredEmployeeSingleTable re1 = new RetiredEmployeeSingleTable(103, "Ramesh", 5000);
		RetiredEmployeeSingleTable re2 = new RetiredEmployeeSingleTable(104, "Raj", 4000);
		em.persist(ae1);
		em.persist(ae2);
		em.persist(re1);
		em.persist(re2);
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
