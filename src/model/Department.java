package model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private int id;
	private String departmentCode;
	private String departmentName;
	private Professor departmentBoss;
	private List<Professor> departmentProffesor = new ArrayList<Professor>();
	
	public Department(int id, String departmentCode, String departmentName, Professor departmentBoss,
			List<Professor> departmentProffesor) {
		super();
		this.id = id;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.departmentBoss = departmentBoss;
		this.departmentProffesor = departmentProffesor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Department() {
		super();
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Professor getDepartmentBoss() {
		return departmentBoss;
	}

	public void setDepartmentBoss(Professor departmentBoss) {
		this.departmentBoss = departmentBoss;
	}

	public List<Professor> getDepartmentProffesor() {
		return departmentProffesor;
	}

	public void setDepartmentProffesor(List<Professor> departmentProffesor) {
		this.departmentProffesor = departmentProffesor;
	}

	@Override
	public String toString() {
		return "Department [departmentCode=" + departmentCode + ", departmentName=" + departmentName
				+ ", departmentBoss=" + departmentBoss + ", departmentProffesor=" + departmentProffesor + "]";

	}

	}	
	
	

	
	

