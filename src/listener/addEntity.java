package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.dialog.AddStudentDialog;
import gui.MainFrame;
import gui.ToolBar;

public class addEntity implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		AddStudentDialog addStudentDialog = new AddStudentDialog(MainFrame.getInstance(), "Dodavanje studenta", false);
		addStudentDialog.setVisible(true);
	}
	
}
