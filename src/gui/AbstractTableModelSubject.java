package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaProfessor;
import model.BazaSubject;

public class AbstractTableModelSubject extends AbstractTableModel {
	
	public AbstractTableModelSubject() {
	}
	
	@Override
	public int getRowCount() {
		if(BazaSubject.getInstance().isSearchedDone()) {
			return BazaSubject.getInstance().getSearched().size();
		}
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
		if(BazaSubject.getInstance().isSearchedDone()) {
			return BazaSubject.getInstance().getValueAtSearch(rowIndex, columnIndex);
		}
		return BazaSubject.getInstance().getValueAt(rowIndex, columnIndex);
	}
	

}
