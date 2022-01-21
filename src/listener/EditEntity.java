package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.StudentTable;
import gui.SubjectTable;
import gui.TabbedPaneMainFrame;
import gui.dialog.AddEditStudentDialog;
import gui.dialog.AddEditSubjectDialog;
import gui.dialog.DeleteProfessorDialog;
import gui.dialog.EditProfessorDialog;
import model.BazaProfessor;


public class EditEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				if(StudentTable.getInstance().getSelectedRow()!=-1) {
					AddEditStudentDialog editStudentDialog = new AddEditStudentDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("izmjenaStudenta"), true, false);
					editStudentDialog.setVisible(true);
				}
				
				break;
			case 1:	// PROFESOR
				//EditProfessorDialog editProfessorDialog = new EditProfessorDialog(MainFrame.getInstance(), "Izmjena profesora", true);
				//addProfessorDialog.setVisible(true);
				EditProfessorDialog editProfessorDialog = new EditProfessorDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("izmjenaProfesora"), true);
				int index = MainFrame.getInstance().getTable().getSelectedRow();
				if(index == -1) {
					return;
				}
				editProfessorDialog.setForEdit(BazaProfessor.getInstance().getRow(index));
				editProfessorDialog.setVisible(true);
//				editProfessorDialog.validate();
				break;
			case 2:	// PREDMET
				if(SubjectTable.getInstance().getSelectedRow()!=-1) {
					AddEditSubjectDialog editSubjectDialog = new AddEditSubjectDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("izmjenaPredmeta"), true, false);
					editSubjectDialog.setVisible(true);
				}
				
				break;
			default:
				break;
		}
		
	}
	
}
