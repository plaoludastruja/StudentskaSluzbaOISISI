package model;

import java.time.LocalDate;
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
	private void initStudent() {
		/*studenti.add(new Student("RA125/2019", "Đorđe", "Lipovcic", 3, Status.B, 8.5));
		studenti.add(new Student("RA126/2021", "Sandra", "Jovanovic", 2, Status.B, 7.25));
		studenti.add(new Student("RA32/2018", "Janko", "Jankovic", 3, Status.S, 9.75));*/
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

	/*private long generateId() {
		return ++generator;
	}*/

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

	
	public Student getStudentByID(int id) {
		return studenti.get(id);
	}
		
		//public void addStudent(String index, String firstName, String lastName, int currentYear, Status studentStatus, double averageGrade) {
	public void addStudent(String firstName, String lastName, LocalDate dateOfBirth, Address address, String phone,
			String email, String index, int indexYear, int currentYear, double averageGrade, Status studentStatus) {
		
			this.studenti.add(new Student(firstName, lastName, dateOfBirth, address, phone,email, index, indexYear, currentYear, averageGrade, studentStatus));
		}

		public void deleteStudent(String index) {
			for (Student i : studenti) {
				if (i.getIndex() == index) {
					studenti.remove(i);
					break;
				}
			}
		}

		public void changeStudent(String firstName, String lastName, LocalDate dateOfBirth, Address address, String phone,
				String email, String index, int indexYear, int currentYear, double averageGrade, Status studentStatus) {
			
			for (Student i : studenti) {
				
				if (i.getIndex().equals(BazaStudent.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow()).getIndex())) {
					
					i.setFirstName(firstName);
					i.setLastName(lastName);
					i.setDateOfBirth(dateOfBirth);
					i.setAddress(address);
					i.setPhone(phone);
					i.setEmail(email);
					i.setIndexYear(indexYear);
					i.setCurrentYear(currentYear);
					i.setStudentStatus(studentStatus);
					i.setAverageGrade(0.0);
					i.setIndex(index);
				}
			}
		}
		
		/*public boolean checkIfExists(String index) {
			for(Student i : students) {
				if(i.getNumberOfIndex() == index) {
					return true;
				}
			}
			return false;
		}*/
	
}
