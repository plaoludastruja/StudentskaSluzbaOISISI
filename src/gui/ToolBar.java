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
import gui.dialog.AddEditStudentDialog;
import listener.AddEntity;
//import listener.addEntity;
import listener.DeleteEntity;
import listener.EditEntity;
import listener.SearchEntity;
import model.BazaProfessor;

public class ToolBar extends JToolBar {

	Color toolbarBg = new Color(193, 223, 230);

	public ToolBar() {

		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		setBackground(toolbarBg);

// ************************************* //
		JButton btnNew = new JButton();
		JButton btnEdit = new JButton();
		JButton btnDelete = new JButton();
		JTextField searchField = new JTextField(20);
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
				
				
				String profesor = searchField.getText();
				String[] niz = profesor.split(",");
				if (niz.length == 1) {

					String prof1 = niz[0].trim();
					ProfessorController.getInstance().getProffessorNameSurname(prof1, null);
					
				} else if (niz.length == 2) {

					String prof1 = niz[0].trim();
					String prof2 = niz[1].trim();

					ProfessorController.getInstance().getProffessorNameSurname(prof1, prof2);
					
				} else {
					JOptionPane.showMessageDialog(null, "Pretraga profesora mora biti formata prezime ili prezime, ime",
							"Pogresan format!", JOptionPane.ERROR_MESSAGE);
					return;
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
