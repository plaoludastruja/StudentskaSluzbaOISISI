package model;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import controller.StudentController;
import controller.SubjectController;
import gui.StudentTable;
import gui.SubjectTable;
import gui.dialog.AddNotPassedSubject;
import model.Subject.Semester;

public class BazaSubject {
	private static BazaSubject instance = null;

	public static BazaSubject getInstance() {
		if (instance == null) {
			instance = new BazaSubject();
		}
		return instance;
	}

	private long generator;

	private List<Subject> predmeti;
	public ArrayList<Subject> searched;	
	private List<String> kolone;
	private boolean searchedDone;	

	Professor prof = new Professor();
	private BazaSubject() {
		generator = 0;
		searched = new ArrayList<Subject>();
		searchedDone = false;

		this.kolone = new ArrayList<String>();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA NA KOJOJ SE PREDMET IZVODI");
		this.kolone.add("SEMESTAR U KOME SE PREDMET IZVODI");

		this.predmeti = new ArrayList<Subject>();
		Professor prof = BazaProfessor.getInstance().getProfesori().get(0);
		predmeti.add(new Subject("Sifra1","fizika",Semester.LETNJI,1,prof ,9, null,null));
		predmeti.add(new Subject("Sifra2","engleski jezik",Semester.ZIMSKI,2,prof ,3, null,null));
		predmeti.add(new Subject("Sifra3","baze podataka",Semester.ZIMSKI,3, prof,8, null,null)); 

	
	}

	public List<Subject> getSubjects() {
		return predmeti;
	}

	private long generateId() {
		return ++generator;
	}

	public int getColumnCount() {
		return kolone.size();
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Subject predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSubjectCode();
		case 1:
			return predmet.getSubjectName();
		case 2:
			return predmet.getEspb()+"";
		case 3:
			return predmet.getSubjectYear()+"";
		case 4:
			return predmet.getSubjectSemester()+"";
		default:
			return null;
		}

	}
	
	public String getValueAt1(int row, int column) {

		Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());				
		s.getOtherExams();
		Subject predmet = s.getOtherExams().get(row);
		switch (column) {
		case 0:
			return predmet.getSubjectCode();
		case 1:
			return predmet.getSubjectName();
		case 2:
			return predmet.getEspb()+"";
		case 3:
			return predmet.getSubjectYear()+"";
		case 4:
			return predmet.getSubjectSemester()+"";
		default:
			return null;
		}

	}
	public Subject getSubjectFromList(int code) {
		return predmeti.get(code);
	}
	public Subject getSubjectByCode(String code) {
		for(Subject i : predmeti) {
			if(i.getSubjectCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
	

		
	
	public void addSubject(Subject noviPredmet) {
		this.predmeti.add(noviPredmet);

	}
	
	/*public void deleteSubject(String code) {
		for (Subject i : predmeti) {
			if (i.getSubjectCode() == code ) {
				predmeti.remove(i);
				break;
			}
		}
	}*/
	
	public void deleteSubject(String code) { // brise red u tabeli
		for(Subject i : predmeti) {
			if(i.getSubjectCode().equals(code)) {
				predmeti.remove(i);
				break;
			}
		}
	}
	
	


	public void changeSubject(Subject izmjenaPredmet) {
		
		for (Subject i : predmeti) {
			
			if (i.getSubjectCode().equals(BazaSubject.getInstance().getSubjectFromList(SubjectTable.getInstance().getSelectedRow()).getSubjectCode())) {
				
				i.setSubjectCode(izmjenaPredmet.getSubjectCode());
				i.setSubjectName(izmjenaPredmet.getSubjectName());
				i.setSubjectSemester(izmjenaPredmet.getSubjectSemester());
				i.setSubjectYear(izmjenaPredmet.getSubjectYear());
				i.setProfessor(izmjenaPredmet.getProfessor());
				i.setEspb(izmjenaPredmet.getEspb());

				
			}
		}
	}
	
	
	public void getSubjectNameCode(String name, String code) {
		searched.clear();
		searchedDone = true;
		for (Subject s : predmeti) {
			if (code == null) {
				if (s.getSubjectName().toLowerCase().contains(name)) {
					searched.add(s);
				}
			} else {
				if (s.getSubjectName().toLowerCase().contains(name) && s.getSubjectCode().toLowerCase().contains(code)) {
					searched.add(s);
				}
			}
		}

	}

	public boolean isSearchedDone() {
		return searchedDone;
	}

	public Subject getRowSearch(int rowIndex) {
		return this.searched.get(rowIndex);
	}

	public String getValueAtSearch(int row, int column) {

		Subject predmet = this.searched.get(row);
		switch (column) {
		case 0:
			return predmet.getSubjectCode();
		case 1:
			return predmet.getSubjectName();
		case 2:
			return predmet.getEspb()+"";
		case 3:
			return predmet.getSubjectYear()+"";
		case 4:
			return predmet.getSubjectSemester()+"";
		default:
			return null;
		}

	}

	public ArrayList<Subject> getSearched() {
		return searched;
	}

	
	
	
	

}