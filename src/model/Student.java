package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class Student implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2345756339654764685L;

	public enum Status { B, S; }
	
	private int id;
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private Address address;
	private String phone;
	private String email;
	private String index;
	private int indexYear;
	private int currentYear;
	private Status studentStatus;
	private double averageGrade;
	private List<Grade> passedExams = new ArrayList<Grade>();
	private List<Subject> otherExams = new ArrayList<Subject>();
	
	public Student() {
		super();
	}
	
	
	// za dodavanje u bazu
	public Student(String firstName, String lastName, LocalDate dateOfBirth, Address address, String phone,
			String email, String index, int indexYear, int currentYear,double averageGrade, Status studentStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.index = index;
		this.indexYear = indexYear;
		this.currentYear = currentYear;
		this.averageGrade = averageGrade;
		this.studentStatus = studentStatus;
	}

	/*public Student(String string, String string2, String string3, int i, Status b, double d) {
		// TODO Auto-generated constructor stub
	}*/

	


	
	
	public int getId() {
		return id;
	}

	public Student(int id, String index, String firstName, String lastName, int currentYear, LocalDate dateOfBirth,
			Address address, String phone, String email, Status studentStatus, int indexYear, List<Grade> passedExams,
			List<Subject> otherExams) {
		super();
		this.id = id;
		this.index = index;
		this.firstName = firstName;
		this.lastName = lastName;
		this.currentYear = currentYear;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.studentStatus = studentStatus;
		this.indexYear = indexYear;
		this.passedExams = passedExams;
		this.otherExams = otherExams;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		if (address!=null)
		  return address;
		return new Address();
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public int getIndexYear() {
		return indexYear;
	}

	public void setIndexYear(int indexYear) {
		this.indexYear = indexYear;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public Status getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(Status studentStatus) {
		this.studentStatus = studentStatus;
	}

	public double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(double averageGrade) {
		this.averageGrade = averageGrade;
	}

	public List<Grade> getPassedExams() {
		return passedExams;
	}

	public void setPassedExams(List<Grade> passedExams) {
		this.passedExams = passedExams;
	}

	public List<Subject> getOtherExams() {
		return otherExams;
	}

	public void setOtherExams(List<Subject> otherExams) {
		this.otherExams = otherExams;
	}

	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", firstName=" + firstName + ", dateOfBirth=" + dateOfBirth
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", index=" + index + ", indexYear="
				+ indexYear + ", currentYear=" + currentYear + ", studentStatus=" + studentStatus + ", averageGrade="
				+ averageGrade + ", passedExams=" + passedExams + ", otherExams=" + otherExams + "]";
	}

	
	
}
