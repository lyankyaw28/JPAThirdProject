package jpa_critria_api.order_by;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa_critria_api.StudentOrderBy;

public class Desc {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StudentOrderBy> cq = cb.createQuery(StudentOrderBy.class);
		Root<StudentOrderBy> stud = cq.from(StudentOrderBy.class);
		cq.orderBy(cb.desc(stud.get("s_age")));
		CriteriaQuery<StudentOrderBy> select = cq.select(stud);
		TypedQuery<StudentOrderBy> q = em.createQuery(select);
		List<StudentOrderBy> list = q.getResultList();
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
