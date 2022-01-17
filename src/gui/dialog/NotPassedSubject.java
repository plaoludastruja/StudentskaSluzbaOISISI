package gui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import gui.MainFrame;
import gui.NotPassedTableModel;
import gui.PassingExam;
import gui.StudentTable;
import model.Grade;
import model.Student;

public class NotPassedSubject extends JPanel {

	private ArrayList<Grade> notPassed;
	private static NotPassedSubject instance = null;
	private JTable table;

	public static NotPassedSubject getInstance() {
		if (instance == null) {
			instance = new NotPassedSubject();
		}
		return instance;
	}

	public NotPassedSubject() {

		JPanel notPassedSubject = new JPanel(new BorderLayout());

		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj");
		JButton obrisi = new JButton("Obrisi");
		JButton polaganje = new JButton("Polaganje");
		dugme.add(dodaj);
		dugme.add(obrisi);
		dugme.add(polaganje);

		table = new JTable();
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader();

		table.setModel(new NotPassedTableModel());

		JScrollPane tabela = new JScrollPane(table);

		notPassedSubject.add(dugme, BorderLayout.NORTH);
		notPassedSubject.add(tabela, BorderLayout.CENTER);

		add(notPassedSubject);
		
		
		polaganje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if(idx == -1) {
					return;
				}				
				Student student = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
				Grade grade = student.getOtherExams().get(idx);
				PassingExam passingDialog = new PassingExam(MainFrame.getInstance(), "Unos ocene", true);
				passingDialog.setGrade(grade);
				passingDialog.setVisible(true);
				
			}
		});

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}