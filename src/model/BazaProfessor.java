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
		this.kolone.add("BROJ LICNE");

		this.profesori = new ArrayList<Professor>();

		profesori.add(new Professor("Nebojsa", "Ralevic", LocalDate.now(), new Address("Zmaj Jovina","1","Novi Sad","Srbija"), "069/2903456",
				"email@gmai", new Address("Strazilovska","2","Novi Sad","Srbija"), "ID3457","prof dr","15"));
		profesori.add(new Professor("Rade", "Doroslovacki", LocalDate.now(), new Address("Jevrejska","1","Novi Sad","Srbija"), "069/00022",
				"email1@gmai", new Address("Futoska","2","Novi Sad","Srbija"), "ID1157","prof dr","20"));
		profesori.add(new Professor("Milan", "Rapaic", LocalDate.now(), new Address("Dunavska","7","Novi Sad","Srbija"), "069/299996",
				"email2@gmai", new Address("Kosovska","2","Novi Sad","Srbija"), "ID300000","prof dr","10")); 
	}

	public List<Professor> getProfesori() {
		return profesori;
	}

	public Professor getProfessorByID(String idCard) {
		for(Professor i : profesori) {
			if(i.getIdCard().equals(idCard)) {
				return i;
			}
		}
		return null;
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
			return profesor.getIdCard();
		default:
			return null;
		}

	}

	public void dodajProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, String workingYear) {
		Professor prof = new Professor(firstName, lastName, dateOfBirth, homeAddress, phone, email, officeAddress,
				idCard, position, workingYear);
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