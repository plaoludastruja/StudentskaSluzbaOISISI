package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Grade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8537713376842735506L;
	
	private Student student;
	private Subject subject;
	private int value;
	private LocalDate examDate;
	
	
	
	public Grade(Student student, Subject subject, int value, LocalDate examDate) {
		super();
		this.student = student;
		this.subject = subject;
		this.value = value;
		this.examDate = examDate;
	}

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
