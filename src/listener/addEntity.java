package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialog.AddProfessorDialog;
import gui.dialog.AddEditSubjectDialog;
import gui.dialog.AddEditStudentDialog;
import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import gui.ToolBar;

public class AddEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				AddEditStudentDialog addStudentDialog = new AddEditStudentDialog(MainFrame.getInstance(), "Dodavanje studenta", true, true);
				addStudentDialog.setVisible(true);
				break;
			case 1:	// PROFESOR
				AddProfessorDialog addProfessorDialog = new AddProfessorDialog(MainFrame.getInstance(), "Dodavanje profesora", true);
				addProfessorDialog.setVisible(true);
				break;
			case 2:	// PREDMET
				AddEditSubjectDialog addSubjectDialog = new AddEditSubjectDialog(MainFrame.getInstance(), "Dodavanje predmeta", true, true);
				addSubjectDialog.setVisible(true);
				break;
			default:
				break;
		}
		
	}
	
}
