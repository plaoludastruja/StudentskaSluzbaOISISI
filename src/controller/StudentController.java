package controller;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import model.BazaStudent;
import model.Student;

public class StudentController {

	
private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	
	private StudentController() {}
	
	public void addStudent() {
		// izmena modela
		//BazaStudent.getInstance().addStudent("Zucko", "Korac", "OKK Beograd");
		// azuriranje prikaza
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
    public void izbrisiIgraca(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
    	BazaStudent.getInstance().deleteStudent(student.getIndex());
		// azuriranje prikaza
    	TabbedPaneMainFrame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
    }
	
	public void izmeniIgraca(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
		//BazaStudent.getInstance().izmeniIgraca(student.getIndex(), "Radivoj", "Korac", "OKK Beograd");
		
		// azuriranje prikaza
		TabbedPaneMainFrame.getInstance().azurirajPrikaz(null, -1);
	}
}
