package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import gui.AbstractTableModelProfessor;
import gui.AbstractTableModelStudent;
import gui.AbstractTableModelSubject;
import gui.MainFrame;
import gui.ProfessorTable;
//import gui.NotPassedTableModel;
import gui.StudentTable;
import gui.SubjectTable;
import listener.EditEntity;
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
		JButton ponisti = new JButton(MainFrame.getInstance().getResourceBundle().getString("ponistiOcjenu"));
		dugme.add(ponisti, BorderLayout.WEST);

		tabelica = new JTable();
		tabelica.setRowSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader();
		tabelica.setSelectionBackground(Color.LIGHT_GRAY);
		
		DefaultTableModel passedTableModel = new DefaultTableModel();
		Vector<String> kolone = new Vector<String>();

		kolone.add(MainFrame.getInstance().getResourceBundle().getString("sifra1"));
		kolone.add(MainFrame.getInstance().getResourceBundle().getString("naziv1"));
		kolone.add("ESPB");
		kolone.add(MainFrame.getInstance().getResourceBundle().getString("ocjena"));
		kolone.add(MainFrame.getInstance().getResourceBundle().getString("datum"));

		passedTableModel.setColumnIdentifiers(kolone);
		tabelica.setModel(passedTableModel);

		JScrollPane tabela = new JScrollPane(tabelica);


		int sumGrade = 0;
		int sumEspb = 0;
		int countGrade = 0;
		double avgGrade = 0;
		


		Student stud = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
		passedExams = stud.getPassedExams();
		//System.out.println(stud.getPassedExams().size());
		
		for (Grade grade : stud.getPassedExams()) {
			Object[] row = { grade.getSubject().getSubjectCode(), grade.getSubject().getSubjectName(),
					grade.getSubject().getEspb(), grade.getValue(), grade.getExamDate() };
			passedTableModel.addRow(row);
			
			sumGrade += grade.getValue();
			//++countGrade;
			sumEspb += grade.getSubject().getEspb();
			
			if (stud.getPassedExams().size() != 0) {
				avgGrade = (double)sumGrade / (double)stud.getPassedExams().size();
			}

		}

		
		ponisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (JOptionPane.showConfirmDialog(null, MainFrame.getInstance().getResourceBundle().getString("ukloniPredmetSigurni"), MainFrame.getInstance().getResourceBundle().getString("ukloniPredmet"),
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
		JLabel lblProsjek = new JLabel("Prosjek ocjena: " + Double.toString(avgGrade));
		pnlProsjek.add(lblProsjek);

		JPanel pnlEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblEspb = new JLabel("ESPB: " + Integer.toString(sumEspb));
		//lblEspb.setText();
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
