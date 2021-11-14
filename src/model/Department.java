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
}
