package gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
		addTab("Profesor",new JLabel("Profesor"));
		addTab("Predmet",new JLabel("Predmet"));
		//addTab("Student", null, new JScrollPane());
		
	}
	
	public void azurirajPrikaz(String akcija, int vrednost) {
		AbstractTableModelStudent model = (AbstractTableModelStudent) StudentTable.getInstance().getModel();
		// azuriranje modela tabele, kao i njenog prikaza
		model.fireTableDataChanged();
		validate();
	}
	
}