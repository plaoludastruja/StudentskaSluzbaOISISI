package controller;

import gui.StudentTable;
import gui.TabbedPaneMainFrame;
import gui.dialog.DepartmentDialog;
import model.BazaDepartment;
import model.BazaStudent;
import model.Department;
import model.Student;

public class DepartmentController {
	
	private static DepartmentController instance = null;
	public static DepartmentController getInstance() {
		if (instance == null) {
			instance = new DepartmentController();
		}
		return instance;
	}
	
	
	private DepartmentController() {}

	public Department getDepartment(int id) {
		return BazaDepartment.getInstance().getDepartments().get(id);
	}
}
