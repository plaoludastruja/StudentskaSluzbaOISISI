package gui.dialog;

import java.awt.BorderLayout;
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

public class PassedSubject extends JPanel {

	private static PassedSubject instance = null;
	public static PassedSubject getInstance() {
		if(instance == null) {
			instance = new PassedSubject();
		}
		return instance;
	}
	
	
	private List<Grade> passedExams = new ArrayList<Grade>();
	private void initPassedExams() {
		
	}
	
	public PassedSubject() {
	
//		Grade ocena = new Grade();
//		ocena.setStudent(BazaStudent.getInstance().getStudent().get(0));
//		ocena.setValue(10);
//		LocalDate date = LocalDate.parse("29.02.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy."));
//		ocena.setExamDate(date);
//		ocena.setSubject(BazaSubject.getInstance().getSubjects().get(0));
//		passedExams.add(ocena);
//		System.out.println(BazaStudent.getInstance().getStudent().get(0).getPassedExams());
//		
//		System.out.println(ocena);
		
		JPanel passedSubject = new JPanel(new BorderLayout());
		
		JPanel dugme = new JPanel(new BorderLayout());
		JButton ponisti = new JButton("Ponisti ocjenu");
		dugme.add(ponisti,BorderLayout.WEST);
		

		
		
		
		JTable tabelica = new JTable();
		tabelica.setRowSelectionAllowed(true);
		tabelica.setColumnSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader();
		
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
		
		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		
		
		for(Grade grade : stud.getPassedExams()) {
			
			Object[] row = {grade.getSubject().getSubjectCode(), grade.getSubject().getSubjectName(),
					grade.getSubject().getEspb(), grade.getValue(), grade.getExamDate()};
			passedTableModel.addRow(row);
			sumGrade = sumGrade + grade.getValue();
			++countGrade;
			sumEspb = sumEspb + grade.getSubject().getEspb();

		}
		
		if(countGrade!=0) {
			avgGrade = sumGrade / countGrade;
		}
		
		
		ponisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Grade ocena = new Grade();
				Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
				ocena.setStudent(s);
				ocena.setValue(10);
				LocalDate date = LocalDate.parse("29.02.2000.", DateTimeFormatter.ofPattern("dd.MM.yyyy."));
				ocena.setExamDate(date);
				ocena.setSubject(BazaSubject.getInstance().getSubjects().get(0));
//				for(Grade grade : stud.getPassedExams()) {
//					
//					Object[] row = {grade.getSubject().getSubjectCode(), grade.getSubject().getSubjectName(),
//							grade.getSubject().getEspb(), grade.getValue(), grade.getExamDate()};
//					passedTableModel.addRow(row);
//					sumGrade = sumGrade + grade.getValue();
//					++countGrade;
//					sumEspb = sumEspb + grade.getSubject().getEspb();
					Object[] row = {ocena.getSubject().getSubjectCode(), ocena.getSubject().getSubjectName(),
							ocena.getSubject().getEspb(), ocena.getValue(), ocena.getExamDate()};
					passedTableModel.addRow(row);

				//}
				
				s.getPassedExams().add(ocena);
				//passedExams.add(ocena);
//				for(Grade gr : s.getPassedExams()) {
//					System.out.println(gr);
//				}
				
				System.out.println(ocena);
	
			}
		});
		
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