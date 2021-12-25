package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaProfessor;
import model.BazaSubject;

public class AbstractTableModelSubject extends AbstractTableModel {
	
	public AbstractTableModelSubject() {
	}
	
	@Override
	public int getRowCount() {
		return BazaSubject.getInstance().getSubjects().size();
	}
	
	@Override
	public int getColumnCount() {
		return BazaSubject.getInstance().getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaSubject.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaSubject.getInstance().getValueAt(rowIndex, columnIndex);
	}
	

}
