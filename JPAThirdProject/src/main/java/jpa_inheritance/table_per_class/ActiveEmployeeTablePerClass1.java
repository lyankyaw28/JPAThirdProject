package jpa_inheritance.table_per_class;

import javax.persistence.Entity;

@Entity
public class ActiveEmployeeTablePerClass1 extends EmployeeTablePerClass {
	private static final long serialVersionUID = 1L;
	private int e_salary;
	private int e_experience;

	public ActiveEmployeeTablePerClass1(int e_id, String e_name, int e_salary, int e_experience) {
		super(e_id, e_name);
		this.e_salary = e_salary;
		this.e_experience = e_experience;
	}

	public ActiveEmployeeTablePerClass1() {
	}

	public int getE_salary() {
		return e_salary;
	}

	public void setE_salary(int e_salary) {
		this.e_salary = e_salary;
	}

	public int getE_experience() {
		return e_experience;
	}

	public void setE_experience(int e_experience) {
		this.e_experience = e_experience;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
