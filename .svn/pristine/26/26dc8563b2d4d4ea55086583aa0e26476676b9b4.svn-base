package gapp.model;

import java.io.File;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "add_values")
public class AddValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "number_value")
	private Double doubleValue;
	
	@Column(name = "text_value")
	private String stringValue;

	@Column(name = "file_value")
	private File fileValue;

	@ManyToOne
	private Application application;
	
	@ManyToOne
	private AddField addField;

	public AddValue() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	public File getFileValue() {
		return fileValue;
	}

	public void setFileValue(File fileValue) {
		this.fileValue = fileValue;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public AddField getAddField() {
		return addField;
	}

	public void setAddField(AddField addField) {
		this.addField = addField;
	}

	
}
