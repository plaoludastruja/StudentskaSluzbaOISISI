package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.BazaDepartment;
import model.BazaProfessor;
import model.BazaStudent;
import model.BazaSubject;
import model.Department;
import model.Professor;
import model.Student;
import model.Subject;


public class SerializableController implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2081809264327306805L;

	private List<Student> studenti;
	private ArrayList<Professor> profesori;
	private List<Subject> predmeti;
	private List<Department> katedre;

	

	public static SerializableController instance = null;

	public static SerializableController getInstance() {
		if(instance == null) {
			
			instance = new SerializableController();

		}
		
		return instance;
	}
	
	public SerializableController() {
		studenti = new ArrayList<Student>();
		profesori = new ArrayList<Professor>();
		predmeti = new ArrayList<Subject>();
		katedre = new ArrayList<Department>();
	}
	
	public void serijalizacija(){
		

		//Pisanje.
		File f = new File("objectstream.txt");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
			studenti = BazaStudent.getInstance().getStudent();
			profesori = BazaProfessor.getInstance().getProfesori();
			predmeti = BazaSubject.getInstance().getSubjects();
			katedre = BazaDepartment.getInstance().getDepartments();

			oos.writeObject(getInstance());
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
		
		public void deserijalizacija(){
			//Citanje.
			File f = new File("objectstream.txt");
			
			
			try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
				
				SerializableController serializableController;
				serializableController = (SerializableController)ois.readObject();
				
				BazaStudent.getInstance().setStudent(serializableController.getStudenti());
				BazaProfessor.getInstance().setProfessor(serializableController.getProfesori());
				BazaSubject.getInstance().setSubject(serializableController.getPredmeti());
				BazaDepartment.getInstance().setDepartment(serializableController.getKatedre());
				ois.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		

	public List<Department> getKatedre() {
			return katedre;
		}

		public void setKatedre(List<Department> katedre) {
			this.katedre = katedre;
		}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public ArrayList<Professor> getProfesori() {
		return profesori;
	}

	public void setProfesori(ArrayList<Professor> profesori) {
		this.profesori = profesori;
	}

	public List<Subject> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Subject> predmeti) {
		this.predmeti = predmeti;
	}
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
}
