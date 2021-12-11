package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPaneMainFrame extends JTabbedPane {

	private static TabbedPaneMainFrame instance = null;
	
	public static TabbedPaneMainFrame getInstance() {
		if (instance == null) {
			instance = new TabbedPaneMainFrame();
		}
		return instance;
	}
	private TabbedPaneMainFrame() {
		addTab("Student",new JPanel());
		addTab("Profesor",new JLabel("Profesor"));
		addTab("Predmet",new JLabel("Predmet"));
		//addTab("Student", null, new JScrollPane());
		
	}
	
}