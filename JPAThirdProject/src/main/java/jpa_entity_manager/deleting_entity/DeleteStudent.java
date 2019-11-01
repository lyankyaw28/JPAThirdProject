package jpa_entity_manager.deleting_entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa_entity_manager.StudentEntity;

public class DeleteStudent {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		StudentEntity s = em.find(StudentEntity.class, 102);
		em.remove(s);
		em.getTransaction().commit();
		emf.close();
		em.close();

	}
}
