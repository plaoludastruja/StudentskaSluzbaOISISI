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

public class PassingExam extends JDialog {

	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JTextField txtDatum;
	private JButton potvrdiBtn;
	private JButton odustaniBtn;
	private JComboBox<String> ocenaList;
	private Grade currentGrade;

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

		lblSifra = new JLabel("Sifra*");
		lblNaziv = new JLabel("Naziv*");
		lblOcena = new JLabel("Ocena*");
		lblDatum = new JLabel("Datum*");

		String nizStr[] = { "5", "6", "7", "8", "9", "10" };

		txtSifra = new JTextField();
		txtNaziv = new JTextField();
		ocenaList = new JComboBox<String>(nizStr);
		txtDatum = new JTextField();

		potvrdiBtn = new JButton("Potvrdi");
		odustaniBtn = new JButton("Odustani");

		lblSifra.setPreferredSize(dim);
		lblNaziv.setPreferredSize(dim);
		lblOcena.setPreferredSize(dim);
		lblDatum.setPreferredSize(dim);
		ocenaList.setPreferredSize(dim);

		txtSifra.setPreferredSize(dim);
		txtNaziv.setPreferredSize(dim);
		txtDatum.setPreferredSize(dim);

		panSifra.add(lblSifra);
		panSifra.add(txtSifra);

		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);

		panOcena.add(lblOcena);
		panOcena.add(ocenaList);

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
		JPanel levi = new JPanel();
		levi.add(Box.createHorizontalStrut(20));

		add(boxCentar, BorderLayout.CENTER);
		add(panDugmad, BorderLayout.SOUTH);
		add(levi, BorderLayout.EAST);
		add(levi, BorderLayout.WEST);
		pack();
		this.setLocationRelativeTo(null);

		potvrdiBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student stud = StudentController.getInstance()
						.getStudentByID(StudentTable.getInstance().getSelectedRow());
				LocalDate datum;
				try {
					datum = DateHandler.stringToDate(txtDatum.getText());

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(PassingExam.this, "wrong format", "Warning",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				stud.getOtherExams().remove(currentGrade);
				stud.getPassedExams().add(currentGrade);
				int ocena = ocenaList.getSelectedIndex() + 5;
				currentGrade.setValue(ocena);
				currentGrade.setExamDate(datum);

				DefaultTableModel model = (DefaultTableModel) PassedSubject.getInstance().getTabelica().getModel();

				for (int i = 0; i < model.getRowCount(); i++)
					model.removeRow(i);

				for (Grade grade : stud.getPassedExams()) {

					Object[] row = { grade.getSubject().getSubjectCode(), grade.getSubject().getSubjectName(),
							grade.getSubject().getEspb(), grade.getValue(), grade.getExamDate() };
					model.addRow(row);
				}
				model.fireTableDataChanged();
				NotPassedTableModel modelNotP = (NotPassedTableModel) NotPassedSubject.getInstance().getTable()
						.getModel();

				modelNotP.fireTableDataChanged();

				dispose();

			}
		});
	}

	public void setGrade(Grade ocena) {
		this.currentGrade = ocena;
		this.txtNaziv.setText(ocena.getSubject().getSubjectName());
		this.txtSifra.setText(ocena.getSubject().getSubjectCode());
		this.txtNaziv.setEnabled(false);
		this.txtSifra.setEnabled(false);
		this.txtSifra.setDisabledTextColor(Color.black);
		this.txtNaziv.setDisabledTextColor(Color.black);
	}

}
