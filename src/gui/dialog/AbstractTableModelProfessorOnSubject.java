package gui.dialog;

import javax.swing.table.AbstractTableModel;

import controller.ProfessorController;
import controller.StudentController;
import gui.ProfessorTable;
import gui.StudentTable;
import model.BazaSubject;

public class AbstractTableModelProfessorOnSubject extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		//return 5;
		return ProfessorController.getInstance().getProfessortByID(ProfessorTable.getInstance().getSelectedRow()).getListofSubjects().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaSubject.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaSubject.getInstance().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaSubject.getInstance().getValueAt2(rowIndex, columnIndex);
	}

}
