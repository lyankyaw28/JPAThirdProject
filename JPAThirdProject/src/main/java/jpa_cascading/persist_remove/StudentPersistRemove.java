package jpa_cascading.persist_remove;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_persist_remove")
public class StudentPersistRemove {
	@Id
	private int s_id;
	private String s_name;
	private int s_age;

	/*@OneToOne(cascade = CascadeType.PERSIST)*/
	@OneToOne(cascade = CascadeType.REMOVE)
	private SubjectPersistRemove sub;

	public StudentPersistRemove() {
	}

	public StudentPersistRemove(int s_id, String s_name, int s_age, SubjectPersistRemove sub) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_age = s_age;
		this.sub = sub;
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

	public int getS_age() {
		return s_age;
	}

	public void setS_age(int s_age) {
		this.s_age = s_age;
	}

	public SubjectPersistRemove getSub() {
		return sub;
	}

	public void setSub(SubjectPersistRemove sub) {
		this.sub = sub;
	}

}
