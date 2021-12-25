package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import model.Address;
import model.BazaStudent;
import model.Student;
import model.Student.Status;
import gui.dialog.AddStudentDialog;
public class StudentController {

	
private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	
	private StudentController() {}
	// ovo pozivam na dugme ok kada napravim studenta, znaci :
	/* btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IgraciController.getInstance().dodajIgraca();
			}
		});
	*/
	
	// BazaStudent.getInstance().addStudent("Zucko", "Korac", "OKK Beograd");
	// ovo mi poziva metodu iz BazaStudent i dodaje u listu, ali trebam tu proslijediti txtIme.getText();
	// a to mi je u addStudentDialog
	
	
	public Student getStudentByID(int id) {
		return BazaStudent.getInstance().getStudentByID(id);
	}
	
	/*public void addStudent(String firstName, String lastName,
			LocalDate dateOfBirth, Address address, String phone,
			String email, String index, int indexYear,
			int currentYear,double averageGrade, Status studentStatus) {*/
	public void addStudent(Student noviStudent) {
		// izmena modela
		
		//Student studentBaza = new Student(txtIme.getText(), txtPrezime.getText(), txtDatumRodjenja.getText(), txtAdresaStanovanja.getText(), txtBrojTelefona.getText(), txtEmailAdresa.getText(), txtBrojIndeksa.getText(), txtGodinaUpisa.getText(), txtTrenutnaGodinaStudija.getText(), txtNacinFinansiranja.getText());
		//BazaStudent.getInstance().addStudent(index, firstName, lastName, currentYear, studentStatus, averageGrade);
		BazaStudent.getInstance().addStudent(noviStudent);
		// azuriranje prikaz
		TabbedPaneMainFrame.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
    public void deleteStudent(int rowSelectedIndex) {
    	if (rowSelectedIndex < 0) {
			return;
		}
    	// izmena modela
    	Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
    	BazaStudent.getInstance().deleteStudent(student.getIndex());
		// azuriranje prikaza
    	TabbedPaneMainFrame.getInstance().azurirajPrikaz("UKLONJEN", rowSelectedIndex);
    }
	
	public void editStudent(int rowSelectedIndex, Student izmjenaStudent) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
		BazaStudent.getInstance().changeStudent(izmjenaStudent);
		
		// azuriranje prikaza
		TabbedPaneMainFrame.getInstance().azurirajPrikaz(null, -1);
	}
}
