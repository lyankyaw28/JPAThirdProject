package jpa_type_of_mapping.one_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LibraryOTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int b_id;
	private String b_name;

	@OneToOne
	private StudentOTO stud;
	
	public LibraryOTO() {}

	public LibraryOTO(int b_id, String b_name, StudentOTO stud) {
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

	public StudentOTO getStud() {
		return stud;
	}

	public void setStud(StudentOTO stud) {
		this.stud = stud;
	}

}
