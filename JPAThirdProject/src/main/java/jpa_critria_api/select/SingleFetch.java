package jpa_critria_api.select;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa_critria_api.StudentOrderBy;

public class SingleFetch {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StudentOrderBy> cq = cb.createQuery(StudentOrderBy.class);
		Root<StudentOrderBy> stud = cq.from(StudentOrderBy.class);
		cq.multiselect(stud.get("s_name"));
		CriteriaQuery<StudentOrderBy> select = cq.select(stud);
		TypedQuery<StudentOrderBy> q = em.createQuery(select);
		List<StudentOrderBy> list = q.getResultList();
		System.out.println("s_id");
		for (StudentOrderBy s : list) {
			System.out.println(s.getS_id());
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
