package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MainFrame;
import gui.ToolBar;
import model.Student;

public class AddStudentDialog extends JDialog {

	public AddStudentDialog(Frame parent, String title, boolean modal) {
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
		
		JTextField txtIme = new JTextField();
		JTextField txtPrezime = new JTextField();
		JTextField txtDatumRodjenja = new JTextField();
		JTextField txtAdresaStanovanja = new JTextField();
		JTextField txtBrojTelefona = new JTextField();
		JTextField txtEmailAdresa = new JTextField();
		JTextField txtBrojIndeksa = new JTextField();
		JTextField txtGodinaUpisa = new JTextField();
		JComboBox txtTrenutnaGodinaStudija = new JComboBox();
		JComboBox txtNacinFinansiranja = new JComboBox();
		
		JButton potvrdiBtn = new JButton("Potvrdi");
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
		
// ************************************* //	
		
		
		/*txtIme.setPreferredSize(dim);
		txtPrezime.setPreferredSize(dim);
		txtDatumRodjenja.setPreferredSize(dim);
		txtAdresaStanovanja.setPreferredSize(dim);
		txtBrojTelefona.setPreferredSize(dim);
		txtEmailAdresa.setPreferredSize(dim);
		txtBrojIndeksa.setPreferredSize(dim);
		txtGodinaUpisa.setPreferredSize(dim);
		txtTrenutnaGodinaStudija.setPreferredSize(dim);
		txtNacinFinansiranja.setPreferredSize(dim);*/
		
		
		
		
		
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
		
		
		add(boxCentar, BorderLayout.NORTH);
		add(panDugmad,BorderLayout.SOUTH);
		

	}
}
