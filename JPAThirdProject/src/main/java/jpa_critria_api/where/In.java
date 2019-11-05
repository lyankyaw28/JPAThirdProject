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

public class In {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		AbstractQuery<StudentOrderBy> cq = cb.createQuery(StudentOrderBy.class);
		Root<StudentOrderBy> stud = cq.from(StudentOrderBy.class);
		cq.where(cb.in(stud.get("s_age")).value(22).value(24));
		CriteriaQuery<StudentOrderBy> select = ((CriteriaQuery<StudentOrderBy>) cq).select(stud);
		TypedQuery<StudentOrderBy> tq = em.createQuery(select);
		List<StudentOrderBy> list = tq.getResultList();
		System.out.println("Students having age 22 and 24");
		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");
		for (StudentOrderBy s : list) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.println("\t" + s.getS_age());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
