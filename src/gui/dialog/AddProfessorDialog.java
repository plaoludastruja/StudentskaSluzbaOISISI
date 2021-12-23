package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.MainFrame;

public class AddProfessorDialog extends JDialog {


		public AddProfessorDialog(Frame parent, String title, boolean modal) {
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
			JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
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
			JLabel lblTitula = new JLabel("Titula*");
			JLabel lblZvanje = new JLabel("Zvanje*");
			
			JTextField txtIme = new JTextField();
			JTextField txtPrezime = new JTextField();
			JTextField txtDatumRodjenja = new JTextField();
			JTextField txtAdresaStanovanja = new JTextField();
			JTextField txtBrojTelefona = new JTextField();
			JTextField txtEmailAdresa = new JTextField();
			JTextField txtBrojLicneKarte = new JTextField();
			JTextField txtAdresaKancelarije = new JTextField();
			JTextField txtTitula = new JTextField();
			JTextField txtZvanje = new JTextField();
			
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
			lblTitula.setPreferredSize(dim);
			lblZvanje.setPreferredSize(dim);
			
			txtIme.setPreferredSize(dim);
			txtPrezime.setPreferredSize(dim);
			txtDatumRodjenja.setPreferredSize(dim);
			txtAdresaStanovanja.setPreferredSize(dim);
			txtBrojTelefona.setPreferredSize(dim);
			txtEmailAdresa.setPreferredSize(dim);
			txtBrojLicneKarte.setPreferredSize(dim);
			txtAdresaKancelarije.setPreferredSize(dim);
			txtTitula.setPreferredSize(dim);
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
			
			panTitula.add(lblTitula);
			panTitula.add(txtTitula);
			
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
			boxCentar.add(panTitula);
			boxCentar.add(panZvanje);
			boxCentar.add(Box.createGlue());
			
			
			add(boxCentar, BorderLayout.NORTH);
			add(panDugmad,BorderLayout.SOUTH);
			

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}