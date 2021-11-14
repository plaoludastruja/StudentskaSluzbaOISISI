package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;

public class Student {

	public enum Status { B, S; }
	
	private String lastName;
	private String firstName;
	private LocalDate dateOfBirth;
	private String adress;
	private String phone;
	private String email;
	private String index;
	private int indexYear;
	private int currentYear;
	private Status studentStatus;
	private double averageGrade;
	private List<Grade> passedExams = new ArrayList<Grade>();
	private List<Subject> otherExams = new ArrayList<Subject>();
	
	public Student() {
		super();
	}

	
	
}
