package controller;

import java.time.LocalDate;



import gui.TabbedPaneMainFrame;
import model.Address;
import model.BazaProfessor;
import model.BazaStudent;
import model.BazaSubject;
import model.Professor;
import model.Student;
import model.Subject;

public class SubjectController {
	private static SubjectController instance = null;

	public static SubjectController getInstance() {
		if (instance == null) {
			instance = new SubjectController();
		}
		return instance;
	}

	private SubjectController() {}
	
	public Subject getSubjectByCode(int id) {
		return BazaSubject.getInstance().getSubjectByCode(id);
	}
	
	public void addSubject(Subject noviPredmet) {
		
		// izmena modela
		BazaSubject.getInstance().addSubject(noviPredmet);
		// azuriranje prikaz
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
   /* public void deleteSubject(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Subject subject = BazaSubject.getInstance().getRow(rowSelectedIndex);
    	BazaSubject.getInstance().deleteSubject(subject.getSubjectCode());
		// azuriranje prikaza
    	TabbedPaneMainFrame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
    }*/
	
	public void editSubject(int rowSelectedIndex, Subject izmjenaPredmet) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		//Subject subject = BazaSubject.getInstance().getRow(rowSelectedIndex);
		BazaSubject.getInstance().changeSubject(izmjenaPredmet);
		
		// azuriranje prikaza
		TabbedPaneMainFrame.getInstance().azurirajPrikaz(null, -1);
	}
	
	public void deleteSubject(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}

		BazaSubject.getInstance().deleteSubject(rowSelectedIndex);
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("IZBRISAN", -1);
	}

	
}