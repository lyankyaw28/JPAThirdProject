package jpa_collection_mapping.set_mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SetMapping {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAThirdProject");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Address1 a1 = new Address1();
		a1.setE_pincode(201301);
		a1.setE_city("Noida");
		a1.setE_state("Uttar Pradesh");

		Address1 a2 = new Address1();
		a2.setE_pincode(302001);
		a2.setE_city("Jaipur");
		a2.setE_state("Rajasthan");

		Address1 a3 = new Address1();
		a3.setE_pincode(133301);
		a3.setE_city("Chandigarh");
		a3.setE_state("Punjab");

		Address1 a4 = new Address1();
		a4.setE_pincode(80001);
		a4.setE_city("Patna");
		a4.setE_state("Bihar");

		Employee1 e1 = new Employee1();
		e1.setE_id(1);
		e1.setE_name("Vijay");

		Employee1 e2 = new Employee1();
		e2.setE_id(2);
		e2.setE_name("Vijay");

		Employee1 e3 = new Employee1();
		e3.setE_id(3);
		e3.setE_name("William");

		Employee1 e4 = new Employee1();
		e4.setE_id(4);
		e4.setE_name("Rahul");

		e1.getAddress().add(a1);
		e2.getAddress().add(a2);
		e3.getAddress().add(a3);
		e4.getAddress().add(a4);

		em.persist(e1);
		em.persist(e2);
		em.persist(e3);
		em.persist(e4);

		em.getTransaction().commit();

		em.close();
		emf.close();

	}
}
