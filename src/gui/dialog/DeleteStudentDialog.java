package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.MainFrame;

public class DeleteStudentDialog extends JDialog  {

	public DeleteStudentDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(400, 100);
		setLocationRelativeTo(MainFrame.getInstance());
		setResizable(false);
		
		Dimension dim = new Dimension(180, 20);
		
		JPanel panCentar = new JPanel(new BorderLayout());
		JPanel panPitanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel panDugmad = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		JLabel lblPitanje = new JLabel("Da li ste sigurni da zelite da obrisete studenta?");
		JButton daBtn = new JButton("DA");
		JButton neBtn = new JButton("NE");
		
		panPitanje.add(lblPitanje);
		panDugmad.add(daBtn);
		panDugmad.add(neBtn);
		
		add(panPitanje, BorderLayout.CENTER);
		//add(Box.createVerticalGlue());
		add(panDugmad,BorderLayout.SOUTH);

		
		
	}
}
