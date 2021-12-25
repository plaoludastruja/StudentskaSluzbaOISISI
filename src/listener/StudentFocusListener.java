package listener;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.CheckInputStudent;
import gui.dialog.AddEditStudentDialog;
import model.BazaStudent;

public class StudentFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stubv
		JTextField textField = (JTextField) e.getComponent();
		String inputText =  textField.getText();
		String fieldName = textField.getName();
		
		if(textField.getForeground()==Color.RED) {
			textField.setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField textField = (JTextField) e.getComponent();
		String inputText =  textField.getText();
		String fieldName = textField.getName();
		
		boolean check = (
				(CheckInputStudent.checkFirstLastName(inputText) && (fieldName.equals(AddEditStudentDialog.txtIme.getName())))
				|| (CheckInputStudent.checkFirstLastName(inputText) && (fieldName.equals(AddEditStudentDialog.txtPrezime.getName())))
				|| (CheckInputStudent.checkDate(inputText) && (fieldName.equals(AddEditStudentDialog.txtDatumRodjenja.getName())))
				|| (CheckInputStudent.checkAddress(inputText) && (fieldName.equals(AddEditStudentDialog.txtAdresaStanovanja.getName())))
				|| (CheckInputStudent.checkPhone(inputText) && (fieldName.equals(AddEditStudentDialog.txtBrojTelefona.getName())))
				|| (CheckInputStudent.checkEmail(inputText) && (fieldName.equals(AddEditStudentDialog.txtEmailAdresa.getName())))
				|| (CheckInputStudent.checkIndex(inputText) && (fieldName.equals(AddEditStudentDialog.txtBrojIndeksa.getName())) &&  (!(BazaStudent.getInstance().checkIfExists(AddEditStudentDialog.txtBrojIndeksa.getText()))) )
				|| (CheckInputStudent.checkIndexYear(inputText) && (fieldName.equals(AddEditStudentDialog.txtGodinaUpisa.getName())))
				
		);
		if(!check) {
			textField.setForeground(Color.RED);
		}

		if( (AddEditStudentDialog.txtIme.getText().isEmpty()) || (AddEditStudentDialog.txtPrezime.getText().isEmpty())
			|| (AddEditStudentDialog.txtDatumRodjenja.getText().isEmpty()) || (AddEditStudentDialog.txtAdresaStanovanja.getText().isEmpty())
			|| (AddEditStudentDialog.txtBrojTelefona.getText().isEmpty()) || (AddEditStudentDialog.txtEmailAdresa.getText().isEmpty())
			|| (AddEditStudentDialog.txtBrojIndeksa.getText().isEmpty()) || (AddEditStudentDialog.txtGodinaUpisa.getText().isEmpty())
				
		){
			AddEditStudentDialog.potvrdiBtn.setEnabled(false);
		}else if( (AddEditStudentDialog.txtIme.getForeground() == Color.RED) || (AddEditStudentDialog.txtPrezime.getForeground() == Color.RED)
				|| (AddEditStudentDialog.txtDatumRodjenja.getForeground() == Color.RED) || (AddEditStudentDialog.txtAdresaStanovanja.getForeground() == Color.RED)
				|| (AddEditStudentDialog.txtBrojTelefona.getForeground() == Color.RED) || (AddEditStudentDialog.txtEmailAdresa.getForeground() == Color.RED)
				|| (AddEditStudentDialog.txtBrojIndeksa.getForeground() == Color.RED) || (AddEditStudentDialog.txtGodinaUpisa.getForeground() == Color.RED)
		){
				AddEditStudentDialog.potvrdiBtn.setEnabled(false);
		}else {
		
			AddEditStudentDialog.potvrdiBtn.setEnabled(true);
		}
	}

}
