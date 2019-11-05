package jpa_critria_api.group_by;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa_critria_api.StudentOrderBy;

public class StudentGroup {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<StudentOrderBy> stud = cq.from(StudentOrderBy.class);
		cq.multiselect(stud.get("s_age"), cb.count(stud)).groupBy(stud.get("s_age"));
		System.out.print("s_age");
		System.out.println("\t Count");
		List<Object[]> list = em.createQuery(cq).getResultList();
		for (Object[] object : list) {
			System.out.println(object[0] + "     " + object[1]);

		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
