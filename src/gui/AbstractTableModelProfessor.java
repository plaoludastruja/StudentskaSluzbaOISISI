package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaProfessor;

public class AbstractTableModelProfessor extends AbstractTableModel {
	
	public AbstractTableModelProfessor() {
	}
	
	@Override
	public int getRowCount() {
		return BazaProfessor.getInstance().getProfesori().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaProfessor.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfessor.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfessor.getInstance().getValueAt(rowIndex, columnIndex);
	}
	

}
