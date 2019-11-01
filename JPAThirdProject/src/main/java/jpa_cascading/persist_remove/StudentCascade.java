package jpa_cascading.persist_remove;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentCascade {
	/*
	 * public static void main(String[] args) {
	 * 
	 * EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("JPAThirdProject"); EntityManager em =
	 * emf.createEntityManager(); em.getTransaction().begin();
	 * 
	 * StudentPersistRemove s1 = new StudentPersistRemove(); s1.setS_id(101);
	 * s1.setS_name("Vipul"); s1.setS_age(20);
	 * 
	 * StudentPersistRemove s2 = new StudentPersistRemove(); s2.setS_id(102);
	 * s2.setS_name("Aman"); s2.setS_age(22);
	 * 
	 * SubjectPersistRemove sb1 = new SubjectPersistRemove();
	 * sb1.setName("ENGLISH"); sb1.setMarks(80); sb1.setS_id(s1.getS_id());
	 * 
	 * SubjectPersistRemove sb2 = new SubjectPersistRemove(); sb2.setName("Maths");
	 * sb2.setMarks(75); sb2.setS_id(s2.getS_id());
	 * 
	 * s1.setSub(sb1); s2.setSub(sb2);
	 * 
	 * em.persist(s1);// No need to perform persist operation separately for
	 * different entities. em.persist(s2);
	 * 
	 * em.getTransaction().commit();
	 * 
	 * em.close(); emf.close();
	 * 
	 * }
	 */

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		StudentPersistRemove s = em.find(StudentPersistRemove.class, 101);
		em.remove(s);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
