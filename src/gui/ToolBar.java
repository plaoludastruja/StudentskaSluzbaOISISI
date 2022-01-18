package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.ProfessorController;
import controller.SubjectController;
import gui.dialog.AddEditStudentDialog;
import gui.dialog.AddEditSubjectDialog;
import gui.dialog.AddProfessorDialog;
import listener.AddEntity;
//import listener.addEntity;
import listener.DeleteEntity;
import listener.EditEntity;
import listener.SearchEntity;
import model.BazaProfessor;

public class ToolBar extends JToolBar {

	Color toolbarBg = new Color(193, 223, 230);

	public static JTextField searchField;
	public ToolBar() {

		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		setBackground(toolbarBg);

// ************************************* //
		JButton btnNew = new JButton();
		JButton btnEdit = new JButton();
		JButton btnDelete = new JButton();
		searchField = new JTextField(20);
		JButton btnSearch = new JButton();

// ************************************* //	
		btnNew.setToolTipText("Dodaj novi entitet");
		btnNew.setBackground(toolbarBg);
		btnNew.setIcon(new ImageIcon("images/toolbar/new.png"));

// ************************************* //
		btnEdit.setToolTipText("Izmijeni entitet");
		btnEdit.setBackground(toolbarBg);
		btnEdit.setIcon(new ImageIcon("images/toolbar/edit.png"));

// ************************************* //
		btnDelete.setToolTipText("Obrisi entitet");
		btnDelete.setBackground(toolbarBg);
		btnDelete.setIcon(new ImageIcon("images/toolbar/delete.png"));

// ************************************* //
		searchField.setToolTipText("Unesi pretragu");
		searchField.setMaximumSize(new Dimension(100, 32));
		searchField.setText("Unesi pretragu...");

// ************************************* //	
		btnSearch.setToolTipText("Pretrazi");
		btnSearch.setBackground(toolbarBg);
		btnSearch.setIcon(new ImageIcon("images/toolbar/search.png"));

// ************************************* //	

		btnNew.addActionListener(new AddEntity());
		btnDelete.addActionListener(new DeleteEntity());
		btnEdit.addActionListener(new EditEntity());
		searchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				searchField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				switch (TabbedPaneMainFrame.getInstance().getSelectedIndex()) {
				case 0: // STUDENT

					break;
				case 1: // PROFESOR
					String profesor = searchField.getText().toLowerCase();
					String[] nizProfessor = profesor.split(",");
					if (nizProfessor.length == 1) {

						String lastName = nizProfessor[0].trim();
						ProfessorController.getInstance().getProffessorNameSurname(lastName, null);

					} else if (nizProfessor.length == 2) {

						String lastName = nizProfessor[0].trim();
						String name = nizProfessor[1].trim();

						ProfessorController.getInstance().getProffessorNameSurname(lastName, name);

					} else {
						JOptionPane.showMessageDialog(null,
								"Pretraga profesora mora biti formata prezime ili prezime, ime", "Pogresan format!",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					break;
				case 2: // PREDMET
					String predmet = searchField.getText().toLowerCase();
					String[] nizPredmet = predmet.split(",");
					if (nizPredmet.length == 1) {

						String name = nizPredmet[0].trim();
						SubjectController.getInstance().getSubjectNameCode(name, null);

					} else if (nizPredmet.length == 2) {

						String name = nizPredmet[0].trim();
						String code = nizPredmet[1].trim();

						SubjectController.getInstance().getSubjectNameCode(name, code);

					} else {
						JOptionPane.showMessageDialog(null,
								"Pretraga predmeta mora biti formata ime ili ime, sifra", "Pogresan format!",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					break;
				default:
					break;
				}

			}

		});

// ************************************* //			
		// dodavanje
		add(btnNew);
		addSeparator();
		add(btnEdit);
		addSeparator();
		add(btnDelete);
		addSeparator();
		add(Box.createHorizontalGlue());
		add(searchField);
		add(btnSearch);

	}
}
