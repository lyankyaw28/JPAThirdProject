package jpa_type_of_mapping.one_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentOTM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;
	private String s_name;

	@OneToMany(targetEntity = LibraryOTM.class)
	private List books_issued;

	public StudentOTM() {
	}

	public StudentOTM(int s_id, String s_name, List books_issued) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.books_issued = books_issued;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public List getBooks_issued() {
		return books_issued;
	}

	public void setBooks_issued(List books_issued) {
		this.books_issued = books_issued;
	}

}
