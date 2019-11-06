package jpa_inheritance.table_per_class;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeePersistenceTablePerClass {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		ActiveEmployeeTablePerClass1 ae1 = new ActiveEmployeeTablePerClass1(101, "Karun", 10000, 5);
		ActiveEmployeeTablePerClass1 ae2 = new ActiveEmployeeTablePerClass1(102, "Rishab", 12000, 7);

		RetiredEmployeeTablePerClass re1 = new RetiredEmployeeTablePerClass(103, "Ramesh", 5000);
		RetiredEmployeeTablePerClass re2 = new RetiredEmployeeTablePerClass(104, "Raj", 4000);

		em.persist(ae1);
		em.persist(ae2);

		em.persist(re1);
		em.persist(re2);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
