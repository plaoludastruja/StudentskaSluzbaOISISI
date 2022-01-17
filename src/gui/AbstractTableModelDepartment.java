package gui;

import javax.swing.table.AbstractTableModel;

import controller.DepartmentController;
import controller.ProfessorController;
import model.BazaDepartment;
import model.BazaStudent;

public class AbstractTableModelDepartment extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaDepartment.getInstance().getDepartments().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaDepartment.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return BazaDepartment.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaDepartment.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
