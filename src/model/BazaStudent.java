package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import gui.StudentTable;
import model.Student.Status;


public class BazaStudent {

	private static BazaStudent instance = null;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	
	private List<Student> studenti = new ArrayList<Student>();
	//private List<Student> studentiBaza = new ArrayList<Student>();
	private List<String> kolone = new ArrayList<String>();
	
	public BazaStudent() {
		
		initStudent();
		kolone.add("INDEKS");
		kolone.add("IME");
		kolone.add("PREZIME");
		kolone.add("GODINA STUDIJA");
		kolone.add("STATUS");
		kolone.add("PROSJEK");
	}
	// ne
	// firstName, lastName, dateOfBirth, address, phone,email, index, indexYear, currentYear, averageGrade, studentStatus
	private void initStudent() {
		
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy.");
//		LocalDate datumDjordje = LocalDate.parse("29.02.2000.", formatter);
//		LocalDate datumSandra = LocalDate.parse("27.12.1999.", formatter);
//		Address adresaDjordje = new Address();
//		adresaDjordje.setStreet("Karadjordjeva");
//		adresaDjordje.setStreetNum("L1D");
//		adresaDjordje.setCity("Teslic");
//		adresaDjordje.setCountry("BIH");
//		
//		Student djordje = new Student();
//		djordje.setFirstName("Djordje");
//		djordje.setLastName("Lipovcic");
//		djordje.setDateOfBirth(datumDjordje);
//		djordje.setAddress(adresaDjordje);
//		djordje.setPhone("+387644479985");
//		djordje.setEmail("the2922000@gmail.com");
//		djordje.setIndex("RA125/2019");
//		djordje.setIndexYear(2019);
//		djordje.setCurrentYear(3);
//		djordje.setAverageGrade(8.53);
//		djordje.setStudentStatus(Status.B);
//		
//		
//		Student sandra = new Student();
//		sandra.setFirstName("Sandra");
//		sandra.setLastName("Jovanoviic");
//		sandra.setDateOfBirth(datumSandra);
//		sandra.setAddress(adresaDjordje);
//		sandra.setPhone("+387644479985");
//		sandra.setEmail("jovanovic.ra126.2019@uns.ac.rs");
//		sandra.setIndex("RA126/2019");
//		sandra.setIndexYear(2019);
//		sandra.setCurrentYear(3);
//		sandra.setAverageGrade(8.53);
//		sandra.setStudentStatus(Status.B);
//		
//		studenti.add(djordje);
//		studenti.add(sandra);
		
		/*
		 * 
		 * 
		 */
		Address l1 = new Address("Šafarikova","2","Novi Sad","Srbija");
		Address l2 = new Address("Nikole Tesle","56","Novi Sad","Srbija");
		Address l3 = new Address("Bulevar Patrijarha Pavla","3","Beograd","Srbija");
		Address l4 = new Address("Stražilovska","6a","Novi Sad","Srbija");
		Address l5 = new Address("Nikole Pašića","2d","Kikinda","Srbija");
		Address l6 = new Address("Bulevar Kralja Petra","22","Niš","Srbija");
		Address l7 = new Address("Tolstojeva","31","Novi Sad","Srbija");
		Address l8 = new Address("Marićeva","11","Kragujevac","Srbija");
		Address l9 = new Address("Stražilovska","3","Beograd","Srbija");
		Address l10 = new Address("Nikole Pašića","6a","Novi Sad","Srbija");
		Address l11 = new Address("Bulevar Kralja Petra","2d","Niš","Srbija");
		Address l12 = new Address("Knez Mihajlova","22","Beograd","Srbija");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		List<Subject> student4 = new ArrayList<Subject>();
		student4.add(BazaSubject.getInstance().getSubjectWithKey(2));
		student4.add(BazaSubject.getInstance().getSubjectWithKey(4));
		List<Subject> student17 = new ArrayList<Subject>();
		student17.add(BazaSubject.getInstance().getSubjectWithKey(15));
		List<Subject> student18 = new ArrayList<Subject>();
		student18.add(BazaSubject.getInstance().getSubjectWithKey(15));
		List<Subject> student22 = new ArrayList<Subject>();
		student22.add(BazaSubject.getInstance().getSubjectWithKey(18));
		student22.add(BazaSubject.getInstance().getSubjectWithKey(19));
		List<Subject> student23 = new ArrayList<Subject>();
		student23.add(BazaSubject.getInstance().getSubjectWithKey(18));
		student23.add(BazaSubject.getInstance().getSubjectWithKey(19));
		List<Subject> student24 = new ArrayList<Subject>();
		student24.add(BazaSubject.getInstance().getSubjectWithKey(18));
		student24.add(BazaSubject.getInstance().getSubjectWithKey(19));
		List<Subject> student26 = new ArrayList<Subject>();
		student26.add(BazaSubject.getInstance().getSubjectWithKey(18));
		student26.add(BazaSubject.getInstance().getSubjectWithKey(19));
		
		
		studenti.add(new Student(1,"RA 2/2020",  "Marko","Milosević",1,	LocalDate.parse("12.03.2001.",formatter),	l1	  , "021/333-555","marko.milosevic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Subject>()));
		studenti.add(new Student(2,"RA 3/2019",  "Marija","Milić",2,	LocalDate.parse("12.01.2000.",formatter),	l2	  , "021/555-2222","marija.milic@mailinator.com",Status.S,	2019,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(3,"RA 3/2017" , "Nikola","Nikolić",1,	LocalDate.parse("30.08.2001.",formatter),	l3	  , "021/135-463","nikola.nikolic@mailinator.com",Status.B,	2017,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(4,"RA 134/2015",	  "Pera","Perić",3,	LocalDate.parse("07.06.1995.",formatter),	l4	  , " 021/903-463","pera.peric@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),student4));	
		studenti.add(new Student(5,"RA 5/2019",  "Sofija","Ilić",3,	LocalDate.parse("06.05.1999.",formatter),	l5	  , " 021/731-067","sofija.ilic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(6,"RA 8/2018",	  "Martina","Lukić",3,	LocalDate.parse("16.05.1999.",formatter),	l6	  , "011/4333-800","martina.lukic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(7,"RA 10/2017",	  "Stojan","Stojaković",1,	LocalDate.parse("19.10.2001.",formatter),	l7	  , "011/3130-007","stojan.stojakovic@mailinator.com",Status.B,	2017,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(8,"RA 12/2017", 	  "Milan","Milanović",2,	LocalDate.parse("02.11.2000.",formatter),	l8	  , "015/313-061","milan.milanovic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(9,"RA 16/2019",	  "Miroslav","Milić",2,	LocalDate.parse("11.10.2000.",formatter),	l9	  , "021/351-091","miroslav.milic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(10,"RA 21/2015",	  "Stefan","Gojić",3,	LocalDate.parse("01.05.1999.",formatter),	l10	 , "015/324-500","stefan.gojic@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(11,"RA 9/2020",  "Anastasija","Jokić",3,	LocalDate.parse("11.07.1999.",formatter),	l11	 , "011/2333-900","anastasija.jokic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(12,"RA 4/2017" , "Bogdan","Bogdanović",3,	LocalDate.parse("23.07.1999.",formatter),	l12	 , "021/231-231","bogdan.bogdanovic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(13,"RA 30/2019",	  "Ana","Dabović",1,	LocalDate.parse("12.12.2001.",formatter),	null,	"014/303-007","ana.dabovic@mailinator.com",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(14,"RA 1/2020",  "Mika","Mikić",1,	LocalDate.parse("05.11.2001.",formatter),	l2	  , "015/101-909","mika.mikic@mailinator.com",Status.S,	2020,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(15,"RA 11/2018",	  "Jovan","Deretić",4,	LocalDate.parse("10.09.1998.",formatter),	l3	  , "002/200-300","jovan.deretic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(), new ArrayList<Subject>()));	
		studenti.add(new Student(16,"RA 12/2018",	  "Nikola","Misković",4,	LocalDate.parse("03.08.1998.",formatter),	l4	  , "022/123-456","nikola.miskovic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(), new ArrayList<Subject>()));	
		studenti.add(new Student(17,"RA 13/2018",	  "Martin","Stojanović",4,	LocalDate.parse("01.05.1998.",formatter),	null,	"024/321-775","martin.stojanovic@mailinator.com",Status.S,	2018,new ArrayList<Grade>(),student17));	
		studenti.add(new Student(18,"RA 14/2018",    "Tomislav","Novaković",4,	LocalDate.parse("25.02.1996.",formatter),	l6	  , "011/1188-379","tomislav.novakovic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(),student18));	
		studenti.add(new Student(19,"RA 154/2016",	  "Lena","Ivić",4,	LocalDate.parse("11.05.1998.",formatter),	l7	  , "024/333-555","lena.ivic@mailinator.com",Status.B,	2016,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(20,"RA 23/2020"	, "Jovan","Lazić",1,	LocalDate.parse("22.01.2001.",formatter),	l8	  , "025/1189-479","jovan.lazic@mailinator.com",Status.B,	2020,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(21,"RA 1/2019" , "Isidora","Mikić",2,	LocalDate.parse("31.12.2000.",formatter),	l9	  , "011/1122-366","isidora.mikic@mailinator.com ",Status.B,	2019,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(22,"SW 4/2014" , "Vladimir","Ilić",4,	LocalDate.parse("31.08.1998.",formatter),	l10	 , "0211122-367","vladimir.ilic@mailinator.com",Status.B,	2014,new ArrayList<Grade>(),student22));	
		studenti.add(new Student(23,"SW 17/2015",	  "Mirko","Aličić",3,	LocalDate.parse("21.07.1999.",formatter),	l11	 , "012/1122-368","mirko.alicic@mailinator.com",Status.S,	2015,new ArrayList<Grade>(),student23));	
		studenti.add(new Student(24,"SW 17/2016",	  "Milisav","Perković",4,	LocalDate.parse("28.09.1998.",formatter),	l12	 , "012/1122-369","milisav.pejkovic@mailinator.com",Status.S,	2016,new ArrayList<Grade>(),student24));	
		studenti.add(new Student(25,"SW 27/2018",	  "Puriša","Đorđević",2,	LocalDate.parse("29.02.2000.",formatter),	l3	  , "011/1543-370","purisa.djordjevic@mailinator.com",Status.B,	2018,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		studenti.add(new Student(26,"RA 226/2017",	  "Mikica","Kovačević",3,	LocalDate.parse("23.03.1999.",formatter),	l5	  , "011/1992-371","mikica.kovacevic@mailinator.com",Status.S,	2017,new ArrayList<Grade>(),student26));	
		studenti.add(new Student(27,"SW 12/2021",	  "Miloš","Milić",1,	LocalDate.parse("21.10.2001.",formatter),	l2	  , "011/8172-372","milos.milic@mailinator.com",Status.S,	2021,new ArrayList<Grade>(),new ArrayList<Subject>()));	
		
		List<Grade> studGrade4 = new ArrayList<Grade>();
		studGrade4.add(new Grade(getStudWithKey(4),BazaSubject.getInstance().getSubjectWithKey(5),10,LocalDate.parse("12.12.2017.",formatter)));
		studGrade4.add(new Grade(getStudWithKey(4),BazaSubject.getInstance().getSubjectWithKey(3),9,LocalDate.parse("10.11.2019.",formatter)));
		studGrade4.add(new Grade(getStudWithKey(4),BazaSubject.getInstance().getSubjectWithKey(1),8,LocalDate.parse("11.11.2020.",formatter)));
		getStudWithKey(4).setPassedExams(studGrade4);
		List<Grade> studGrade2 = new ArrayList<Grade>();
		studGrade2.add(new Grade(getStudWithKey(2),BazaSubject.getInstance().getSubjectWithKey(1),10,LocalDate.parse("20.11.2020.",formatter)));
		studGrade2.add(new Grade(getStudWithKey(2),BazaSubject.getInstance().getSubjectWithKey(5),10,LocalDate.parse("30.10.2021.",formatter)));
		getStudWithKey(2).setPassedExams(studGrade2);
		List<Grade> studGrade15 = new ArrayList<Grade>();
		studGrade15.add(new Grade(getStudWithKey(15),BazaSubject.getInstance().getSubjectWithKey(15),7,LocalDate.parse("10.01.2021.",formatter)));
		studGrade15.add(new Grade(getStudWithKey(15),BazaSubject.getInstance().getSubjectWithKey(16),10,LocalDate.parse("01.01.2021.",formatter)));
		getStudWithKey(15).setPassedExams(studGrade15);
		List<Grade> studGrade16 = new ArrayList<Grade>();
		studGrade16.add(new Grade(getStudWithKey(16),BazaSubject.getInstance().getSubjectWithKey(15),10,LocalDate.parse("12.01.2018.",formatter)));
		studGrade16.add(new Grade(getStudWithKey(16),BazaSubject.getInstance().getSubjectWithKey(16),9,LocalDate.parse("04.02.2019.",formatter)));
		getStudWithKey(16).setPassedExams(studGrade16);

		/**
		 * 
		 * 
		 */
	}
	
	public List<Student> getStudent() {
		return studenti;
	}

	public void setStudent(List<Student> studenti) {
		this.studenti = studenti;
	}
	// ne
	public Student getStudent(String idx) {
		for(Student i : studenti) {
			if(i.getIndex().equals(idx)) {
				return i;
			}
		}
		return null;
	}


	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getFirstName();
		case 2:
			return student.getLastName();
		case 3:
			return student.getCurrentYear();
		case 4:
			return student.getStudentStatus();
		case 5:
			return student.getAverageGrade();
		default:
			return null;
		}
	}


	
	public boolean checkIfExists(String index) {
		for(Student i : studenti) {
			if(i.getIndex().equals(index)) {
				return true;
			}
		}
		return false;
	}
	
	public Student getStudentFromlist(int id) {
		return studenti.get(id);
	}
	
	public Student getStudentByID(String idx) {
		for(Student i : studenti) {
			if(i.getIndex().equals(idx)) {
				return i;
			}
		}
		return null;
	}
		
	public void addStudent(Student noviStudent) {
				this.studenti.add(noviStudent);
		
		}

		public void deleteStudent(String index) {
			for (Student i : studenti) {
				if (i.getIndex().equals(index)) {
					studenti.remove(i);
					break;
				}
			}
		}

		public void changeStudent(Student izmjenaStudent) {
			
			for (Student i : studenti) {
				
				if (i.getIndex().equals(BazaStudent.getInstance().getStudentFromlist(StudentTable.getInstance().getSelectedRow()).getIndex())) {
					
					i.setFirstName(izmjenaStudent.getFirstName());
					i.setLastName(izmjenaStudent.getLastName());
					i.setDateOfBirth(izmjenaStudent.getDateOfBirth());
					i.setAddress(izmjenaStudent.getAddress());
					i.setPhone(izmjenaStudent.getPhone());
					i.setEmail(izmjenaStudent.getEmail());
					i.setIndexYear(izmjenaStudent.getIndexYear());
					i.setCurrentYear(izmjenaStudent.getCurrentYear());
					i.setStudentStatus(izmjenaStudent.getStudentStatus());
					i.setAverageGrade(izmjenaStudent.getAverageGrade());
					i.setIndex(izmjenaStudent.getIndex());
					
				}
			}
		}
		
		public Student getStudWithKey(int id) {
			for(Student i : studenti) {
				if(i.getId() == id) {
					return i;
				}
			}
			return null;
		}
	
}
