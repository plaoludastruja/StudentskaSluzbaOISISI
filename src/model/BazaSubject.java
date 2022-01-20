package model;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.ProfessorTable;
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
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina");
		this.kolone.add("Semester");

		this.predmeti = new ArrayList<Subject>();
//		Professor prof = BazaProfessor.getInstance().getProfesori().get(0);
//		predmeti.add(new Subject("Sifra1","fizika",Semester.LJETNI,1,prof ,9, null,null)); //bez null
//		predmeti.add(new Subject("Sifra2","engleski jezik",Semester.ZIMSKI,2,prof ,3, null,null));
//		predmeti.add(new Subject("Sifra3","baze podataka",Semester.ZIMSKI,3, prof,8, null,null)); 
/**
 * 
 * 
 */
		predmeti.add(new Subject(1	,   "p1"    ,"Osnove programiranja"	    	    ,1,	7	,BazaProfessor.getInstance().getProfWithKey(2),Semester.ZIMSKI));
		predmeti.add(new Subject(2	,   "p2"    ,"Statistika"		        	    ,3,	8	,BazaProfessor.getInstance().getProfWithKey(2)	    ,Semester.LJETNI));
		predmeti.add(new Subject(3	,   "p3"    ,"Algoritmi i strukture podataka"	,2,	9	,BazaProfessor.getInstance().getProfWithKey(2)	    ,Semester.LJETNI));
		predmeti.add(new Subject(4	,   "p4"    ,"LPRS"				                ,3,	7	,BazaProfessor.getInstance().getProfWithKey(2)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(5	,   "p5"    ,"Matematika"			            ,1,	11	,null	,Semester.LJETNI));
		predmeti.add(new Subject(6	,   "p6"    ,"Xml i web servisi"	           	,4,	6	,null	,Semester.LJETNI));
		predmeti.add(new Subject(7	,   "p7"    ,"Metode optimizacije"		        ,3,	6	,null	,Semester.ZIMSKI));
		predmeti.add(new Subject(8	,   "p8"    ,"Osnove elektortehnike"		    ,1,	11	,BazaProfessor.getInstance().getProfWithKey(5)	    ,Semester.LJETNI));
		predmeti.add(new Subject(9	,   "p9"    ,"Sociologija"			            ,1,	10	,BazaProfessor.getInstance().getProfWithKey(5)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(10,	"p10"	,"Filozofija"		            	,1,	4	,BazaProfessor.getInstance().getProfWithKey(5)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(11,	"p11"	,"ORT"				                ,2,	7	,null	,Semester.LJETNI));
		predmeti.add(new Subject(12,	"p12"	,"NANS"				                ,2,	5	,BazaProfessor.getInstance().getProfWithKey(6)	    ,Semester.LJETNI));
		predmeti.add(new Subject(13,	"p13"	,"Organizacija podataka"		    ,2,	7	,BazaProfessor.getInstance().getProfWithKey(6)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(14,	"p14"	,"Baze podataka"			        ,2,	6	,BazaProfessor.getInstance().getProfWithKey(6)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(15,	"p15"	,"Paralelno programiranje"		    ,2,	8	,BazaProfessor.getInstance().getProfWithKey(7)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(16,	"p16"	,"Konkurentno programiranje"	    ,2,	9	,BazaProfessor.getInstance().getProfWithKey(7)	    ,Semester.LJETNI));
		predmeti.add(new Subject(17,	"p17"	,"Operativni sistemi"		        ,2,	8	,null	,Semester.LJETNI));
		predmeti.add(new Subject(18,	"p18"	,"Algebra"				            ,1,	15	,null	,Semester.ZIMSKI));
		predmeti.add(new Subject(19,	"p19"	,"Diskretna matematika"		        ,3,	14	,null	,Semester.LJETNI));
		predmeti.add(new Subject(20,	"ps20"	,"Upravljački sistemi"		        ,3,	8	,null	,Semester.LJETNI));
		predmeti.add(new Subject(21,	"ps21"	,"Osnovi elektronike"		        ,2,	7	,null	,Semester.ZIMSKI));
		predmeti.add(new Subject(22,	"ps22"	,"Slučajni procesi"		            ,4,	9	,null	,Semester.LJETNI));
		predmeti.add(new Subject(23,	"ps23"	,"Računarstvo visokih performansi"	,4,	10	,null	,Semester.LJETNI));
		predmeti.add(new Subject(24,	"p24"	,"Analiza 1"			            ,1,	20	,null	,Semester.ZIMSKI));
		predmeti.add(new Subject(25,	"it25"	,"Informaciona bezbednost"		    ,4,	9	,BazaProfessor.getInstance().getProfWithKey(17)  	,Semester.LJETNI));
		predmeti.add(new Subject(26,	"it26"	,"Elektronsko placanje"		        ,3,	8	,BazaProfessor.getInstance().getProfWithKey(18)  	,Semester.ZIMSKI));
		predmeti.add(new Subject(27,	"it27"	,"Distribuirani sistemi"		    ,4,	6	,BazaProfessor.getInstance().getProfWithKey(19)	    ,Semester.LJETNI));
		predmeti.add(new Subject(28,	"p28"	,"Projektovanje softvera"		    ,3,	5	,BazaProfessor.getInstance().getProfWithKey(18)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(29,	"p29"	,"Informacioni sistemi"		        ,4,	6	,BazaProfessor.getInstance().getProfWithKey(17)	    ,Semester.ZIMSKI));
		predmeti.add(new Subject(30,	"p30"	,"Mašinsko učenje"			        ,4,	7	,null	,Semester.LJETNI));
		
		/*
		 * 
		 * 
		 * 
		 */
	
	}

	public List<Subject> getSubjects() {
		return predmeti;
	}

	public void setSubject(List<Subject> predmeti) {
		this.predmeti = predmeti;
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
	
	public String getValueAt2(int row, int column) {

		Professor p = ProfessorController.getInstance().getProfessortByID(ProfessorTable.getInstance().getSelectedRow());				
		p.getListofSubjects();
		Subject predmet = p.getListofSubjects().get(row);
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

	public Subject getSubjectWithKey(int id) {
		for(Subject i : predmeti) {
			if(i.getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	
	

}