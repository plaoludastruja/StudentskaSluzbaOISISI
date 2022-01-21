package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.MainFrame;
import model.BazaProfessor;
import model.Professor;

public class AddProfessorOnSubjectDialog extends JDialog {
	private JPanel panCenter;
	private BoxLayout boxCenter;
	private FlowLayout flowLayout;
	private JPanel panDugmad;
	private JButton btnOdustani;
	private JButton btnPotvrdi;
	private ArrayList<Professor> profesori;
	private JList<String> profesoriList;
	private Dimension dim;
	
	public AddProfessorOnSubjectDialog() {
		
		super(MainFrame.getInstance(), true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 4, screenHeight / 4);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Odaberi profesora");

		JPanel panelProfessor = new JPanel();
		panelProfessor.setLayout(new BorderLayout());

		DefaultListModel<String> modelList = new DefaultListModel<>();

		profesori = BazaProfessor.getInstance().getProfesori();

		for (Professor p : profesori) {
			modelList.addElement(p.getFirstName() + " " + p.getLastName());

		}

		profesoriList = new JList<String>(modelList);

		add(panelProfessor, BorderLayout.CENTER);
		JPanel panelN = new JPanel();
		JPanel panelR = new JPanel();
		JPanel panelL = new JPanel();
		JPanel panelS = new JPanel();

		panelN.add(Box.createVerticalStrut(15));
		panelProfessor.add(panelN, BorderLayout.NORTH);
		panelProfessor.add(panelR, BorderLayout.EAST);
		panelProfessor.add(panelL, BorderLayout.WEST);
		panelProfessor.add(panelS, BorderLayout.SOUTH);
		JScrollPane scrollProf = new JScrollPane(profesoriList);
		panelProfessor.add(scrollProf, BorderLayout.CENTER);

		panDugmad = new JPanel();
		flowLayout = (FlowLayout) panDugmad.getLayout();
		flowLayout.setHgap(30);
		btnPotvrdi = new JButton(MainFrame.getInstance().getResourceBundle().getString("potvrdi"));
		btnOdustani = new JButton(MainFrame.getInstance().getResourceBundle().getString("odustani"));

		panDugmad.add(btnPotvrdi);
		panDugmad.add(btnOdustani);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(panDugmad, BorderLayout.SOUTH);


		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = profesoriList.getSelectedIndex();
				if (idx == -1) {
					return;
				}
				Professor profesor = profesori.get(idx);
				profesori.remove(idx);
				profesoriList.remove(idx);

				dispose();
			}
		});

		pack();

	}

}
