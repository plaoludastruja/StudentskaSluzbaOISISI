package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.StudentTable;
import model.Student.Status;

public class BazaDepartment {

	private static BazaDepartment instance = null;

	public static BazaDepartment getInstance() {
		if (instance == null) {
			instance = new BazaDepartment();
		}
		return instance;
	}
	
	private List<Department> katedre = new ArrayList<Department>();

	private List<String> kolone = new ArrayList<String>();
	
	public BazaDepartment() {
		
		initStudent();
		kolone.add("Sifra");
		kolone.add("Naziv katedre");
		kolone.add("Sef katedre");
	}

	private void initStudent() {
		Professor prof = BazaProfessor.getInstance().getProfesori().get(0);
		Department mate = new Department();
		mate.setDepartmentCode("ID1");
		mate.setDepartmentName("MATE");
		mate.setDepartmentBoss(prof);
		
		Department jezik = new Department();
		
		jezik.setDepartmentCode("ID2");
		jezik.setDepartmentName("JEZIK");
		jezik.setDepartmentBoss(prof);
		
		katedre.add(mate);
		katedre.add(jezik);
	}
	
	public List<Department> getDepartments() {
		return katedre;
	}//
	




	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Department getRow(int rowIndex) {
		return this.katedre.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Department student = this.katedre.get(row);
		switch (column) {
		case 0:
			return student.getDepartmentCode();
		case 1:
			return student.getDepartmentName();
		case 2:
			return student.getDepartmentBoss();
		default:
			return null;
		}
	}
		

		
}
