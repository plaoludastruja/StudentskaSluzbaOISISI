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


import model.BazaStudent;
import model.Student;


public class SerializableController implements Serializable {

	/**
	 * 
	 */
	//private static final long serialVersionUID = -272424087427384469L;
	
	private List<Student> studenti;

	public static SerializableController instance = null;

	public static SerializableController getInstance() {
		if(instance == null) {
			
			instance = new SerializableController();

		}
		
		return instance;
	}
	
	public SerializableController() {
		studenti = new ArrayList<Student>();
	}
	
	public void serijalizacija() throws FileNotFoundException, IOException, ClassNotFoundException{
	
		studenti = BazaStudent.getInstance().getStudent();

		//Pisanje.
		File f = new File("objectstream.txt");
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)))) {
			oos.writeObject(getInstance());
			oos.close(); //Zatvara i tok nizeg nivoa.
		} finally {
			
		
		}	
	}
		
		public void deserijalizacija() throws FileNotFoundException, IOException, ClassNotFoundException{
			//Citanje.
			File f = new File("objectstream.txt");
			
			
			try(ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)))) {
				SerializableController serializableController;
				serializableController = (SerializableController)ois.readObject();
				BazaStudent.getInstance().setStudent(serializableController.getStudenti());
				ois.close();
			} finally {
				
			}
			
		}
		

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
}
