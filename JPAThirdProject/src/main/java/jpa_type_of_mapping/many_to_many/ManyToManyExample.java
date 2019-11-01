package jpa_type_of_mapping.many_to_many;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToManyExample {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		StudentMTM st1 = new StudentMTM(1, "Vipul", null);
		StudentMTM st2 = new StudentMTM(2, "Vimal", null);

		em.persist(st1);
		em.persist(st2);

		ArrayList<StudentMTM> al1 = new ArrayList<StudentMTM>();
		ArrayList<StudentMTM> al2 = new ArrayList<StudentMTM>();

		al1.add(st1);
		al1.add(st2);

		al2.add(st1);
		al2.add(st2);

		LibraryMTM lib1 = new LibraryMTM(101, "Data Structure", al1);
		LibraryMTM lib2 = new LibraryMTM(102, "DBMS", al2);

		em.persist(lib1);
		em.persist(lib2);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
