package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentController;
import controller.SubjectController;
import gui.MainFrame;
import gui.StudentTable;
import gui.SubjectTable;
import listener.StudentFocusListener;
import model.BazaProfessor;
import model.Professor;
import model.Student.Status;
import model.Subject.Semester;

public class AddEditSubjectDialog extends JDialog{

	public static JTextField txtSifraPredmeta, txtNazivPredmeta, txtEspb;
	
	public AddEditSubjectDialog(Frame parent, String title, boolean modal, boolean add) {
		super(parent, title, modal);
		
		setSize(400, 420);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		Dimension dim = new Dimension(180, 20);
		
		JPanel panCentar = new JPanel(new BorderLayout());
		
		JPanel panSifraPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panNazivPredmeta = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panProfesor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panEspb = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblSifraPredmeta = new JLabel("Sifra*:");
		JLabel lblNazivPredmeta = new JLabel("Naziv*:");
		JLabel lblSemestar = new JLabel("Semestar*:");
		JLabel lblGodina = new JLabel("Godina*:");
		JLabel lblProfesor = new JLabel("Profesor*:");
		JLabel lblEspb = new JLabel("ESPB*:");

		txtSifraPredmeta = new JTextField();
		txtNazivPredmeta = new JTextField();
		JComboBox txtSemestar = new JComboBox(Semester.values());
		JComboBox txtGodina = new JComboBox();
		JComboBox txtProfesor = new JComboBox();
		txtEspb = new JTextField();

		
		txtGodina.addItem(1);
		txtGodina.addItem(2);
		txtGodina.addItem(3);
		txtGodina.addItem(4);
		txtGodina.addItem(5);
		txtGodina.addItem(6);
		
		List<Professor> prof = BazaProfessor.getInstance().getProfesori();	
		for(Professor c : prof) {
	           //This does the trick
			txtProfesor.addItem(c);
	       }
		
		JButton potvrdiBtn = new JButton("Potvrdi");
		JButton odustaniBtn = new JButton("Odustani");
		
		lblSifraPredmeta.setPreferredSize(dim);
		lblNazivPredmeta.setPreferredSize(dim);
		lblSemestar.setPreferredSize(dim);
		lblGodina.setPreferredSize(dim);
		lblProfesor.setPreferredSize(dim);
		lblEspb.setPreferredSize(dim);
		
		txtSifraPredmeta.setPreferredSize(dim);
		txtNazivPredmeta.setPreferredSize(dim);
		txtSemestar.setPreferredSize(dim);
		txtGodina.setPreferredSize(dim);
		txtProfesor.setPreferredSize(dim);
		txtEspb.setPreferredSize(dim);

		
		/*txtIme.setName("txtIme");
		txtPrezime.setName("txtPrezime");
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtAdresaStanovanja.setName("txtAdresaStanovanja");
		txtBrojTelefona.setName("txtBrojTelefona");
		txtEmailAdresa.setName("txtEmailAdresa");
		txtBrojIndeksa.setName("txtBrojIndeksa");
		txtGodinaUpisa.setName("txtGodinaUpisa");*/
		
		
		panSifraPredmeta.add(lblSifraPredmeta);
		panSifraPredmeta.add(txtSifraPredmeta);
		
		panNazivPredmeta.add(lblNazivPredmeta);
		panNazivPredmeta.add(txtNazivPredmeta);
		
		panSemestar.add(lblSemestar);
		panSemestar.add(txtSemestar);
		
		panGodina.add(lblGodina);
		panGodina.add(txtGodina);
		
		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor);
		
		panEspb.add(lblEspb);
		panEspb.add(txtEspb);
		
		
		panDugmad.add(potvrdiBtn);
		panDugmad.add(odustaniBtn);
		
//		potvrdiBtn.setEnabled(false);
//		txtIme.addFocusListener(new StudentFocusListener());
//		txtPrezime.addFocusListener(new StudentFocusListener());
//		txtDatumRodjenja.addFocusListener(new StudentFocusListener());
//		txtAdresaStanovanja.addFocusListener(new StudentFocusListener());
//		txtBrojTelefona.addFocusListener(new StudentFocusListener());
//		txtEmailAdresa.addFocusListener(new StudentFocusListener());
//		txtBrojIndeksa.addFocusListener(new StudentFocusListener());
//		txtGodinaUpisa.addFocusListener(new StudentFocusListener());
		
		if(add==false) {
			// AKO JE EDIT, TJ ADDEDIT==2 TREBA SETOVATI VRIJEDNOSTI
			potvrdiBtn.setEnabled(true);
			
			
			SubjectController controllerInstance = SubjectController.getInstance();
			int row = SubjectTable.getInstance().getSelectedRow();
			
			txtSifraPredmeta.setText(controllerInstance.getSubjectByCode(row).getSubjectCode());
			txtNazivPredmeta.setText(controllerInstance.getSubjectByCode(row).getSubjectName());
			txtSemestar.setSelectedItem((Semester)(controllerInstance.getSubjectByCode(row).getSubjectSemester()));
			txtGodina.setSelectedItem((Integer)controllerInstance.getSubjectByCode(row).getSubjectYear());
			txtProfesor.setSelectedItem(controllerInstance.getSubjectByCode(row).getProfessor().toString());
			txtEspb.setText(Integer.toString(controllerInstance.getSubjectByCode(row).getEspb()));
		}

		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		odustaniBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifraPredmeta);
		boxCentar.add(panNazivPredmeta);
		boxCentar.add(panSemestar);
		boxCentar.add(panGodina);
		boxCentar.add(panProfesor);
		boxCentar.add(panEspb);
		boxCentar.add(Box.createGlue());
		
		add(boxCentar, BorderLayout.NORTH);
		add(panDugmad,BorderLayout.SOUTH);
		
	}
}
