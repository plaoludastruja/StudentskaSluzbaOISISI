package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.StudentTable;
import gui.TabbedPaneMainFrame;
import gui.dialog.AddEditStudentDialog;
import gui.dialog.DeleteProfessorDialog;
import gui.dialog.DeleteStudentDialog;
import gui.dialog.DeleteSubjectDialog;

public class DeleteEntity implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
			case 0:	// STUDENT
				if(StudentTable.getInstance().getSelectedRow()!=-1) {
					DeleteStudentDialog deleteStudentDialog = new DeleteStudentDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("brisanjestudenta"), true);
					deleteStudentDialog.setVisible(true);
				}
				break;
			case 1:	// PROFESOR
				DeleteProfessorDialog deleteProfessorDialog = new DeleteProfessorDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("brisanjeprofesora"), false);
				int index = MainFrame.getInstance().getTable().getSelectedRow();
				if(index == -1) {
					return;
				}
				deleteProfessorDialog.setRowIndex(index);
				deleteProfessorDialog.setVisible(true);
				break;
			case 2:	// PREDMET
				DeleteSubjectDialog deleteSubjectDialog = new DeleteSubjectDialog(MainFrame.getInstance(), MainFrame.getInstance().getResourceBundle().getString("brisanjepredmeta"), false);
				int index1 = MainFrame.getInstance().getTable().getSelectedRow();
				if(index1 == -1) {
					return;
				}
				deleteSubjectDialog.setRowIndex(index1);
				deleteSubjectDialog.setVisible(true);
				break;
			default:
				break;
		}
		
	}
}
