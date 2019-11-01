package jpa_type_of_mapping.many_to_one;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneExample {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		LibraryMTO lib1 = new LibraryMTO();
		lib1.setB_id(101);
		lib1.setB_name("Data Structure");

		em.persist(lib1);

		StudentMTO st1 = new StudentMTO();
		st1.setS_id(1);
		st1.setS_name("Vipul");
		st1.setLib(lib1);

		StudentMTO st2 = new StudentMTO();
		st2.setS_id(2);
		st2.setS_name("Vimal");
		st2.setLib(lib1);

		em.persist(st1);
		em.persist(st2);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
