package jpa_jpql.bulk_data_operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkFetch {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		StudentBulkFetch s1 = new StudentBulkFetch();
		s1.setS_id(1);
		s1.setS_name("Lyan Kyaw");
		s1.setS_age(26);

		StudentBulkFetch s2 = new StudentBulkFetch();
		s2.setS_id(2);
		s2.setS_name("Lyan Kyaw1");
		s2.setS_age(26);

		StudentBulkFetch s3 = new StudentBulkFetch();
		s3.setS_id(3);
		s3.setS_name("Lyan Kyaw2");
		s3.setS_age(26);

		StudentBulkFetch s4 = new StudentBulkFetch();
		s4.setS_id(4);
		s4.setS_name("Lyan Kyaw3");
		s4.setS_age(26);

		StudentBulkFetch s5 = new StudentBulkFetch();
		s5.setS_id(5);
		s5.setS_name("Lyan Kyaw4");
		s5.setS_age(26);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);

		Query query = em.createQuery("Select s from StudentBulkFetch s ");

		@SuppressWarnings("unchecked")
		List<StudentBulkFetch> list = (List<StudentBulkFetch>) query.getResultList();

		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");

		for (StudentBulkFetch s : list) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.print("\t" + s.getS_age());
			System.out.println();
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
