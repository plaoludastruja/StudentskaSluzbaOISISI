package controller;

import java.util.ArrayList;
import java.util.List;

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
	
	//rf = RowFilter.regexFilter(filterText.getText(), 0);

	
	public void searchStudent() {
		
		
		String searchPart = ToolBar.searchField.getText().toLowerCase();
		String[] parts = searchPart.split(",");
		

		List<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
		filters.add(RowFilter.regexFilter(parts[0], 2));
		filters.add(RowFilter.regexFilter(parts[1], 1));
		

		switch(parts.length) {
		  case 1:
		        studentSorter.setRowFilter(RowFilter.regexFilter("(?i)" + parts[0] ,2));
		    break;
		  case 2:
		        studentSorter.setRowFilter(RowFilter.regexFilter("(?i)" + parts[1] ,1));
			  break;
		  case 3:
		        //studentSorter.setRowFilter(RowFilter.regexFilter("(?i)" + parts[0] ,1));
		    break;
		  default:
		    // code block
			  
		}
		RowFilter<Object, Object> studentFilter = RowFilter.andFilter(filters);
		studentSorter.setRowFilter(studentFilter);
		StudentTable.getInstance().setRowSorter(studentSorter);
	}
	
	
	public void searchProfessor() {
		
	}
	public void searchSubject() {
	
	}
}
