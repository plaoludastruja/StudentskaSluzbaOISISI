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
//		Professor prof = BazaProfessor.getInstance().getProfesori().get(0);
//		Department mate = new Department();
//		mate.setDepartmentCode("ID1");
//		mate.setDepartmentName("MATE");
//		mate.setDepartmentBoss(prof);
//		
//		Department jezik = new Department();
//		
//		jezik.setDepartmentCode("ID2");
//		jezik.setDepartmentName("JEZIK");
//		jezik.setDepartmentBoss(prof);
		
		/*
		 * 
		 * 
		 */

		List<Professor> professorsOnDepartment1 = new ArrayList<Professor>();
		professorsOnDepartment1.add(BazaProfessor.getInstance().getProfWithKey(1));
		professorsOnDepartment1.add(BazaProfessor.getInstance().getProfWithKey(7));
		professorsOnDepartment1.add(BazaProfessor.getInstance().getProfWithKey(13));
		professorsOnDepartment1.add(BazaProfessor.getInstance().getProfWithKey(19));
		List<Professor> professorsOnDepartment2 = new ArrayList<Professor>();
		professorsOnDepartment2.add(BazaProfessor.getInstance().getProfWithKey(2));
		professorsOnDepartment2.add(BazaProfessor.getInstance().getProfWithKey(8));
		professorsOnDepartment2.add(BazaProfessor.getInstance().getProfWithKey(14));
		List<Professor> professorsOnDepartment3 = new ArrayList<Professor>();
		professorsOnDepartment3.add(BazaProfessor.getInstance().getProfWithKey(3));
		professorsOnDepartment3.add(BazaProfessor.getInstance().getProfWithKey(9));
		professorsOnDepartment3.add(BazaProfessor.getInstance().getProfWithKey(15));
		List<Professor> professorsOnDepartment4 = new ArrayList<Professor>();
		professorsOnDepartment4.add(BazaProfessor.getInstance().getProfWithKey(4));
		professorsOnDepartment4.add(BazaProfessor.getInstance().getProfWithKey(10));
		professorsOnDepartment4.add(BazaProfessor.getInstance().getProfWithKey(16));
		List<Professor> professorsOnDepartment5 = new ArrayList<Professor>();
		professorsOnDepartment5.add(BazaProfessor.getInstance().getProfWithKey(5));
		professorsOnDepartment5.add(BazaProfessor.getInstance().getProfWithKey(11));
		professorsOnDepartment5.add(BazaProfessor.getInstance().getProfWithKey(17));
		List<Professor> professorsOnDepartment6 = new ArrayList<Professor>();
		professorsOnDepartment6.add(BazaProfessor.getInstance().getProfWithKey(6));
		professorsOnDepartment6.add(BazaProfessor.getInstance().getProfWithKey(12));
		professorsOnDepartment6.add(BazaProfessor.getInstance().getProfWithKey(18));
		
		katedre.add(new Department(1,	"e42",	"Katedra za matematiku",	BazaProfessor.getInstance().getProfWithKey(2),professorsOnDepartment1));                    
		katedre.add(new Department(2,	"e43",	"Katedra za fiziku",	BazaProfessor.getInstance().getProfWithKey(3),professorsOnDepartment2));
		katedre.add(new Department(3,	"e44",	"Katedra za elektrotehniku",	BazaProfessor.getInstance().getProfWithKey(4),professorsOnDepartment3));
		katedre.add(new Department(4,	"e45",	"Katedra za primenjene računarske nauke",	BazaProfessor.getInstance().getProfWithKey(7),professorsOnDepartment4));
		katedre.add(new Department(5,	"e46",	"Katedra za informatiku",	BazaProfessor.getInstance().getProfWithKey(13),professorsOnDepartment5));
		katedre.add(new Department(6,	"e47",	"Katedra za automatiku",	BazaProfessor.getInstance().getProfWithKey(18),professorsOnDepartment6));
		/*
		 * 
		 * 
		 */
//		katedre.add(mate);
//		katedre.add(jezik);
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
