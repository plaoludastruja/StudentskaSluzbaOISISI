package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class TabbedPane extends JTabbedPane {

	public TabbedPane() {
		addTab("Student",new JPanel());
		addTab("Profesor",new JLabel("Profesor"));
		addTab("Predmet",new JLabel("Predmet"));
		//addTab("Student", null, new JScrollPane());
		
	}
}