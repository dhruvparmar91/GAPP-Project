package gapp.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "applications")
public class Application implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne
	private User applicant;

	@ManyToOne
	private Department department;

	@ManyToOne
	private Program program;

	@OneToMany(mappedBy="application", cascade=CascadeType.ALL)
	private List<AddValue> addValues;

	private String term;

	//@Embedded
	//@ElementCollection()
	//@CollectionTable(name = "application_degrees", joinColumns = @JoinColumn(name = "application_id") )
	@OneToMany(mappedBy="application", cascade=CascadeType.ALL)
	@OrderBy("startyear desc")
	private List<Degree> degrees;

	@Column(name = "toefl_score")
	private Integer toeflScore;

	@Column(name = "gre_score")
	private Integer greScore;

	private Double gpa;

	private File transcript;

//	@Embedded
//	@ElementCollection
//	@CollectionTable(name = "app_statuses", joinColumns = @JoinColumn(name = "application_id") )
	@OneToMany(mappedBy="application", cascade=CascadeType.ALL)
	@Column(name = "app_status")
	@OrderBy("id desc")
	private List<AppStatus> appStatuses;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private Integer cin;

	private String phone;

	private String email;

	private String gender;

	@Column(name = "date_of_birth")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dateOfBirth;

	private String citizenship;
	
//	public List<AddField> getAddFields() {
//		return addFields;
//	}
//
//	public void setAddFields(List<AddField> addFields) {
//		this.addFields = addFields;
//	}

	public Application() {
		setDegrees(new ArrayList<Degree>());
		//setAddFields(new ArrayList<AddField>());
		setAppStatuses(new ArrayList<AppStatus>());
		setAddValues(new ArrayList<AddValue>());

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getCin() {
		return cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public Integer getToeflScore() {
		return toeflScore;
	}

	public void setToeflScore(Integer toeflScore) {
		this.toeflScore = toeflScore;
	}

	public Integer getGreScore() {
		return greScore;
	}

	public void setGreScore(Integer greScore) {
		this.greScore = greScore;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public File getTranscript() {
		return transcript;
	}

	public void setTranscript(File transcript) {
		this.transcript = transcript;
	}

	public List<AppStatus> getAppStatuses() {
		return appStatuses;
	}

	public void setAppStatuses(List<AppStatus> appStatuses) {
		this.appStatuses = appStatuses;
	}

	public List<AddValue> getAddValues() {
		return addValues;
	}

	public void setAddValues(List<AddValue> addValues) {
		this.addValues = addValues;
	}
	

}
