package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import gui.StudentTable;
import model.BazaSubject;
import model.Grade;
import model.Student;


public class NotPassedSubject extends JPanel {

	private static NotPassedSubject instance = null;
	public static NotPassedSubject getInstance() {
		if(instance == null) {
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
		tabelica.setRowSelectionAllowed(true);
		tabelica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelica.getTableHeader().setReorderingAllowed(false);
		tabelica.setSelectionBackground(Color.LIGHT_GRAY);
		 
		Vector<String> kolone = new Vector<String>();
		notPassedTableModel = new AbstractTableModelNotPassedTableModel();
		tabelica.setModel(notPassedTableModel);

		JScrollPane tabela = new JScrollPane(tabelica);
		
		
		/*
         * Listeneri
         */
        
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddNotPassedSubject addNotPassedSubject = new AddNotPassedSubject(MainFrame.getInstance(), "Dodavanje predmeta", true);
				addNotPassedSubject.setVisible(true);
	
			}
		});
        
        obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tabelica.getSelectedRow()!=-1) {
					DeleteNotPassedSubject deleteNotPassedSubject = new DeleteNotPassedSubject(MainFrame.getInstance(), "Uklanjanje predmeta", true);
					deleteNotPassedSubject.setVisible(true);
				}
			}
		});
        
		notPassedSubject.add(dugme, BorderLayout.NORTH);
		notPassedSubject.add(tabela, BorderLayout.CENTER);
		
		add(notPassedSubject);
		}
}
