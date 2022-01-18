package controller;

import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import gui.StudentTable;
import gui.ToolBar;

public class SearchController {

	private static SearchController instance = null;

	public static SearchController getInstance() {
		if (instance == null) {
			instance = new SearchController();
		}
		return instance;
	}
	private TableRowSorter<TableModel> sorter = new TableRowSorter<>(StudentTable.getInstance().getModel());
	
	
	private SearchController() {
		
	}
	
	public void searchStudent() {
		StudentTable.getInstance().setRowSorter(sorter);
		 if (ToolBar.searchField.getText().toLowerCase().length() == 0) {
             sorter.setRowFilter(null);
          } else {
             sorter.setRowFilter(RowFilter.regexFilter(ToolBar.searchField.getText()));
          }
	}
	
	
	public void searchProfessor() {
		
	}
	public void searchSubject() {
	
	}
}
