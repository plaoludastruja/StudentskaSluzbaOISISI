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

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectSemester() {
		return subjectSemester;
	}

	public void setSubjectSemester(String subjectSemester) {
		this.subjectSemester = subjectSemester;
	}

	public int getSubjectYear() {
		return subjectYear;
	}

	public void setSubjectYear(int subjectYear) {
		this.subjectYear = subjectYear;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getPassedSubject() {
		return passedSubject;
	}

	public void setPassedSubject(List<Student> passedSubject) {
		this.passedSubject = passedSubject;
	}

	public List<Student> getDidntPassSubject() {
		return didntPassSubject;
	}

	public void setDidntPassSubject(List<Student> didntPassSubject) {
		this.didntPassSubject = didntPassSubject;
	}

	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", subjectSemester="
				+ subjectSemester + ", subjectYear=" + subjectYear + ", professor=" + professor + ", espb=" + espb
				+ ", passedSubject=" + passedSubject + ", didntPassSubject=" + didntPassSubject + "]";
	}
	
	
}
