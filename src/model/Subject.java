package model;

import java.util.ArrayList;
import java.util.List;

public class Subject {

	private String subjectCode;
	private String subjectName;
	private String subjectSemester;
	private int subjectYear;
	private Professor professor;
	private int espb;
	private List<Student> passedSubject = new ArrayList<Student>();
	private List<Student> didntPassSubject = new ArrayList<Student>();
	
	public Subject() {
		super();
	}
}
