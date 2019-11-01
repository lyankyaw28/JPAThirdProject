package jpa_type_of_mapping.many_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class LibraryMTM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int b_id;
	private String b_name;

	@ManyToMany(targetEntity = StudentMTM.class)
	private List stud;

	public LibraryMTM() {
	}

	public LibraryMTM(int b_id, String b_name, List stud) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.stud = stud;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public List getStud() {
		return stud;
	}

	public void setStud(List stud) {
		this.stud = stud;
	}

}
