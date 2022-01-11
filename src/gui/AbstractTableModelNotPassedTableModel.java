package gui;

import javax.swing.table.AbstractTableModel;

import controller.StudentController;
import controller.SubjectController;
import gui.dialog.AddNotPassedSubject;
import model.BazaSubject;
import model.Student;
import model.Subject;

public class AbstractTableModelNotPassedTableModel extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow()).getOtherExams().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}
	@Override
	public String getColumnName(int column) {
		return BazaSubject.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		//Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());				
		//s.getOtherExams().add(predmet);
		return BazaSubject.getInstance().getValueAt1(rowIndex, columnIndex);
	}

}
