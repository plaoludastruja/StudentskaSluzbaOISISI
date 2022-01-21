package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.StudentController;
import dateHandler.DateHandler;
import gui.dialog.NotPassedSubject;
import gui.dialog.PassedSubject;
import model.Grade;
import model.Student;
import model.Subject;

public class PassingExam extends JDialog {

	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtDatum;
	private JButton potvrdiBtn;
	private JButton odustaniBtn;
	private JComboBox<String> gradeList;
	private Subject currentSubject;

	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JLabel lblOcena;
	private JLabel lblDatum;

	public PassingExam(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 420);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);

		Dimension dim = new Dimension(120, 20);

		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));

		lblSifra = new JLabel(MainFrame.getInstance().getResourceBundle().getString("sifra"));
		lblNaziv = new JLabel(MainFrame.getInstance().getResourceBundle().getString("naziv"));
		lblOcena = new JLabel(MainFrame.getInstance().getResourceBundle().getString("ocjena1"));
		lblDatum = new JLabel(MainFrame.getInstance().getResourceBundle().getString("datum1"));

		String niz[] = {"6", "7", "8", "9", "10" };

		txtSifra = new JTextField();
		txtNaziv = new JTextField();
		gradeList = new JComboBox<String>(niz);
		txtDatum = new JTextField();

		potvrdiBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
		odustaniBtn = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));

		lblSifra.setPreferredSize(dim);
		lblNaziv.setPreferredSize(dim);
		lblOcena.setPreferredSize(dim);
		lblDatum.setPreferredSize(dim);
		gradeList.setPreferredSize(dim);

		txtSifra.setPreferredSize(dim);
		txtNaziv.setPreferredSize(dim);
		txtDatum.setPreferredSize(dim);

		panSifra.add(lblSifra);
		panSifra.add(txtSifra);

		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);

		panOcena.add(lblOcena);
		panOcena.add(gradeList);

		panDatum.add(lblDatum);
		panDatum.add(txtDatum);

		panDugmad.add(potvrdiBtn);
		panDugmad.add(odustaniBtn);

		Box boxCentar = Box.createVerticalBox();

		boxCentar.add(Box.createVerticalStrut(20));
		boxCentar.add(panSifra);
		boxCentar.add(panNaziv);
		boxCentar.add(panOcena);
		boxCentar.add(panDatum);
		boxCentar.add(Box.createVerticalStrut(20));
		// boxCentar.add(Box.createGlue());
		JPanel left = new JPanel();
		left.add(Box.createHorizontalStrut(20));

		add(boxCentar, BorderLayout.CENTER);
		add(panDugmad, BorderLayout.SOUTH);
		add(left, BorderLayout.EAST);
		add(left, BorderLayout.WEST);
		pack();
		this.setLocationRelativeTo(null);

		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student student = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
				LocalDate date;
				try {
					date = DateHandler.stringToDate(txtDatum.getText());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(PassingExam.this, "Pogresan format!", "Greska",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				student.getOtherExams().remove(currentSubject);
				int grade = gradeList.getSelectedIndex() + 6;
				Grade currentGrade = new Grade(student, currentSubject, grade, null);
				currentGrade.setValue(grade);
				currentGrade.setExamDate(date);
				student.getPassedExams().add(currentGrade);

				DefaultTableModel model = (DefaultTableModel) PassedSubject.getInstance().getTabelica().getModel();

				for (int i = 0; i < model.getRowCount(); i++)
					model.removeRow(i);

				for (Grade g : student.getPassedExams()) {

					Object[] row = { g.getSubject().getSubjectCode(), g.getSubject().getSubjectName(),
							g.getSubject().getEspb(), g.getValue(), g.getExamDate() };
					model.addRow(row);
				}
				
				model.fireTableDataChanged();
				AbstractTableModelNotPassedTableModel modelNotP = (AbstractTableModelNotPassedTableModel) NotPassedSubject.notPassedTableModel;
				modelNotP.fireTableDataChanged();

				dispose();

			}
		});
		
		odustaniBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public void setSubject(Subject subject) {
		this.currentSubject = subject;
		this.txtNaziv.setText(subject.getSubjectName());
		this.txtSifra.setText(subject.getSubjectCode());
		this.txtNaziv.setEnabled(false);
		this.txtSifra.setEnabled(false);
		this.txtSifra.setDisabledTextColor(Color.black);
		this.txtNaziv.setDisabledTextColor(Color.black);
	}

	

}
