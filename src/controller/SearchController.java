package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gui.AbstractTableModelStudent;
import gui.StudentTable;
import gui.ToolBar;
import model.Address;


public class SearchController {

	private static SearchController instance = null;

	public static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	
	private TableRowSorter<AbstractTableModelStudent> studentSorter = new TableRowSorter<AbstractTableModelStudent>((AbstractTableModelStudent) StudentTable.getInstance().getModel());

	private SearchController() {
		
	}

	public void searchStudent() {
		
		String[] parts = ToolBar.searchField.getText().toLowerCase().split(",");
		List<RowFilter<Object, Object>> filter = new ArrayList<RowFilter<Object,Object>>(3);
		
		filter.add(RowFilter.regexFilter("(?i)" +  ".*" + "(?i)" + parts[0] + ".*", 2));
		
		if(parts.length >= 2) {
			filter.add(RowFilter.regexFilter("(?i)" + ".*" + "(?i)" + parts[1] + ".*", 1));
			
			if(parts.length == 3) {
				filter.add(RowFilter.regexFilter("(?i)" + ".*" + "(?i)" + parts[2] + ".*", 0));
			}
		}
		
		RowFilter<Object, Object> studentFilter = RowFilter.andFilter(filter);
		studentSorter.setRowFilter(studentFilter);
		StudentTable.getInstance().setRowSorter(studentSorter);

	}
	
	
	public void searchProfessor() {
		String profesor = ToolBar.searchField.getText().toLowerCase();
		String[] nizProfessor = profesor.split(",");
		if (nizProfessor.length == 1) {

			String lastName = nizProfessor[0].trim();
			ProfessorController.getInstance().getProffessorNameSurname(lastName, null);

		} else if (nizProfessor.length == 2) {

			String lastName = nizProfessor[0].trim();
			String name = nizProfessor[1].trim();

			ProfessorController.getInstance().getProffessorNameSurname(lastName, name);

		} else {
			JOptionPane.showMessageDialog(null,
					"Pretraga profesora mora biti formata prezime ili prezime, ime", "Pogresan format!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
	public void searchSubject() {
		String predmet = ToolBar.searchField.getText().toLowerCase();
		String[] nizPredmet = predmet.split(",");
		if (nizPredmet.length == 1) {

			String name = nizPredmet[0].trim();
			SubjectController.getInstance().getSubjectNameCode(name, null);

		} else if (nizPredmet.length == 2) {

			String name = nizPredmet[0].trim();
			String code = nizPredmet[1].trim();

			SubjectController.getInstance().getSubjectNameCode(name, code);

		} else {
			JOptionPane.showMessageDialog(null,
					"Pretraga predmeta mora biti formata ime ili ime, sifra", "Pogresan format!",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
