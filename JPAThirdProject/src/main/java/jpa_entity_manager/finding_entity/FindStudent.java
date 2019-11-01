package jpa_entity_manager.finding_entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa_entity_manager.StudentEntity;

public class FindStudent {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();

		StudentEntity s = em.find(StudentEntity.class, 101);

		System.out.println("Student id = " + s.getS_id());
		System.out.println("Student Name = " + s.getS_name());
		System.out.println("Student Age = " + s.getS_age());

	}
}
