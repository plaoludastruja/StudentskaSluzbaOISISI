package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import dateHandler.DateHandler;
import gui.MainFrame;
import model.Professor;

public class EditProfessorDialog extends JDialog {
	
	Professor forEdit;
	private JTextField txtIme;
	private JTextField txtPrezime;
	private JTextField txtDatumRodjenja;
	private JTextField txtAdresaStanovanja;
	private JTextField txtBrojTelefona;
	private JTextField txtEmailAdresa;
	private JTextField txtBrojLicneKarte;
	private JTextField txtAdresaKancelarije;
	private JTextField txtZvanje;


	public EditProfessorDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 420);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);

		Dimension dim = new Dimension(180, 20);

		JPanel panCentar = new JPanel(new BorderLayout());

		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panEmailAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panBrojLicneKarte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*");
		JLabel lblBrojTelefona = new JLabel("Broj telefona*");
		JLabel lblEmailAdresa = new JLabel("E-mail adresa*");
		JLabel lblBrojLicneKarte = new JLabel("Broj licne karte*");
		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije*");
		JLabel lblZvanje = new JLabel("Zvanje*");

		txtIme = new JTextField();
		txtPrezime = new JTextField();
		txtDatumRodjenja = new JTextField();
		txtAdresaStanovanja = new JTextField();
		txtBrojTelefona = new JTextField();
		txtEmailAdresa = new JTextField();
		txtBrojLicneKarte = new JTextField();
		txtAdresaKancelarije = new JTextField();
		txtZvanje = new JTextField();

		JButton potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");

		lblIme.setPreferredSize(dim);
		lblPrezime.setPreferredSize(dim);
		lblDatumRodjenja.setPreferredSize(dim);
		lblAdresaStanovanja.setPreferredSize(dim);
		lblBrojTelefona.setPreferredSize(dim);
		lblEmailAdresa.setPreferredSize(dim);
		lblBrojLicneKarte.setPreferredSize(dim);
		lblAdresaKancelarije.setPreferredSize(dim);
		lblZvanje.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtPrezime.setPreferredSize(dim);
		txtDatumRodjenja.setPreferredSize(dim);
		txtAdresaStanovanja.setPreferredSize(dim);
		txtBrojTelefona.setPreferredSize(dim);
		txtEmailAdresa.setPreferredSize(dim);
		txtBrojLicneKarte.setPreferredSize(dim);
		txtAdresaKancelarije.setPreferredSize(dim);
		txtZvanje.setPreferredSize(dim);

		panIme.add(lblIme);
		panIme.add(txtIme);

		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);

		panDatumRodjenja.add(lblDatumRodjenja);
		panDatumRodjenja.add(txtDatumRodjenja);

		panAdresaStanovanja.add(lblAdresaStanovanja);
		panAdresaStanovanja.add(txtAdresaStanovanja);

		panBrojTelefona.add(lblBrojTelefona);
		panBrojTelefona.add(txtBrojTelefona);

		panEmailAdresa.add(lblEmailAdresa);
		panEmailAdresa.add(txtEmailAdresa);

		panBrojLicneKarte.add(lblBrojLicneKarte);
		panBrojLicneKarte.add(txtBrojLicneKarte);

		panAdresaKancelarije.add(lblAdresaKancelarije);
		panAdresaKancelarije.add(txtAdresaKancelarije);

		panZvanje.add(lblZvanje);
		panZvanje.add(txtZvanje);

		panDugmad.add(potvrdiBtn);
		panDugmad.add(odustaniBtn);

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panIme);
		boxCentar.add(panPrezime);
		boxCentar.add(panDatumRodjenja);
		boxCentar.add(panAdresaStanovanja);
		boxCentar.add(panBrojTelefona);
		boxCentar.add(panEmailAdresa);
		boxCentar.add(panBrojLicneKarte);
		boxCentar.add(panAdresaKancelarije);
		boxCentar.add(panZvanje);
		boxCentar.add(Box.createGlue());

		add(boxCentar, BorderLayout.NORTH);
		add(panDugmad, BorderLayout.SOUTH);

		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtIme.getText();
				String lastName = txtPrezime.getText();
				String phone = txtBrojTelefona.getText();
				String email = txtEmailAdresa.getText();
				String idCard = txtBrojLicneKarte.getText();
				String position = txtZvanje.getText();
				String dateOfBirth = txtDatumRodjenja.getText();
				String homeAddress = txtAdresaStanovanja.getText();
				String officeAddress = txtAdresaKancelarije.getText();
				LocalDate dateOfb = null;
				try {
					dateOfb = DateHandler.stringToDate(dateOfBirth);					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pogresan format datuma",
						      "Hey!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				ProfessorController.getInstance().izmeniProfesora(forEdit, name, lastName, dateOfb, null, phone, email, null, idCard,
						position, null);
			}
 
		});

		
		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (validateInputInfo()) {
					potvrdiBtn.setEnabled(true);
				} else {
					potvrdiBtn.setEnabled(false);
				}

			}
		};
		
		txtIme.addKeyListener(keyListener);
		txtPrezime.addKeyListener(keyListener);
		txtDatumRodjenja.addKeyListener(keyListener);
		txtAdresaStanovanja.addKeyListener(keyListener);
		txtBrojTelefona.addKeyListener(keyListener);
		txtEmailAdresa.addKeyListener(keyListener);
		txtBrojLicneKarte.addKeyListener(keyListener);
		txtAdresaKancelarije.addKeyListener(keyListener);
		txtZvanje.addKeyListener(keyListener);


		pack();

	}
	
	
	
	private boolean validateInputInfo() {
		if (txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtDatumRodjenja.getText().equals("")
				|| txtAdresaStanovanja.getText().equals("") || txtBrojTelefona.getText().equals("")
				|| txtEmailAdresa.getText().equals("") || txtBrojLicneKarte.getText().equals("")
				|| txtAdresaKancelarije.getText().equals("") || txtZvanje.getText().equals("")) {
			return false;
		}
		
		LocalDate dateOfb;
		try {
			dateOfb = DateHandler.stringToDate(txtDatumRodjenja.getText());
		} catch (Exception ex) {
			return false;
		}

		String adress = txtAdresaStanovanja.getText();
		String[] adressArray = adress.split(",");
		//System.out.println(adressArray.length);
		
		if (adressArray.length != 3) {
			return false;
		}
		if(adressArray[0].equals("") || adressArray[1].equals("") || adressArray[2].equals("")) {
			return false;
		}
		String[] ulicaBr = adressArray[0].split(" ");
		if (ulicaBr.length != 2) {
			return false;
		}
		
		String oAdress = txtAdresaKancelarije.getText();
		String[] oAdressArray = oAdress.split(",");
		if (oAdressArray.length != 3) {
			return false;
		}
		String[] oUlicaBr = adressArray[0].split(" ");
		if (oUlicaBr.length != 2) {
			return false;
		}

		return true;
	}

	
	
	public Professor getForEdit() {
		return forEdit;
	}
	
	public void setForEdit(Professor forEdit) {
		this.forEdit = forEdit;
		
		txtIme.setText(forEdit.getFirstName());
		txtPrezime.setText(forEdit.getLastName());
		txtBrojTelefona.setText(forEdit.getPhone());
		txtEmailAdresa.setText(forEdit.getEmail());
		txtBrojLicneKarte.setText(forEdit.getIdCard());
		txtZvanje.setText(forEdit.getPosition());
		
		txtDatumRodjenja.setText(DateHandler.dateToString((forEdit.getDateOfBirth())));
		txtAdresaStanovanja.setText(forEdit.getHomeAddress().adressForDisplay());
		txtAdresaKancelarije.setText(forEdit.getOfficeAddress().adressForDisplay());
		
	}

}