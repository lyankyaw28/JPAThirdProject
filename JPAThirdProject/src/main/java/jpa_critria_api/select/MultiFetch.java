package jpa_critria_api.select;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class MultiFetch {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<StudentCritriaSelect> cq = cb.createQuery(StudentCritriaSelect.class);
		Root<StudentCritriaSelect> stud = cq.from(StudentCritriaSelect.class);
		cq.multiselect(stud.get("s_id"), stud.get("s_name"), stud.get("s_age"));
		CriteriaQuery<StudentCritriaSelect> select = cq.select(stud);
		TypedQuery<StudentCritriaSelect> q = em.createQuery(select);
		List<StudentCritriaSelect> list = q.getResultList();
		System.out.print("s_id");
		System.out.print("\t s_name");
		System.out.println("\t s_age");
		for (StudentCritriaSelect s : list) {
			System.out.print(s.getS_id());
			System.out.print("\t" + s.getS_name());
			System.out.println("\t" + s.getS_age());
		}
	}
}
