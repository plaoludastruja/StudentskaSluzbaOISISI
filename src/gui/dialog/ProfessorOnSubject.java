package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import gui.AbstractTableModelNotPassedTableModel;
import gui.AbstractTableModelProfessorOnSubject;
import gui.MainFrame;

public class ProfessorOnSubject extends JPanel {

	private static ProfessorOnSubject instance = null;
	public static ProfessorOnSubject getInstance() {
		if(instance == null) {
			instance = new ProfessorOnSubject();
		}
		return instance;
	}
	
	
	public static AbstractTableModelProfessorOnSubject proSubTableModel;
	public static JTable profSubTable;
	
	private ProfessorOnSubject() {
	
		
		JPanel profSubjPanel = new JPanel(new BorderLayout());
		
		JPanel dugme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton dodaj = new JButton("Dodaj predmet");
        JButton obrisi = new JButton("Ukloni predmet");

		dugme.add(dodaj);
        dugme.add(obrisi);

		

        profSubTable = new JTable();
        profSubTable.setRowSelectionAllowed(true);
        profSubTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        profSubTable.getTableHeader().setReorderingAllowed(false);
        profSubTable.setSelectionBackground(Color.LIGHT_GRAY);
		 
		//Vector<String> kolone = new Vector<String>();
        proSubTableModel = new AbstractTableModelProfessorOnSubject();
		profSubTable.setModel(proSubTableModel);

		JScrollPane tabela = new JScrollPane(profSubTable);
		
		
		/*
         * Listeneri
         */
        
        dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddSubjectToProfessor addSubjectToProfessor = new AddSubjectToProfessor(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("dodajPredmet"), true);
				addSubjectToProfessor.setVisible(true);
			}
		});
        
        obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(profSubTable.getSelectedRow()!=-1) {
					DeleteSubjectToProfessor deleteSubjectToProfessor = new DeleteSubjectToProfessor(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("ukloniPredmet"), true);
					deleteSubjectToProfessor.setVisible(true);
					
					
				}
			}
		});
        
        profSubjPanel.add(dugme, BorderLayout.NORTH);
        profSubjPanel.add(tabela, BorderLayout.SOUTH);
		add(profSubjPanel);
		}
	
}
