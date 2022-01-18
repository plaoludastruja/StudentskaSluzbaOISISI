package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import gui.NotPassedTableModel;
import gui.PassingExam;
import gui.StudentTable;
import model.Grade;
import model.Student;
import model.Subject;
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import model.BazaSubject;

public class NotPassedSubject extends JPanel {

	private static NotPassedSubject instance = null;
	private JTable table;

	public static NotPassedSubject getInstance() {
		if (instance == null) {
			instance = new NotPassedSubject();
		}
		return instance;
	}

	public static AbstractTableModelNotPassedTableModel notPassedTableModel;
	public static JTable tabelica;

	private NotPassedSubject() {

		JPanel notPassedSubject = new JPanel(new BorderLayout());

		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj");
		JButton obrisi = new JButton("Obrisi");
		JButton polaganje = new JButton("Polaganje");
		dugme.add(dodaj);
		dugme.add(obrisi);
		dugme.add(polaganje);

		tabelica = new JTable();
		table = new JTable();
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader();

		table.setModel(new NotPassedTableModel());

		tabelica = new JTable();
		tabelica.setRowSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader().setReorderingAllowed(false);
		tabelica.setSelectionBackground(Color.LIGHT_GRAY);

		Vector<String> kolone = new Vector<String>();
		notPassedTableModel = new AbstractTableModelNotPassedTableModel();
		tabelica.setModel(new NotPassedTableModel());

		JScrollPane tabela = new JScrollPane(tabelica);

		/*
		 * Listeneri
		 */

		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNotPassedSubject addNotPassedSubject = new AddNotPassedSubject(MainFrame.getInstance(),
						"Dodavanje predmeta", true);
				addNotPassedSubject.setVisible(true);

			}
		});

		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tabelica.getSelectedRow() != -1) {
					DeleteNotPassedSubject deleteNotPassedSubject = new DeleteNotPassedSubject(MainFrame.getInstance(),
							"Uklanjanje predmeta", true);
					deleteNotPassedSubject.setVisible(true);
				}
			}
		});

		polaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = table.getSelectedRow();
				if (idx == -1) {
					return;
				}
				Student student = StudentController.getInstance()
						.getStudentByID(StudentTable.getInstance().getSelectedRow());
				Subject grade = student.getOtherExams().get(idx);
				PassingExam passingDialog = new PassingExam(MainFrame.getInstance(), "Unos ocene", true);
				passingDialog.setSubject(grade);
				passingDialog.setVisible(true);

			}
		});

		notPassedSubject.add(dugme, BorderLayout.NORTH);
		notPassedSubject.add(tabela, BorderLayout.CENTER);

		add(notPassedSubject);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

}
