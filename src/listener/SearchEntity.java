package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.SearchController;
import gui.MainFrame;
import gui.TabbedPaneMainFrame;


public class SearchEntity implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				SearchController.getInstance().searchStudent();
				break;
			case 1:	// PROFESOR
				SearchController.getInstance().searchProfessor();
				break;
			case 2:	// PREDMET
				SearchController.getInstance().searchSubject();
				break;
			default:
				break;
		}
		
	}
}