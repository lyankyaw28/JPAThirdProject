package jpa_jpql.bulk_data_operations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BulkDelete {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("delete from StudentBulkFetch where s_id=3");
		query.executeUpdate();
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
