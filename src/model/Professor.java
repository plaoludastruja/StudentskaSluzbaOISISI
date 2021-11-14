package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor {

		private String firstName;
		private String lastName;
		private LocalDate dateOfBirth;
		private String homeAdress;
		private String phone;
		private String email;
		private String officeAdress;
		private String idCard;
		private String position; //titula
		private String workingYear; //godine radnog staza
		private List<Subject> listofSubjects = new ArrayList();
	
	public Professor() {
		super();
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

	public String getHomeAdress() {
		return homeAdress;
	}

	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
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

	public String getOfficeAdress() {
		return officeAdress;
	}

	public void setOfficeAdress(String officeAdress) {
		this.officeAdress = officeAdress;
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

	public String getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(String workingYear) {
		this.workingYear = workingYear;
	}

	public List<Subject> getListofSubjects() {
		return listofSubjects;
	}

	public void setListofSubjects(List<Subject> listofSubjects) {
		this.listofSubjects = listofSubjects;
	}

	@Override
	public String toString() {
		return "Professor [firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth
				+ ", homeAdress=" + homeAdress + ", phone=" + phone + ", email=" + email + ", officeAdress="
				+ officeAdress + ", idCard=" + idCard + ", position=" + position + ", workingYear=" + workingYear
				+ ", listofSubjects=" + listofSubjects + "]";
	}


	
	
	
	
}
