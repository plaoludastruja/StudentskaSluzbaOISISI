package gui;

import javax.swing.table.AbstractTableModel;

import model.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel {

	public AbstractTableModelStudent() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return BazaStudent.getInstance().getStudent().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return BazaStudent.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    return getValueAt(0, columnIndex).getClass();
	}
}
