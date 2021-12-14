package model;

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
		studenti.add(new Student("RA45/2019", "Marko", "Markovic", 3, Status.B, 8.5));
		studenti.add(new Student("RA182/2021", "Jovan", "Jovanovic", 2, Status.S, 7.25));
		studenti.add(new Student("RA32/2018", "Janko", "Jankovic", 3, Status.B, 9.75));
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

	/*public void dodajIgraca(String ime, String prezime, String klub) {
		this.igraci.add(new Student(generateId(), ime, prezime, klub));
	}

	public void izbrisiIgraca(long id) {
		for (Student i : igraci) {
			if (i.getId() == id) {
				igraci.remove(i);
				break;
			}
		}
	}

	public void izmeniIgraca(long id, String ime, String prezime, String klub) {
		for (Student i : igraci) {
			if (i.getId() == id) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setKlub(klub);
			}
		}
	}*/
		
		public void addStudent(String index, String name, String surname, int year, Status st, Double avg) {
			this.studenti.add(new Student(index, name, surname, year, st, avg));
		}

		public void deleteStudent(String numIndex) {
			for (Student i : studenti) {
				if (i.getIndex() == numIndex) {
					studenti.remove(i);
					break;
				}
			}
		}

		/*public void changeStudent(String name, String surname, LocalDate birthDate, Address address, String phoneNum, String mail, String index, int yearIn, int currentYear, Status status) {
			for (Student i : studenti) {
				if (i.getNumberOfIndex().equals(index)) {
					i.setName(name);
					i.setSurname(surname);
					i.setBirthDate(birthDate);
					i.setAddress(address);
					i.setPhoneNumber(phoneNum);
					i.setEnrollmentYear(yearIn);
					i.setCurrentYear(currentYear);
					i.setStatus(status);
					i.setAverageGrade(0.0);
				}
			}
		}
		
		public boolean checkIfExists(String index) {
			for(Student i : students) {
				if(i.getNumberOfIndex() == index) {
					return true;
				}
			}
			return false;
		}*/
	
}
