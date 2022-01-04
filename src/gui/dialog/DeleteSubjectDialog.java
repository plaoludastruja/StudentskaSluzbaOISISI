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

import controller.ProfessorController;
import controller.SubjectController;
import gui.MainFrame;

public class DeleteSubjectDialog extends JDialog{

	private int index1;

	public DeleteSubjectDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 100);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		Dimension dim = new Dimension(180, 20);
		
		JPanel panCentar = new JPanel(new BorderLayout());
		JPanel panPitanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblPitanje = new JLabel("Da li ste sigurni da zelite da obrisete predmet?");
		JButton daBtn = new JButton("DA");
		JButton neBtn = new JButton("NE");
		
		daBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SubjectController.getInstance().deleteSubject(index1);
				dispose();
			}
		});
		
		neBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		panPitanje.add(lblPitanje);
		panDugmad.add(daBtn);
		panDugmad.add(neBtn);
		
		add(panPitanje, BorderLayout.CENTER);
		add(panDugmad,BorderLayout.SOUTH);
	
	
	
	}

	public void setRowIndex(int index1) {
		this.index1 = index1;
		
	}
}
