package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import model.Address;
import model.BazaProfessor;
import model.BazaStudent;
import model.Professor;
import model.Student;

public class ProfessorController {
	private static ProfessorController instance = null;

	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}

	private ProfessorController() {
	}
	
	public List<Professor> getProfesori() {
		return  BazaProfessor.getInstance().getProfesori();
	}

	public void dodajProfesora(String firstName, String lastName, LocalDate dateOfBirth, Address homeAddress,
			String phone, String email, Address officeAddress, String idCard, String position, String workingYear) {

		BazaProfessor.getInstance().dodajProfesora(firstName, lastName, dateOfBirth, homeAddress, phone, email,
				officeAddress, idCard, position, workingYear);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("DODAT", -1);
	}

	public void izbrisiProfesora(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		BazaProfessor.getInstance().izbrisiProfesora(rowSelectedIndex);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("IZBRISAN", -1);
	}

	public void izmeniProfesora(Professor forEdit, String firstName, String lastName, LocalDate dateOdBirth,
			Address home_address, String phone, String email, Address officeAddress, String idCard, String position,
			String workingYear) {
		
		BazaProfessor.getInstance().izmeniProfesora(forEdit, firstName, lastName, dateOdBirth, home_address,
				phone, email, officeAddress, idCard, position, workingYear);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("IZMENJEN", -1);

	}
	
	
	
	public void getProffessorNameSurname(String lastName,String name) {
		BazaProfessor.getInstance().getProffessorNameSurname(lastName, name);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("IZMENJEN", -1);
	}
	
	
	
	
	
}