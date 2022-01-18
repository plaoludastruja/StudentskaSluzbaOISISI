package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentController;
import controller.SubjectController;
import gui.AbstractTableModelNotPassedTableModel;
import gui.MainFrame;
import gui.StudentTable;
import model.BazaSubject;
import model.Student;
import model.Subject;

public class DeleteNotPassedSubject extends JDialog {

	public DeleteNotPassedSubject(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 100);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		Dimension dim = new Dimension(180, 20);
		
		JPanel panCentar = new JPanel(new BorderLayout());
		JPanel panPitanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblPitanje = new JLabel("Da li ste sigurni da zelite da uklonite predmet?");
		JButton daBtn = new JButton("DA");
		JButton neBtn = new JButton("NE");
		
		panPitanje.add(lblPitanje);
		panDugmad.add(daBtn);
		panDugmad.add(neBtn);
		
		
		neBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		daBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Subject predmet = SubjectController.getInstance().getSubjectByCode(NotPassedSubject.tabelica.getSelectedRow());
				Subject predmet = BazaSubject.getInstance().getSubjectByCode(NotPassedSubject.tabelica.getValueAt(NotPassedSubject.tabelica.getSelectedRow(), 0).toString());
				Student s = StudentController.getInstance().getStudentByID(StudentTable.getInstance().getSelectedRow());
					s.getOtherExams().remove(predmet);
		
					AbstractTableModelNotPassedTableModel model = (AbstractTableModelNotPassedTableModel) NotPassedSubject.notPassedTableModel;
											// azuriranje modela tabele, kao i njenog prikaza
					model.fireTableDataChanged();
					validate();
					dispose();
			}
		});
		
		
		add(panPitanje, BorderLayout.CENTER);
		//add(Box.createVerticalGlue());
		add(panDugmad,BorderLayout.SOUTH);

		
		
	}
}
