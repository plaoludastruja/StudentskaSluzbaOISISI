package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

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
		
		this.setModel(new AbstractTableModelProfessor());
	}
}
