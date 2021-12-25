package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
	private List<String> kolone;

	private BazaProfessor() {
		generator = 0;

		this.kolone = new ArrayList<String>();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("ZVANJE");
		this.kolone.add("E-MAIL ADRESA");

		this.profesori = new ArrayList<Professor>();

		profesori.add(new Professor("ime1", "prezime1", LocalDate.now(), new Address("adresa","1","Novi Sad","Srbija"), "069/2903456",
				"email@gmai", new Address("adresa","2","Beograd","Srbija"), "cardid","position 1","work1",null));
		profesori.add(new Professor());
		profesori.add(new Professor()); // dodala 3 prazne tabele(popuniti konstruktore)
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

	public void izmeniProfesora(Professor profesor, String firstName, String lastName, LocalDate dateOfBirth, Address home_address,
			String phone, String email, Address officeAddress, String idCard, String position, String workingYear) {
		
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
}