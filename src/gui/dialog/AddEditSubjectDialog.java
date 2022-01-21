package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import controller.StudentController;
import controller.SubjectController;
import gui.MainFrame;
import gui.StudentTable;
import gui.SubjectTable;
import listener.StudentFocusListener;
import model.Address;
import model.BazaProfessor;
import model.Professor;
import model.Student;
import model.Student.Status;
import model.Subject;
import model.Subject.Semester;

public class AddEditSubjectDialog extends JDialog {

	public static JTextField txtSifraPredmeta, txtNazivPredmeta, txtEspb;

	public AddEditSubjectDialog(Frame parent, String title, boolean modal, boolean add) {
		super(parent, title, modal);
		
		setSize(400, 300);
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
		
		JLabel lblSifraPredmeta = new JLabel(MainFrame.getInstance().getResourceBundle().getString("sifra"));
		JLabel lblNazivPredmeta = new JLabel(MainFrame.getInstance().getResourceBundle().getString("naziv"));
		JLabel lblSemestar = new JLabel(MainFrame.getInstance().getResourceBundle().getString("semestar"));
		JLabel lblGodina = new JLabel(MainFrame.getInstance().getResourceBundle().getString("godina"));
		JLabel lblProfesor = new JLabel(MainFrame.getInstance().getResourceBundle().getString("profesor"));
		JLabel lblEspb = new JLabel(MainFrame.getInstance().getResourceBundle().getString("espb"));

		txtSifraPredmeta = new JTextField();
		txtNazivPredmeta = new JTextField();
		JComboBox txtSemestar = new JComboBox(Semester.values());
		JComboBox txtGodina = new JComboBox();
		JComboBox txtProfesor = new JComboBox();
		txtEspb = new JTextField();

		Icon iconPlus = new ImageIcon("images" + File.separator + "menubar" + File.separator + "plus.png");
		JButton plus = new JButton(iconPlus);
		plus.setPreferredSize(new Dimension(20, 20));

		Icon iconMinus = new ImageIcon("images" + File.separator + "menubar" + File.separator + "minus.jpg");
		JButton minus = new JButton(iconMinus);
		minus.setPreferredSize(new Dimension(20, 20));

		minus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			}
		});

		plus.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				AddProfessorOnSubjectDialog addProfessorOnSubjectDialog = new AddProfessorOnSubjectDialog();
				addProfessorOnSubjectDialog.setVisible(true);
			}
		});

		txtGodina.addItem(1);
		txtGodina.addItem(2);
		txtGodina.addItem(3);
		txtGodina.addItem(4);
		txtGodina.addItem(5);
		txtGodina.addItem(6);

		List<Professor> prof = BazaProfessor.getInstance().getProfesori();
		for (Professor c : prof) {
			// This does the trick
			txtProfesor.addItem(c);
		}

		JButton potvrdiBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
		JButton odustaniBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));

		lblSifraPredmeta.setPreferredSize(dim);
		lblNazivPredmeta.setPreferredSize(dim);
		lblSemestar.setPreferredSize(dim);
		lblGodina.setPreferredSize(dim);
		lblEspb.setPreferredSize(dim);
		lblProfesor.setPreferredSize(dim);

		txtSifraPredmeta.setPreferredSize(dim);
		txtNazivPredmeta.setPreferredSize(dim);
		txtSemestar.setPreferredSize(dim);
		txtGodina.setPreferredSize(dim);
		txtEspb.setPreferredSize(dim);
		txtProfesor.setPreferredSize(new Dimension(130, 20));

		panSifraPredmeta.add(lblSifraPredmeta);
		panSifraPredmeta.add(txtSifraPredmeta);

		panNazivPredmeta.add(lblNazivPredmeta);
		panNazivPredmeta.add(txtNazivPredmeta);

		panSemestar.add(lblSemestar);
		panSemestar.add(txtSemestar);

		panGodina.add(lblGodina);
		panGodina.add(txtGodina);

		panEspb.add(lblEspb);
		panEspb.add(txtEspb);

		panProfesor.add(lblProfesor);
		panProfesor.add(txtProfesor);
		panProfesor.add(plus);
		panProfesor.add(minus);

		panDugmad.add(potvrdiBtn);
		panDugmad.add(odustaniBtn);

		if (add == false) {
			// AKO JE EDIT, TJ ADDEDIT==2 TREBA SETOVATI VRIJEDNOSTI
			potvrdiBtn.setEnabled(true);

			SubjectController controllerInstance = SubjectController.getInstance();
			int row = SubjectTable.getInstance().getSelectedRow();

			txtSifraPredmeta.setText(controllerInstance.getSubjectByCode(row).getSubjectCode());
			txtNazivPredmeta.setText(controllerInstance.getSubjectByCode(row).getSubjectName());
			txtSemestar.setSelectedItem((Semester) (controllerInstance.getSubjectByCode(row).getSubjectSemester()));
			txtGodina.setSelectedItem((Integer) (controllerInstance.getSubjectByCode(row).getSubjectYear()));
			txtEspb.setText(Integer.toString(controllerInstance.getSubjectByCode(row).getEspb()));
			txtProfesor.setSelectedItem((Professor) (controllerInstance.getSubjectByCode(row).getProfessor()));
		}

		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int intEsbp = Integer.parseInt(txtEspb.getText());

				Semester semester = Semester.values()[txtSemestar.getSelectedIndex()];
				Professor prof = ProfessorController.getInstance().getProfesori().get(txtProfesor.getSelectedIndex());

				Subject noviPredmet = new Subject();
				noviPredmet.setSubjectCode(txtSifraPredmeta.getText());
				noviPredmet.setSubjectName(txtNazivPredmeta.getText());
				noviPredmet.setSubjectSemester(semester);
				noviPredmet.setSubjectYear(txtGodina.getSelectedIndex() + 1);
				noviPredmet.setEspb(intEsbp);
				noviPredmet.setProfessor(prof);

				if (add == true) {
					SubjectController.getInstance().addSubject(noviPredmet);
				} else if (add == false) {
					SubjectController.getInstance().editSubject(SubjectTable.getInstance().getSelectedRow(),
							noviPredmet);

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

		Box boxCentar = Box.createVerticalBox();
		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifraPredmeta);
		boxCentar.add(panNazivPredmeta);
		boxCentar.add(panSemestar);
		boxCentar.add(panGodina);
		boxCentar.add(panEspb);
		boxCentar.add(panProfesor);

		boxCentar.add(Box.createGlue());

		add(boxCentar, BorderLayout.NORTH);
		add(panDugmad, BorderLayout.SOUTH);

	}
}
