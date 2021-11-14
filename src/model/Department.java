package model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private String departmentCode;
	private String departmentName;
	private String departmentBoss;
	private List<Professor> departmentProffesor = new ArrayList<Professor>();
	
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

	public String getDepartmentBoss() {
		return departmentBoss;
	}

	public void setDepartmentBoss(String departmentBoss) {
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
	
	

	
	

