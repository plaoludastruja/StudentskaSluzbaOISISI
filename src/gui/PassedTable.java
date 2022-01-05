package gui;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controller.StudentController;
import model.Student;

public class PassedTable extends JTable {

	private static PassedTable instance = null;

	public static PassedTable getInstance() {
		if (instance == null) {
			instance = new PassedTable();
		}

		return instance;
	}
	
	public PassedTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader();
		
		DefaultTableModel passedTableModel = new DefaultTableModel();
		Vector<String> kolone = new Vector<String>();

		kolone.add("SifraPredmeta");
		kolone.add("ImePredmeta");
		kolone.add("ESPB");
		kolone.add("Ocjena");
		kolone.add("Datum");
		
		
		
		passedTableModel.setColumnIdentifiers(kolone);
		this.setModel(passedTableModel);
		
	}
	public DefaultTableModel getDefaultTableModel() {
		return (DefaultTableModel) PassedTable.getInstance().getModel();
	}
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		// Svaka celija ima renderer, koji se poziva prilikom njenog iscrtavanja.
		// Podrazumevano se pozivaju prilikom inicijalnog iscrtavanja tabele.
		// Ukoliko korisnik selektuje neku celiju, dolazi do ponovnog
		// iscrtavanje svih celija u redu koji je selektovan, kao i u redu
		// koji je prethodno bio selektovan.
		// TODO: Probati na primeru!
		// System.out.println(row + " " + column);
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
}
