package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.StudentController;
import listener.StudentFocusListener;
import gui.AbstractTableModelProfessor;
import gui.AbstractTableModelStudent;
import gui.AbstractTableModelSubject;
import gui.MainFrame;
import gui.PassedTable;
import gui.ProfessorTable;
import gui.StudentTable;
import gui.SubjectTable;
import gui.ToolBar;
import model.Address;
import model.Student;
import model.Student.Status;
import gui.dialog.PassedSubject;

public class AddEditStudentDialog extends JDialog {

	public static JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresaStanovanja, txtBrojTelefona, txtEmailAdresa,
			txtBrojIndeksa, txtGodinaUpisa;
	public static JButton potvrdiBtn;
	// public PassedSubject passed = new PassedSubject();

	public AddEditStudentDialog(Frame parent, String title, boolean modal, boolean add) {
		super(parent, title, modal);

		if (add) {
			setSize(400, 420);
		} else {
			setSize(400, 500);
		}
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);

		Dimension dim = new Dimension(180, 20);

		JPanel panCentar = new JPanel(new BorderLayout());
		Box hor = Box.createHorizontalBox();

		JPanel panIme = new JPanel();
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panAdresaStanovanja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panBrojTelefona = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panEmailAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panBrojIndeksa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panTrenutnaGodinaStudija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panNacinFinansiranja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));

		JLabel lblIme = new JLabel("Ime*:");
		JLabel lblPrezime = new JLabel("Prezime*:");
		JLabel lblDatumRodjenja = new JLabel("Datum rođenja*:");
		JLabel lblAdresaStanovanja = new JLabel("Adresa stanovanja*:");
		JLabel lblBrojTelefona = new JLabel("Broj telefona*:");
		JLabel lblEmailAdresa = new JLabel("E-mail adresa*:");
		JLabel lblBrojIndeksa = new JLabel("Broj indeksa*:");
		JLabel lblGodinaUpisa = new JLabel("Godina upisa*:");
		JLabel lblTrenutnaGodinaStudija = new JLabel("Trenutna godina studija*:");
		JLabel lblNacinFinansiranja = new JLabel("Način finansiranja*:");

		txtIme = new JTextField();
		txtPrezime = new JTextField();
		txtDatumRodjenja = new JTextField();
		txtAdresaStanovanja = new JTextField();
		txtBrojTelefona = new JTextField();
		txtEmailAdresa = new JTextField();
		txtBrojIndeksa = new JTextField();
		txtGodinaUpisa = new JTextField();
		JComboBox txtTrenutnaGodinaStudija = new JComboBox();
		JComboBox txtNacinFinansiranja = new JComboBox(Status.values());

		txtTrenutnaGodinaStudija.addItem(1);
		txtTrenutnaGodinaStudija.addItem(2);
		txtTrenutnaGodinaStudija.addItem(3);
		txtTrenutnaGodinaStudija.addItem(4);
		txtTrenutnaGodinaStudija.addItem(5);
		txtTrenutnaGodinaStudija.addItem(6);

		potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");

		lblIme.setPreferredSize(dim);
		lblPrezime.setPreferredSize(dim);
		lblDatumRodjenja.setPreferredSize(dim);
		lblAdresaStanovanja.setPreferredSize(dim);
		lblBrojTelefona.setPreferredSize(dim);
		lblEmailAdresa.setPreferredSize(dim);
		lblBrojIndeksa.setPreferredSize(dim);
		lblGodinaUpisa.setPreferredSize(dim);
		lblTrenutnaGodinaStudija.setPreferredSize(dim);
		lblNacinFinansiranja.setPreferredSize(dim);

		txtIme.setPreferredSize(dim);
		txtPrezime.setPreferredSize(dim);
		txtDatumRodjenja.setPreferredSize(dim);
		txtAdresaStanovanja.setPreferredSize(dim);
		txtBrojTelefona.setPreferredSize(dim);
		txtEmailAdresa.setPreferredSize(dim);
		txtBrojIndeksa.setPreferredSize(dim);
		txtGodinaUpisa.setPreferredSize(dim);
		txtTrenutnaGodinaStudija.setPreferredSize(dim);
		txtNacinFinansiranja.setPreferredSize(dim);

		txtIme.setName("txtIme");
		txtPrezime.setName("txtPrezime");
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtAdresaStanovanja.setName("txtAdresaStanovanja");
		txtBrojTelefona.setName("txtBrojTelefona");
		txtEmailAdresa.setName("txtEmailAdresa");
		txtBrojIndeksa.setName("txtBrojIndeksa");
		txtGodinaUpisa.setName("txtGodinaUpisa");

		hor.add(lblIme);
		hor.add(Box.createHorizontalGlue());
		hor.add(txtIme);
		panIme.add(hor);
		/*
		 * MRS U PIZDU MATErinu
		 */
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

		panBrojIndeksa.add(lblBrojIndeksa);
		panBrojIndeksa.add(txtBrojIndeksa);

		panGodinaUpisa.add(lblGodinaUpisa);
		panGodinaUpisa.add(txtGodinaUpisa);

		panTrenutnaGodinaStudija.add(lblTrenutnaGodinaStudija);
		panTrenutnaGodinaStudija.add(txtTrenutnaGodinaStudija);

		panNacinFinansiranja.add(lblNacinFinansiranja);
		panNacinFinansiranja.add(txtNacinFinansiranja);

		panDugmad.add(potvrdiBtn);
		panDugmad.add(odustaniBtn);

		potvrdiBtn.setEnabled(false);
		txtIme.addFocusListener(new StudentFocusListener());
		txtPrezime.addFocusListener(new StudentFocusListener());
		txtDatumRodjenja.addFocusListener(new StudentFocusListener());
		txtAdresaStanovanja.addFocusListener(new StudentFocusListener());
		txtBrojTelefona.addFocusListener(new StudentFocusListener());
		txtEmailAdresa.addFocusListener(new StudentFocusListener());
		txtBrojIndeksa.addFocusListener(new StudentFocusListener());
		txtGodinaUpisa.addFocusListener(new StudentFocusListener());

		if (add == false) {
			// AKO JE EDIT, TJ ADDEDIT==2 TREBA SETOVATI VRIJEDNOSTI
			potvrdiBtn.setEnabled(true);

			StudentController controllerInstance = StudentController.getInstance();
			int row = StudentTable.getInstance().getSelectedRow();

			txtIme.setText(controllerInstance.getStudentByID(row).getFirstName());
			txtPrezime.setText(controllerInstance.getStudentByID(row).getLastName());
			txtDatumRodjenja.setText(controllerInstance.getStudentByID(row).getDateOfBirth()
					.format(DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
			txtAdresaStanovanja.setText(controllerInstance.getStudentByID(row).getAddress().toString());
			txtBrojTelefona.setText(controllerInstance.getStudentByID(row).getPhone());
			txtEmailAdresa.setText(controllerInstance.getStudentByID(row).getEmail());
			txtBrojIndeksa.setText(controllerInstance.getStudentByID(row).getIndex());
			txtGodinaUpisa.setText(Integer.toString(controllerInstance.getStudentByID(row).getIndexYear()));
			txtTrenutnaGodinaStudija
					.setSelectedItem((Integer) (controllerInstance.getStudentByID(row).getCurrentYear()));
			txtNacinFinansiranja.setSelectedItem((Status) (controllerInstance.getStudentByID(row).getStudentStatus()));
		}

		/*
		 * txtIme.setText(StudentController.getInstance().getStudentByID(StudentTable.
		 * getInstance().getSelectedRow()).getFirstName());
		 * txtPrezime.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getLastName());
		 * txtDatumRodjenja.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getDateOfBirth().format(
		 * DateTimeFormatter.ofPattern("dd.MM.yyyy.")));
		 * txtAdresaStanovanja.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getAddress().toString());
		 * txtBrojTelefona.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getPhone());
		 * txtEmailAdresa.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getEmail());
		 * txtBrojIndeksa.setText(StudentController.getInstance().getStudentByID(
		 * StudentTable.getInstance().getSelectedRow()).getIndex());
		 * txtGodinaUpisa.setText(Integer.toString(StudentController.getInstance().
		 * getStudentByID(StudentTable.getInstance().getSelectedRow()).getIndexYear()));
		 * txtTrenutnaGodinaStudija.setSelectedItem((Integer)(StudentController.
		 * getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow()).
		 * getCurrentYear()));
		 * txtNacinFinansiranja.setSelectedItem((Status)(StudentController.getInstance()
		 * .getStudentByID(StudentTable.getInstance().getSelectedRow()).getStudentStatus
		 * ()));
		 */
		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int intGodinaUpisa = Integer.parseInt(txtGodinaUpisa.getText());

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
				LocalDate dateDatumRodjenja = LocalDate.parse(txtDatumRodjenja.getText(), formatter);

				Address addressAdresaStanovanja = new Address();
				String[] addressPart = txtAdresaStanovanja.getText().split(",", 4);
				addressAdresaStanovanja.setStreet(addressPart[0]);
				addressAdresaStanovanja.setStreetNum(addressPart[1]);
				addressAdresaStanovanja.setCity(addressPart[2]);
				addressAdresaStanovanja.setCountry(addressPart[3]);

				Status status = Status.values()[txtNacinFinansiranja.getSelectedIndex()];

				Student noviStudent = new Student();
				noviStudent.setFirstName(txtIme.getText());
				noviStudent.setLastName(txtPrezime.getText());
				noviStudent.setDateOfBirth(dateDatumRodjenja);
				noviStudent.setAddress(addressAdresaStanovanja);
				noviStudent.setPhone(txtBrojTelefona.getText());
				noviStudent.setEmail(txtEmailAdresa.getText());
				noviStudent.setIndex(txtBrojIndeksa.getText());
				noviStudent.setIndexYear(intGodinaUpisa);
				noviStudent.setCurrentYear(txtTrenutnaGodinaStudija.getSelectedIndex() + 1);
				noviStudent.setAverageGrade(10.00);
				noviStudent.setStudentStatus(status);
				if (add == true) {
					StudentController.getInstance().addStudent(noviStudent);
				} else if (add == false) {
					StudentController.getInstance().editStudent(StudentTable.getInstance().getSelectedRow(),
							noviStudent);

				}
				dispose();
			}
		});

		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

// ************************************* //	

// ************************************* //	

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panIme);
		boxCentar.add(panPrezime);
		boxCentar.add(panDatumRodjenja);
		boxCentar.add(panAdresaStanovanja);
		boxCentar.add(panBrojTelefona);
		boxCentar.add(panEmailAdresa);
		boxCentar.add(panBrojIndeksa);
		boxCentar.add(panGodinaUpisa);
		boxCentar.add(panTrenutnaGodinaStudija);
		boxCentar.add(panNacinFinansiranja);
		boxCentar.add(Box.createGlue());

		if (add) {
			add(boxCentar, BorderLayout.NORTH);
			add(panDugmad, BorderLayout.SOUTH);
		} else {
			JTabbedPane tabbedPanneEditStudent = new JTabbedPane();
			panCentar.add(boxCentar, BorderLayout.CENTER);
			panCentar.add(panDugmad, BorderLayout.SOUTH);

			tabbedPanneEditStudent.add("Informacije", panCentar);
			

			tabbedPanneEditStudent.add("Polozeni", PassedSubject.getInstance());
			tabbedPanneEditStudent.add("Nepolozeni", NotPassedSubject.getInstance());
			add(tabbedPanneEditStudent, BorderLayout.NORTH);
			pack();
		}

	}
}
