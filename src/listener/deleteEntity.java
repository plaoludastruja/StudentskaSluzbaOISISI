package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import gui.dialog.AddStudentDialog;
import gui.dialog.DeleteProfessorDialog;
import gui.dialog.DeleteStudentDialog;

public class deleteEntity implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				DeleteStudentDialog deleteStudentDialog = new DeleteStudentDialog(MainFrame.getInstance(), "Brisanje studenta", true);
				deleteStudentDialog.setVisible(true);
				break;
			case 1:	// PROFESOR
				DeleteProfessorDialog deleteProfessorDialog = new DeleteProfessorDialog(MainFrame.getInstance(), "Brisanje profesora", false);
				int index = MainFrame.getInstance().getTable().getSelectedRow();
				if(index == -1) {
					return;
				}
				deleteProfessorDialog.setRowIndex(index);
				deleteProfessorDialog.setVisible(true);
				break;
			case 2:	// PREDMET
				/*DeleteSubjectDialog deleteSubjectDialog = new DeleteSubjectDialog(MainFrame.getInstance(), "Brisanje predmeta", false);
				deleteSubjectDialog.setVisible(true);*/
				break;
			default:
				break;
		}
		
	}
}
