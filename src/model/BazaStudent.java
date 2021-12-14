package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;


public class BazaStudent {

	private static BazaStudent instance = null;

	public static BazaStudent getInstance() {
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	
	private List<Student> studenti;
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
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("RA125/2019", "Đorđe", "Lipovcic", 3, Status.B, 8.5));
		studenti.add(new Student("RA126/2021", "Sandra", "Jovanovic", 2, Status.B, 7.25));
		studenti.add(new Student("RA32/2018", "Janko", "Jankovic", 3, Status.S, 9.75));
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

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getIndex();
		case 1:
			return student.getFirstName();
		case 2:
			return student.getLastName();
		case 3:
			return Long.toString(student.getCurrentYear());
		case 4:
			return student.getStudentStatus().toString();
		case 5:
			return Double.toString(student.getAverageGrade());
		default:
			return null;
		}
	}

	/*public void izmeniIgraca(long id, String ime, String prezime, String klub) {
		for (Student i : igraci) {
			if (i.getId() == id) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setKlub(klub);
			}
		}
	}*/
		
		public void addStudent(String index, String firstName, String lastName, int currentYear, Status studentStatus, double averageGrade) {
			this.studenti.add(new Student(index, firstName, lastName, currentYear, studentStatus, averageGrade));
		}

		public void deleteStudent(String index) {
			for (Student i : studenti) {
				if (i.getIndex() == index) {
					studenti.remove(i);
					break;
				}
			}
		}

		/*public void changeStudent(String firstName, String lastName, LocalDate dateOfBirth, Address address, String phone, String email, String index, int indexYear, int currentYear, Status studentStatus) {
			for (Student i : studenti) {
				if (i.getIndex().equals(index)) {
					i.setFirstName(firstName);
					i.setLastName(lastName);
					i.setDateOfBirth(dateOfBirth);
					i.setAddress(address);
					i.setPhone(phone);
					i.setIndexYear(indexYear);
					i.setCurrentYear(currentYear);
					i.setStudentStatus(studentStatus);
					i.setAverageGrade(0.0);
				}
			}
		}*/
		
		/*public boolean checkIfExists(String index) {
			for(Student i : students) {
				if(i.getNumberOfIndex() == index) {
					return true;
				}
			}
			return false;
		}*/
	
}
