package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.StudentController;
import gui.dialog.NotPassedSubject;
import model.Student;
import model.Subject;

public class NotPassedTableModel extends AbstractTableModel {

	private ArrayList<String> kolone;

	public NotPassedTableModel() {

		kolone = new ArrayList<String>();

		kolone.add("Sifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Godina predmeta");
		kolone.add("Semestar");

	}

	@Override
	public int getRowCount() {
		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		return stud.getOtherExams().size();
	}

	@Override
	public int getColumnCount() {
		return kolone.size();
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		Subject subject = stud.getOtherExams().get(rowIndex).getSubject();
		
		if (columnIndex == 0) {
			return subject.getSubjectCode();
		} else if (columnIndex == 1) {
			return subject.getSubjectName();
		} else if (columnIndex == 2) {
			return subject.getEspb() + "";
		} else if (columnIndex == 3) {
			return subject.getSubjectYear() + "";
		} else {
			return subject.getSubjectSemester() + "";
		}
	}

	public String getColumnName(int column) {
		return kolone.get(column);
	}

	public ArrayList<String> getColons() {
		return kolone;
	}

	public void setColons(ArrayList<String> kolone) {
		this.kolone = kolone;
	}
	
	
}
