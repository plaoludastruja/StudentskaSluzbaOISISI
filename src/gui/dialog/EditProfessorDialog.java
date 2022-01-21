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
import javax.swing.JTabbedPane;
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
	private JTextField txtGodine;

	public EditProfessorDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(450, 500);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);

		Dimension dim = new Dimension(180, 20);

		JPanel panCentar = new JPanel(new BorderLayout());

		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panEmailAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panBrojLicneKarte = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panAdresaKancelarije = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panGodine = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		

		JLabel lblIme = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblIme"));
		JLabel lblPrezime = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblPrezime"));
		JLabel lblDatumRodjenja = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblDatumRodjenja"));
		JLabel lblAdresaStanovanja = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblAdresaStanovanja"));
		JLabel lblBrojTelefona = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblBrojTelefona"));
		JLabel lblEmailAdresa = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblEmail"));
		JLabel lblBrojLicneKarte = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblBrojLicne"));
		JLabel lblAdresaKancelarije = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblAdresaKancelarije"));
		JLabel lblZvanje = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblZvanje"));
		JLabel lblGodine = new JLabel(MainFrame.getInstance().getResourceBundle().getString("lblStaz"));

		txtIme = new JTextField();
		txtPrezime = new JTextField();
		txtDatumRodjenja = new JTextField();
		txtAdresaStanovanja = new JTextField();
		txtBrojTelefona = new JTextField();
		txtEmailAdresa = new JTextField();
		txtBrojLicneKarte = new JTextField();
		txtAdresaKancelarije = new JTextField();
		txtZvanje = new JTextField();
		txtGodine = new JTextField();

		JButton potvrdiBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
		JButton odustaniBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));

		lblIme.setPreferredSize(dim);
		lblPrezime.setPreferredSize(dim);
		lblDatumRodjenja.setPreferredSize(dim);
		lblAdresaStanovanja.setPreferredSize(dim);
		lblBrojTelefona.setPreferredSize(dim);
		lblEmailAdresa.setPreferredSize(dim);
		lblBrojLicneKarte.setPreferredSize(dim);
		lblAdresaKancelarije.setPreferredSize(dim);
		lblZvanje.setPreferredSize(dim);
		lblGodine.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtPrezime.setPreferredSize(dim);
		txtDatumRodjenja.setPreferredSize(dim);
		txtAdresaStanovanja.setPreferredSize(dim);
		txtBrojTelefona.setPreferredSize(dim);
		txtEmailAdresa.setPreferredSize(dim);
		txtBrojLicneKarte.setPreferredSize(dim);
		txtAdresaKancelarije.setPreferredSize(dim);
		txtZvanje.setPreferredSize(dim);
		txtGodine.setPreferredSize(dim);

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
		
		panGodine.add(lblGodine);
		panGodine.add(txtGodine);

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
		boxCentar.add(panGodine);
		boxCentar.add(Box.createGlue());

		
		
		panCentar.add(boxCentar, BorderLayout.CENTER);
		panCentar.add(panDugmad, BorderLayout.SOUTH);
		
		JTabbedPane tabbedPaneEditProfessor = new JTabbedPane();
		tabbedPaneEditProfessor.add("Informacije", panCentar);
		tabbedPaneEditProfessor.add("Predmeti", ProfessorOnSubject.getInstance());
		add(tabbedPaneEditProfessor, BorderLayout.NORTH);

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
				int workingYear = Integer.parseInt(txtGodine.getText());
				
				LocalDate dateOfb = null;
				try {
					dateOfb = DateHandler.stringToDate(dateOfBirth);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Pogresan format datuma", "Hey!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				ProfessorController.getInstance().izmeniProfesora(forEdit, name, lastName, dateOfb, null, phone, email, null, idCard,
						position, workingYear);

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
		txtGodine.addKeyListener(keyListener);


		pack();
		
		
	}

	private boolean validateInputInfo() {
		if (txtIme.getText().equals("") || txtPrezime.getText().equals("") || txtDatumRodjenja.getText().equals("")
				|| txtAdresaStanovanja.getText().equals("") || txtBrojTelefona.getText().equals("")
				|| txtEmailAdresa.getText().equals("") || txtBrojLicneKarte.getText().equals("")
				|| txtAdresaKancelarije.getText().equals("") || txtZvanje.getText().equals("")
				|| txtGodine.getText().equals("")) {
			return false;
		}

		LocalDate dateOfb;
		try {
			dateOfb = DateHandler.stringToDate(txtDatumRodjenja.getText());
		} catch (Exception ex) {
			return false;
		}

//		if(!txtDatumRodjenja.getText().matches("\\d{2}.\\d{2}.\\d{4}.")) {
//			return false;
//		}

		String adress = txtAdresaStanovanja.getText();
		String[] adressArray = adress.split(",");
		// System.out.println(adressArray.length);

		if (adressArray.length != 3) {
			return false;
		}
		if (adressArray[0].equals("") || adressArray[1].equals("") || adressArray[2].equals("")) {
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
		txtGodine.setText(Integer.toString(forEdit.getWorkingYear()));
		txtDatumRodjenja.setText(DateHandler.dateToString((forEdit.getDateOfBirth())));
		txtAdresaStanovanja.setText(forEdit.getHomeAddress().adressForDisplay());
		txtAdresaKancelarije.setText(forEdit.getOfficeAddress().adressForDisplay());

	}
}
