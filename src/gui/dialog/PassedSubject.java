package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import gui.PassedTable;
import gui.StudentTable;
import model.BazaStudent;
import model.BazaSubject;
import model.Grade;
import model.Student;
import model.Subject;

public class PassedSubject extends JPanel {

	private static PassedSubject instance = null;
	public static PassedSubject getInstance() {
		if(instance == null) {
			instance = new PassedSubject();
		}
		return instance;
	}
	
	//public static PassedSubject pass = new PassedSubject();
	
	private List<Grade> passedExams = new ArrayList<Grade>();
	private void initPassedExams() {
		
	}
	
	private PassedSubject() {
	
		
		JPanel passedSubject = new JPanel(new BorderLayout());
		
		JPanel dugme = new JPanel(new BorderLayout());
		JButton ponisti = new JButton("Ponisti ocjenu");
		dugme.add(ponisti,BorderLayout.WEST);
		

		
		
		
		JTable tabelica = new JTable();
		tabelica.setRowSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader();
		tabelica.setSelectionBackground(Color.LIGHT_GRAY);
		
		DefaultTableModel passedTableModel = new DefaultTableModel();
		Vector<String> kolone = new Vector<String>();

		kolone.add("SifraPredmeta");
		kolone.add("ImePredmeta");
		kolone.add("ESPB");
		kolone.add("Ocjena");
		kolone.add("Datum");
		
		
		
		passedTableModel.setColumnIdentifiers(kolone);
		tabelica.setModel(passedTableModel);
		
		
		
		
		JScrollPane tabela = new JScrollPane(tabelica);

		
		int sumGrade = 0;
		int sumEspb = 0;
		int countGrade = 0;
		double avgGrade = 0;
		
		

		

		
		JPanel ispis = new JPanel(new BorderLayout());
		
		JPanel pnlProsjek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblProsjek = new JLabel("Prosjek ocjena: " + avgGrade);
		pnlProsjek.add(lblProsjek);
		
		JPanel pnlEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblEspb= new JLabel("ESPB: " + sumEspb);
		pnlEspb.add(lblEspb);
		
		ispis.add(pnlProsjek, BorderLayout.NORTH);
		ispis.add(pnlEspb, BorderLayout.SOUTH);
		
		passedSubject.add(dugme, BorderLayout.NORTH);
		passedSubject.add(tabela, BorderLayout.CENTER);
		passedSubject.add(ispis,BorderLayout.SOUTH);
		
		add(passedSubject);
		
		
		
		
		
		
		
		}
}
