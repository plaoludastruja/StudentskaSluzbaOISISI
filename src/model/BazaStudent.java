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
	private List<String> kolone = new ArrayList<String>();;
	
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
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy.");
		LocalDate datumDjordje = LocalDate.parse("29.02.2000.", formatter);
		LocalDate datumSandra = LocalDate.parse("27.12.1999.", formatter);
		Address adresaDjordje = new Address();
		adresaDjordje.setStreet("Karadjordjeva");
		adresaDjordje.setStreetNum("L1D");
		adresaDjordje.setCity("Teslic");
		adresaDjordje.setCountry("BIH");
		
		Student djordje = new Student();
		djordje.setFirstName("Đorđe");
		djordje.setLastName("Lipovčić");
		djordje.setDateOfBirth(datumDjordje);
		djordje.setAddress(adresaDjordje);
		djordje.setPhone("+387644479985");
		djordje.setEmail("the2922000@gmail.com");
		djordje.setIndex("RA125/2019");
		djordje.setIndexYear(2019);
		djordje.setCurrentYear(3);
		djordje.setAverageGrade(8.53);
		djordje.setStudentStatus(Status.B);
		
		Student sandra = new Student();
		sandra.setFirstName("Sandra");
		sandra.setLastName("Jovanović");
		sandra.setDateOfBirth(datumSandra);
		sandra.setAddress(adresaDjordje);
		sandra.setPhone("+387644479985");
		sandra.setEmail("jovanovic.ra126.2019@uns.ac.rs");
		sandra.setIndex("RA126/2019");
		sandra.setIndexYear(2019);
		sandra.setCurrentYear(3);
		sandra.setAverageGrade(8.53);
		sandra.setStudentStatus(Status.B);
		
		studenti.add(djordje);
		studenti.add(sandra);
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
	
	public Student getStudentByID(int id) {
		return studenti.get(id);
	}
		
	public void addStudent(Student noviStudent) {
				this.studenti.add(noviStudent);
		
		}

		public void deleteStudent(String index) {
			for (Student i : studenti) {
				if (i.getIndex() == index) {
					studenti.remove(i);
					break;
				}
			}
		}

		public void changeStudent(Student izmjenaStudent) {
			
			for (Student i : studenti) {
				
				if (i.getIndex().equals(BazaStudent.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow()).getIndex())) {
					
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
		
		
	
}
