package jpa_inheritance.table_per_class;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table_per_class")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeTablePerClass implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int e_id;
	private String e_name;

	public EmployeeTablePerClass(int e_id, String e_name) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
	}

	public EmployeeTablePerClass() {
	}

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

}
