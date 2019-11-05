package jpa_critria_api.where;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa_critria_api.StudentOrderBy;

public class Comparison {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		AbstractQuery<StudentOrderBy> cq1 = cb.createQuery(StudentOrderBy.class);
		AbstractQuery<StudentOrderBy> cq2 = cb.createQuery(StudentOrderBy.class);

		Root<StudentOrderBy> stud1 = cq1.from(StudentOrderBy.class);

		cq1.where(cb.greaterThan(stud1.<Integer>get("s_age"), 22));

		CriteriaQuery<StudentOrderBy> select1 = ((CriteriaQuery<StudentOrderBy>) cq1).select(stud1);
		TypedQuery<StudentOrderBy> tq1 = em.createQuery(select1);
		List<StudentOrderBy> list1 = tq1.getResultList();

		System.out.println("Students having age greater than 22");

		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");

		for (StudentOrderBy s : list1) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.println("\t" + s.getS_age());
		}

		Root<StudentOrderBy> stud2 = cq2.from(StudentOrderBy.class);

		cq2.where(cb.lessThan(stud2.<Integer>get("s_age"), 22));

		CriteriaQuery<StudentOrderBy> select2 = ((CriteriaQuery<StudentOrderBy>) cq2).select(stud2);
		TypedQuery<StudentOrderBy> tq2 = em.createQuery(select2);
		List<StudentOrderBy> list2 = tq2.getResultList();

		System.out.println("Students having age Less than 22");

		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");

		for (StudentOrderBy s : list2) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.println("\t" + s.getS_age());
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
