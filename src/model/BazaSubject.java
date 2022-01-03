package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import controller.StudentController;
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
	private List<String> kolone;

	Professor prof = new Professor();
	private BazaSubject() {
		generator = 0;

		this.kolone = new ArrayList<String>();
		this.kolone.add("ŠIFRA PREDMETA");
		this.kolone.add("NAZIV PREDMETA");
		this.kolone.add("BROJ ESPB BODOVA");
		this.kolone.add("GODINA NA KOJOJ SE PREDMET IZVODI");
		this.kolone.add("SEMESTAR U KOME SE PREDMET IZVODI");

		this.predmeti = new ArrayList<Subject>();
		Professor prof = BazaProfessor.getInstance().getProfesori().get(1);
		predmeti.add(new Subject("Sifra1","fizika",Semester.LETNJI,1,prof ,9, null,null));
		predmeti.add(new Subject("Sifra2","engleski jezik",Semester.ZIMSKI,2,prof ,3, null,null));
		predmeti.add(new Subject("Sifra3","baze podataka",Semester.ZIMSKI,3, prof,8, null,null)); 
		/*predmeti.add(new Subject());
		predmeti.add(new Subject());
		predmeti.add(new Subject());*/
		
		
		
	
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


	public void izbrisiPredmet(int row) { // brise red u tabeli
		predmeti.remove(row);
	}


}