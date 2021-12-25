package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.TabbedPaneMainFrame;
import gui.dialog.EditProfessorDialog;
import model.BazaProfessor;

public class editEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
//				EditStudentDialog editStudentDialog = new EditStudentDialog(MainFrame.getInstance(), "Izmjena studenta", true);
//				editStudentDialog.setVisible(true);
				break;
			case 1:	// PROFESOR
				EditProfessorDialog editProfessorDialog = new EditProfessorDialog(MainFrame.getInstance(), "Izmjena profesora", true);
				int index = MainFrame.getInstance().getTable().getSelectedRow();
				if(index == -1) {
					return;
				}
				editProfessorDialog.setForEdit(BazaProfessor.getInstance().getRow(index));
				editProfessorDialog.setVisible(true);
//				editProfessorDialog.validate();
				
				break;
//			case 2:	// PREDMET
				/*EditSubjectDialog editSubjectDialog = new EditSubjectDialog(MainFrame.getInstance(), "Izmjena predmeta", false);
				editSubjectDialog.setVisible(true);*/
//				break;
			default:
				break;
		}
		
	}
	
}
