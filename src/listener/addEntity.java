package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialog.AddStudentDialog;
import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import gui.ToolBar;

public class addEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				AddStudentDialog addStudentDialog = new AddStudentDialog(MainFrame.getInstance(), "Dodavanje studenta", true);
				addStudentDialog.setVisible(true);
				break;
			case 1:	// PROFESOR
				/*AddProfessorDialog addProfessorDialog = new AddProfessortDialog(MainFrame.getInstance(), "Dodavanje profesora", false);
				addProfessorDialog.setVisible(true);*/
				break;
			case 2:	// PREDMET
				/*AddSubjectDialog addSubjectDialog = new AddSubjectDialog(MainFrame.getInstance(), "Dodavanje predmeta", false);
				addSubjectDialog.setVisible(true);*/
				break;
			default:
				break;
		}
		
	}
	
}
