package gui;

import javax.swing.table.AbstractTableModel;

import controller.StudentController;
import model.BazaSubject;

public class AbstractTableModelPassedTableModel extends AbstractTableModel {

	@Override
	public int getRowCount() {
		return StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow()).getPassedExams().size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}
	@Override
	public String getColumnName(int column) {
		return BazaSubject.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaSubject.getInstance().getValueAtPassed(rowIndex, columnIndex);
	}

}
