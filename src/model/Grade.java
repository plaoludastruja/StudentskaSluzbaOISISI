package model;

import java.time.LocalDate;

public class Grade {

	private Student student;
	private Subject subject;
	private int value;
	private LocalDate examDate;
	
	public Grade() {
		super();
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LocalDate getExamDate() {
		return examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "Grade [student=" + student + ", subject=" + subject + ", value=" + value + ", examDate=" + examDate
				+ "]";
	}

	
	
	
	
	
}
