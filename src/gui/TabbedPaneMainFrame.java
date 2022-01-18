package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import gui.dialog.AddNotPassedSubject;
import model.BazaStudent;

public class TabbedPaneMainFrame extends JTabbedPane {

	private static TabbedPaneMainFrame instance = null;
	
	public static TabbedPaneMainFrame getInstance() {
		if (instance == null) {
			instance = new TabbedPaneMainFrame();
		}
		return instance;
	}
	
	private TabbedPaneMainFrame() {
		
		addTab("Student",new JScrollPane(StudentTable.getInstance()));
		addTab("Profesor",new JScrollPane(ProfessorTable.getInstance()));
		addTab("Predmet",new JScrollPane(SubjectTable.getInstance()));
		//addTab("Student", null, new JScrollPane());
		
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentTable.getInstance().getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		AbstractTableModelProfessor modelProfessor = (AbstractTableModelProfessor) ProfessorTable.getInstance().getModel();
		AbstractTableModelSubject modelSubject = (AbstractTableModelSubject) SubjectTable.getInstance().getModel();

		model.fireTableDataChanged();
		modelProfessor.fireTableDataChanged();
		modelSubject.fireTableDataChanged();
		validate();
	}
	
}