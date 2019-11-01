package jpa_jpql.advanced_options;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Sorting {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query q1 = em.createQuery("Select s from StudentJPQLAdvancedOptions s order by s.s_age desc");
		@SuppressWarnings("unchecked")
		List<StudentJPQLAdvancedOptions> l1 = (List<StudentJPQLAdvancedOptions>) q1.getResultList();
		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");
		for (StudentJPQLAdvancedOptions s : l1) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.println("\t" + s.getS_age());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
