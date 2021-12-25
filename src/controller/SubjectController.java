package controller;

import java.time.LocalDate;

import gui.TabbedPaneMainFrame;
import model.Address;
import model.BazaProfessor;
import model.BazaSubject;
import model.Professor;

public class SubjectController {
	private static SubjectController instance = null;

	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}

	public void izbrisiPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		BazaSubject.getInstance().izbrisiPredmet(rowSelectedIndex);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("IZBRISAN", -1);
	}

	
}