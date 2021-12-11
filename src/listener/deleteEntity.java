package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import gui.dialog.AddStudentDialog;
import gui.dialog.DeleteStudentDialog;

public class deleteEntity implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				DeleteStudentDialog deleteStudentDialog = new DeleteStudentDialog(MainFrame.getInstance(), "Brisanje studenta", false);
				deleteStudentDialog.setVisible(true);
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
