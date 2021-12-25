package listener;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.CheckInputStudent;
import gui.dialog.AddStudentDialog;


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
				(CheckInputStudent.checkFirstLastName(inputText) && (fieldName.equals(AddStudentDialog.txtIme.getName())))
				|| (CheckInputStudent.checkFirstLastName(inputText) && (fieldName.equals(AddStudentDialog.txtPrezime.getName())))
				|| (CheckInputStudent.checkDate(inputText) && (fieldName.equals(AddStudentDialog.txtDatumRodjenja.getName())))
				|| (CheckInputStudent.checkAddress(inputText) && (fieldName.equals(AddStudentDialog.txtAdresaStanovanja.getName())))
				|| (CheckInputStudent.checkPhone(inputText) && (fieldName.equals(AddStudentDialog.txtBrojTelefona.getName())))
				|| (CheckInputStudent.checkEmail(inputText) && (fieldName.equals(AddStudentDialog.txtEmailAdresa.getName())))
				|| (CheckInputStudent.checkIndex(inputText) && (fieldName.equals(AddStudentDialog.txtBrojIndeksa.getName())))
				|| (CheckInputStudent.checkIndexYear(inputText) && (fieldName.equals(AddStudentDialog.txtGodinaUpisa.getName())))
		);
		if(!check) {
			textField.setForeground(Color.RED);
		}

		if( (AddStudentDialog.txtIme.getText().isEmpty()) || (AddStudentDialog.txtPrezime.getText().isEmpty())
			|| (AddStudentDialog.txtDatumRodjenja.getText().isEmpty()) || (AddStudentDialog.txtAdresaStanovanja.getText().isEmpty())
			|| (AddStudentDialog.txtBrojTelefona.getText().isEmpty()) || (AddStudentDialog.txtEmailAdresa.getText().isEmpty())
			|| (AddStudentDialog.txtBrojIndeksa.getText().isEmpty()) || (AddStudentDialog.txtGodinaUpisa.getText().isEmpty())
				
		){
			AddStudentDialog.potvrdiBtn.setEnabled(false);
		}else if( (AddStudentDialog.txtIme.getForeground() == Color.RED) || (AddStudentDialog.txtPrezime.getForeground() == Color.RED)
				|| (AddStudentDialog.txtDatumRodjenja.getForeground() == Color.RED) || (AddStudentDialog.txtAdresaStanovanja.getForeground() == Color.RED)
				|| (AddStudentDialog.txtBrojTelefona.getForeground() == Color.RED) || (AddStudentDialog.txtEmailAdresa.getForeground() == Color.RED)
				|| (AddStudentDialog.txtBrojIndeksa.getForeground() == Color.RED) || (AddStudentDialog.txtGodinaUpisa.getForeground() == Color.RED)
		){
				AddStudentDialog.potvrdiBtn.setEnabled(false);
		}else {
		
			AddStudentDialog.potvrdiBtn.setEnabled(true);
		}
	}

}
