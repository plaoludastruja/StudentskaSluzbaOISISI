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

import controller.ProfessorController;
import controller.StudentController;
import gui.AbstractTableModelNotPassedTableModel;
import gui.AbstractTableModelPassedTableModel;
import gui.AbstractTableModelProfessor;
import gui.AbstractTableModelProfessorOnSubject;
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
import model.Professor;
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
		
		tabelica.setModel(new AbstractTableModelPassedTableModel());

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
			//passedTableModel.addRow(row);
			
			sumGrade += grade.getValue();
			//++countGrade;
			sumEspb += grade.getSubject().getEspb();
			
			
		}
		
		if (stud.getPassedExams().size() != 0 && !stud.getPassedExams().isEmpty()) {
			avgGrade = (double)sumGrade / (double)stud.getPassedExams().size();
		}
		
		ponisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = tabelica.getSelectedRow();
				if (idx == -1) {
					JOptionPane.showMessageDialog(PassedSubject.this, "Izaberite predmet!", "Greska",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				if (JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da uklonite predmet?",
						"Uklanjanje predmeta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				} else {
					return;
				}

				Subject predmet = BazaSubject.getInstance().getSubjectByCode(tabelica.getValueAt(tabelica.getSelectedRow(), 0).toString());
				Professor p = ProfessorController.getInstance().getProfessortByID(ProfessorTable.getInstance().getSelectedRow());	
					//p.getListofSubjects().remove(predmet);
				//stud.getPassedExams().get
				Grade grade = passedExams.get(idx);
				passedExams.remove(idx);
				stud.getOtherExams().add(grade.getSubject());
				
				predmet.getPassedSubject().remove(stud);
				predmet.getDidntPassSubject().add(stud);
				AbstractTableModelPassedTableModel model = (AbstractTableModelPassedTableModel) tabelica.getModel();
				model.fireTableDataChanged();

				AbstractTableModelNotPassedTableModel modelNotP = (AbstractTableModelNotPassedTableModel) NotPassedSubject.notPassedTableModel;

				modelNotP.fireTableDataChanged();

			}

		});


		JPanel ispis = new JPanel(new BorderLayout());

		JPanel pnlProsjek = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblProsjek = new JLabel(MainFrame.getInstance().getResourceBundle().getString("prosjek") + avgGrade);
		pnlProsjek.add(lblProsjek);

		JPanel pnlEspb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblEspb = new JLabel("ESPB: " + sumEspb);
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
