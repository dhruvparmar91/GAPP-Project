package gapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "add_fields")
public class AddField implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String type;

	@Column(name = "is_required", nullable = true)
	private boolean required;

//	@Column(name = "number_value")
//	private Double doubleValue;
//
//	@Column(name = "text_value")
//	private String stringValue;
//
//	@Column(name = "file_value")
//	private File fileValue;

	@ManyToOne
	private Department department;

//	@ManyToOne
//	private Application application;
	
	@OneToMany(mappedBy="addField", cascade=CascadeType.ALL)
	private List<AddValue> addValues;

	public AddField() {

	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

//	public Application getApplication() {
//		return application;
//	}
//
//	public void setApplication(Application application) {
//		this.application = application;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getType() {
		return type;
	}

	public void setType(String type) {
		this.type = (String) type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Double getDoubleValue() {
//		return doubleValue;
//	}
//
//	public void setDoubleValue(Double doubleValue) {
//		this.doubleValue = doubleValue;
//	}
//
//	public String getStringValue() {
//		return stringValue;
//	}
//
//	public void setStringValue(String stringValue) {
//		this.stringValue = stringValue;
//	}
//
//	public File getFileValue() {
//		return fileValue;
//	}
//
//	public void setFileValue(File fileValue) {
//		this.fileValue = fileValue;
//	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

}
