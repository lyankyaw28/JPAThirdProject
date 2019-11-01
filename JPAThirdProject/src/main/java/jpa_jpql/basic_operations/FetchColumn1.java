package jpa_jpql.basic_operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchColumn1 {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		StudentStaticeQuery s1 = new StudentStaticeQuery();
		s1.setS_id(1);
		s1.setS_name("Lyan Kyaw");
		s1.setS_age(26);

		StudentStaticeQuery s2 = new StudentStaticeQuery();
		s2.setS_id(2);
		s2.setS_name("Lyan Kyaw1");
		s2.setS_age(26);

		StudentStaticeQuery s3 = new StudentStaticeQuery();
		s3.setS_id(3);
		s3.setS_name("Lyan Kyaw2");
		s3.setS_age(26);

		StudentStaticeQuery s4 = new StudentStaticeQuery();
		s4.setS_id(4);
		s4.setS_name("Lyan Kyaw3");
		s4.setS_age(26);

		StudentStaticeQuery s5 = new StudentStaticeQuery();
		s5.setS_id(5);
		s5.setS_name("Lyan Kyaw4");
		s5.setS_age(26);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		em.getTransaction().commit();
		Query query = em.createNamedQuery("find name");
		@SuppressWarnings("unchecked")
		List<StudentStaticeQuery> list = query.getResultList();
		System.out.println("Student Name :");
		for (StudentStaticeQuery s : list) {

			System.out.println(s.getS_name());
		}
	}
}
