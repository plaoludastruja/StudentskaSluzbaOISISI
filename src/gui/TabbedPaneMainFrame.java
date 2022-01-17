package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

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




		
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentTable.getInstance().getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		AbstractTableModelProfessor modelP = (AbstractTableModelProfessor) ProfessorTable.getInstance().getModel();
		AbstractTableModelSubject modelPR = (AbstractTableModelSubject) SubjectTable.getInstance().getModel();

		model.fireTableDataChanged();
		modelP.fireTableDataChanged();
		modelPR.fireTableDataChanged();
		validate();
	}
	
}