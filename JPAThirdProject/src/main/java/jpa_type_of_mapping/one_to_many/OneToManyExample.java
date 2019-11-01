package jpa_type_of_mapping.one_to_many;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToManyExample {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		LibraryOTM lib1 = new LibraryOTM();
		lib1.setB_id(101);
		lib1.setB_name("Data Structure");

		LibraryOTM lib2 = new LibraryOTM();
		lib2.setB_id(102);
		lib2.setB_name("DBMS");

		em.persist(lib1);
		em.persist(lib2);

		ArrayList<LibraryOTM> list = new ArrayList<LibraryOTM>();
		list.add(lib1);
		list.add(lib2);

		StudentOTM st1 = new StudentOTM();
		st1.setS_id(1);
		st1.setS_name("Vipul");
		st1.setBooks_issued(list);

		em.persist(st1);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
