package gapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "department", cascade=CascadeType.ALL)
	private List<Program> programs;

	@OneToMany(mappedBy = "department", cascade=CascadeType.ALL)
	@OrderBy("type desc")
	private List<AddField> addFields;

	public List<AddField> getAddFields() {
		return addFields;
	}

	public void setAddFields(List<AddField> addFields) {
		this.addFields = addFields;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public Department() {
		setPrograms(new ArrayList<Program>());
		setAddFields(new ArrayList<AddField>());
	}

}
