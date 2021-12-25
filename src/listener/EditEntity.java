package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.StudentTable;
import gui.TabbedPaneMainFrame;
import gui.dialog.AddEditStudentDialog;


public class EditEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				if(StudentTable.getInstance().getSelectedRow()!=-1) {
					AddEditStudentDialog editStudentDialog = new AddEditStudentDialog(MainFrame.getInstance(), "Izmjena studenta", true, false);
					editStudentDialog.setVisible(true);
				}
				
				break;
			case 1:	// PROFESOR
				//EditProfessorDialog editProfessorDialog = new EditProfessorDialog(MainFrame.getInstance(), "Izmjena profesora", true);
				//addProfessorDialog.setVisible(true);
				break;
			case 2:	// PREDMET
				/*EditSubjectDialog addSubjectDialog = new EditSubjectDialog(MainFrame.getInstance(), "Izmjena predmeta", false);
				editSubjectDialog.setVisible(true);*/
				break;
			default:
				break;
		}
		
	}
	
}