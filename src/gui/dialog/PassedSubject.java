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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import gui.AbstractTableModelNotPassedTableModel;
//import gui.NotPassedTableModel;
import gui.StudentTable;
import model.BazaSubject;
import model.Grade;
import model.Student;
import model.Subject;

public class PassedSubject extends JPanel {

	private static PassedSubject instance = null;

	public static PassedSubject getInstance() {
		if (instance == null) {
			instance = new PassedSubject();
		}
		return instance;
	}

	private JTable tabelica;
	private Student currentStudent;
	private List<Grade> passedExams = new ArrayList<Grade>();


	public PassedSubject() {//private

		JPanel passedSubject = new JPanel(new BorderLayout());

		JPanel dugme = new JPanel(new BorderLayout());
		JButton ponisti = new JButton("Ponisti ocjenu");
		dugme.add(ponisti, BorderLayout.WEST);

		tabelica = new JTable();
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


		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		passedExams = stud.getPassedExams();
		System.out.println(stud.getPassedExams().size());
		
		for (Grade grade : stud.getPassedExams()) {
			Object[] row = { grade.getSubject().getSubjectCode(), grade.getSubject().getSubjectName(),
					grade.getSubject().getEspb(), grade.getValue(), grade.getExamDate() };
			passedTableModel.addRow(row);
			sumGrade = sumGrade + grade.getValue();
			++countGrade;
			sumEspb = sumEspb + grade.getSubject().getEspb();
		}

		if (countGrade != 0) {
			avgGrade = sumGrade / countGrade;
		}
		
		ponisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da uklonite predmet?", "Uklanjanje predmeta",
				        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    // yes option
				} else {
				    return;
				}

				int idx = tabelica.getSelectedRow();
				if (idx == -1) {
					return;
				}
				Grade grade = passedExams.get(idx);
				passedExams.remove(idx);
				stud.getOtherExams().add(grade.getSubject());
				DefaultTableModel model = (DefaultTableModel) tabelica.getModel();
				model.removeRow(0);

				
				for (int i = 0; i < model.getRowCount(); i++)
					model.removeRow(i);

				Student student = StudentController.getInstance()
						.getStudentByID(StudentTable.getInstance().getSelectedRow());
				for (Grade g : student.getPassedExams()) {

					Object[] row = { g.getSubject().getSubjectCode(), g.getSubject().getSubjectName(),
							g.getSubject().getEspb(), g.getValue(), g.getExamDate() };
					model.addRow(row);
				}
				model.fireTableDataChanged();
				//NotPassedTableModel modelNotP = (NotPassedTableModel) NotPassedSubject.getInstance().getTable().getModel();
				AbstractTableModelNotPassedTableModel modelNotP = (AbstractTableModelNotPassedTableModel) NotPassedSubject.notPassedTableModel;

				modelNotP.fireTableDataChanged();
			}

		});


		JPanel ispis = new JPanel(new BorderLayout());

		JPanel pnlProsjek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblProsjek = new JLabel("Prosjek ocjena: " + avgGrade);
		pnlProsjek.add(lblProsjek);

		JPanel pnlEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblEspb = new JLabel("ESPB: " + sumEspb);
		pnlEspb.add(lblEspb);

		ispis.add(pnlProsjek, BorderLayout.NORTH);
		ispis.add(pnlEspb, BorderLayout.SOUTH);

		passedSubject.add(dugme, BorderLayout.NORTH);
		passedSubject.add(tabela, BorderLayout.CENTER);
		passedSubject.add(ispis, BorderLayout.SOUTH);

		add(passedSubject);

	}

	public JTable getTabelica() {
		return tabelica;
	}

	public void setTabelica(JTable tabelica) {
		this.tabelica = tabelica;
	}

}
