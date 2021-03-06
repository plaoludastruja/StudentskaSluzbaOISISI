package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 6725044975913082088L;
	
		private int id;
		private String firstName;
		private String lastName;
		private LocalDate dateOfBirth;
		private Address homeAddress;
		private String phone;
		private String email;
		private Address officeAddress;
		private String idCard;
		private String position; 
		private int workingYear;
		private List<Subject> listofSubjects = new ArrayList<Subject>();
	
	public Professor() {
		super();
	}


	public Professor(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress, String phone,
			String email, Address officeAddress, String idCard, String position, int workingYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.phone = phone;
		this.email = email;
		this.officeAddress = officeAddress;
		this.idCard = idCard;
		this.position = position;
		this.workingYear = workingYear;
		//this.listofSubjects = listofSubjects;
	}






	public Professor(int id, String idCard, String firstName, String lastName, LocalDate dateOfBirth,
			Address homeAddress, String phone, String email, Address officeAddress, int workingYear, String position,
			List<Subject> listofSubjects) {
		super();
		this.id = id;
		this.idCard = idCard;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.phone = phone;
		this.email = email;
		this.officeAddress = officeAddress;
		this.position = position;
		this.workingYear = workingYear;
		this.listofSubjects = listofSubjects;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
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

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(int workingYear) {
		this.workingYear = workingYear;
	}

	public List<Subject> getListofSubjects() {
		return listofSubjects;
	}

	public void setListofSubjects(List<Subject> listofSubjects) {
		this.listofSubjects = listofSubjects;
	}

	/*@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", homeAddress=" + homeAddress + ", phone=" + phone + ", email=" + email + ", officeAddress="
				+ officeAddress + ", idCard=" + idCard + ", position=" + position + ", workingYear=" + workingYear
				+ ", listofSubjects=" + listofSubjects + "]";
	}*/
	
	@Override
	public String toString() {
		return firstName + " " + lastName + " "+ idCard;
	}



	
	
	
	
}
