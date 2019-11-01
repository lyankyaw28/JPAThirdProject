package jpa_type_of_mapping.many_to_many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class StudentMTM {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int s_id;
	private String s_name;

	@ManyToMany(targetEntity = LibraryMTM.class)
	private List lib;

	public StudentMTM() {
	}

	public StudentMTM(int s_id, String s_name, List lib) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.lib = lib;
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

	public List getLib() {
		return lib;
	}

	public void setLib(List lib) {
		this.lib = lib;
	}

}
