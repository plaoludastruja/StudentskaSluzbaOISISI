package gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfessorTable extends JTable{

	
	private static ProfessorTable instance = null;

	public static ProfessorTable getInstance() {
		if (instance == null) {
			instance = new ProfessorTable();
		}

		return instance;
	}
	
	public ProfessorTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(new AbstractTableModelProfessor());
		this.getTableHeader().setReorderingAllowed(false);
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
