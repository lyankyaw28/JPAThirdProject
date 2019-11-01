package jpa_collection_mapping.set_mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int e_id;
	private String e_name;

	@ElementCollection
	private Set<Address1> address = new HashSet<Address1>();

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public Set<Address1> getAddress() {
		return address;
	}

	public void setAddress(Set<Address1> address) {
		this.address = address;
	}

}
