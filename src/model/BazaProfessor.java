package model;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class BazaProfessor {
	private static BazaProfessor instance = null;

	public static BazaProfessor getInstance() {
		if (instance == null) {
			instance = new BazaProfessor();
		}
		return instance;
	}

	private long generator;

	private List<Professor> profesori;
	public ArrayList<Professor> searched;	//pravimo novu listu za pretrazivanje 
	private List<String> kolone;
	private boolean searchedDone;			

	private BazaProfessor() {
		generator = 0;
		searched = new ArrayList<Professor>();
		searchedDone = false;

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("E-MAIL ADRESA");

		this.profesori = new ArrayList<Professor>();

		profesori.add(new Professor("Nebojsa", "Ralevic", LocalDate.now(),
				new Address("Zmaj Jovina", "1", "Novi Sad", "Srbija"), "069/2903456", "email@gmai",
				new Address("Strazilovska", "2", "Novi Sad", "Srbija"), "ID3457", "prof dr", "15", null));
		profesori.add(new Professor("Rade", "Doroslovacki", LocalDate.now(),
				new Address("Jevrejska", "1", "Novi Sad", "Srbija"), "069/00022", "email1@gmai",
				new Address("Futoska", "2", "Novi Sad", "Srbija"), "ID1157", "prof dr", "20", null));
		profesori.add(new Professor("Milan", "Rapaic", LocalDate.now(),
				new Address("Dunavska", "7", "Novi Sad", "Srbija"), "069/299996", "email2@gmai",
				new Address("Kosovska", "2", "Novi Sad", "Srbija"), "ID300000", "prof dr", "10", null));
	}

	public List<Professor> getProfesori() {
		return profesori;
	}

	private long generateId() {
		return ++generator;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Professor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Professor profesor = this.profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getFirstName();
		case 1:
			return profesor.getLastName();
		case 2:
			return profesor.getPosition();
		case 3:
			return profesor.getEmail();
		default:
			return null;
		}

	}

	public void dodajProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, String workingYear) {
		Professor prof = new Professor(firstName, lastName, dateOfBirth, homeAddress, phone, email, officeAddress,
				idCard, position, workingYear, null);
		this.profesori.add(prof);
	}

	public void izbrisiProfesora(int row) { // brise red u tabeli
		profesori.remove(row);
	}

	public void izmeniProfesora(Professor profesor, String firstName, String lastName, LocalDate dateOfBirth,
			Address home_address, String phone, String email, Address officeAddress, String idCard, String position,
			String workingYear) {

		profesor.setFirstName(firstName);
		profesor.setLastName(lastName);
		profesor.setDateOfBirth(dateOfBirth);
		profesor.setHomeAddress(home_address);
		profesor.setPhone(phone);
		profesor.setEmail(email);
		profesor.setOfficeAddress(officeAddress);
		profesor.setIdCard(idCard);
		profesor.setPosition(position);
		profesor.setWorkingYear(workingYear);
	}

	public void izmeniProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, String workingYear) {
		for (Professor profesor : profesori) {
			if (profesor.getIdCard().equals(idCard)) {
				profesor.setFirstName(firstName);
				profesor.setLastName(lastName);
				profesor.setDateOfBirth(dateOfBirth);
				profesor.setHomeAddress(homeAddress);
				profesor.setPhone(phone);
				profesor.setEmail(email);
				profesor.setOfficeAddress(officeAddress);
				profesor.setIdCard(idCard);
				profesor.setPosition(position);
				profesor.setWorkingYear(workingYear);
				return;
			}
		}
	}

	public void getProffessorNameSurname(String lastName, String name) {
		searched.clear();
		searchedDone = true;
		for (Professor p : profesori) {
			if (name == null) {
				if (p.getLastName().toLowerCase().contains(lastName)) {
					searched.add(p);
				}
			} else {
				if (p.getLastName().toLowerCase().contains(lastName) && p.getFirstName().toLowerCase().contains(name)) {
					searched.add(p);
				}
			}
		}

	}

	public boolean isSearchedDone() {
		return searchedDone;
	}

	public Professor getRowSearch(int rowIndex) {
		return this.searched.get(rowIndex);
	}

	public String getValueAtSearch(int row, int column) {

		Professor profesor = this.searched.get(row);
		switch (column) {
		case 0:
			return profesor.getFirstName();
		case 1:
			return profesor.getLastName();
		case 2:
			return profesor.getPosition();
		case 3:
			return profesor.getEmail();
		default:
			return null;
		}

	}

	public ArrayList<Professor> getSearched() {
		return searched;
	}

	
}