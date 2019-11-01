package jpa_jpql.basic_operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchColumn {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		StudentDynamicQuery s1 = new StudentDynamicQuery();
		s1.setS_id(1);
		s1.setS_name("Lyan Kyaw");
		s1.setS_age(26);
		
		StudentDynamicQuery s2 = new StudentDynamicQuery();
		s2.setS_id(2);
		s2.setS_name("Lyan Kyaw1");
		s2.setS_age(26);
		
		StudentDynamicQuery s3 = new StudentDynamicQuery();
		s3.setS_id(3);
		s3.setS_name("Lyan Kyaw2");
		s3.setS_age(26);
		
		StudentDynamicQuery s4 = new StudentDynamicQuery();
		s4.setS_id(4);
		s4.setS_name("Lyan Kyaw3");
		s4.setS_age(26);
		
		StudentDynamicQuery s5 = new StudentDynamicQuery();
		s5.setS_id(5);
		s5.setS_name("Lyan Kyaw4");
		s5.setS_age(26);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		em.persist(s4);
		em.persist(s5);
		em.getTransaction().commit();
		
		Query query = em.createQuery("Select s.s_name from StudentDynamicQuery s");
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();
		System.out.println("Student Name :");
		for (String s : list) {
			System.out.println(s);
		}
		em.close();
		emf.close();
	}
}
