package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.util.Locale;

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
		
		JButton srpski = new JButton();
		JButton engleski = new JButton();

// ************************************* //	
		btnNew.setToolTipText("Dodaj novi entitet");
		btnNew.setBackground(toolbarBg);
		btnNew.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "new.png"));

// ************************************* //
		btnEdit.setToolTipText("Izmijeni entitet");
		btnEdit.setBackground(toolbarBg);
		btnEdit.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "edit.png"));

// ************************************* //
		srpski.setToolTipText("Srpski jezik");
		srpski.setBackground(toolbarBg);
		srpski.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "srpski.png"));
		srpski.setBorderPainted(false);

// ************************************* //
		engleski.setToolTipText("Engleski jezik");
		engleski.setBackground(toolbarBg);
		engleski.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "engleski.png"));
		engleski.setBorderPainted(false);

// ************************************* //
		btnDelete.setToolTipText("Obrisi entitet");
		btnDelete.setBackground(toolbarBg);
		btnDelete.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "delete.png"));

// ************************************* //
		searchField.setToolTipText("Unesi pretragu");
		searchField.setMaximumSize(new Dimension(100, 32));
		searchField.setText("Unesi pretragu...");

// ************************************* //	
		btnSearch.setToolTipText("Pretrazi");
		btnSearch.setBackground(toolbarBg);
		btnSearch.setIcon(new ImageIcon("images" + File.separator + "toolbar" + File.separator + "search.png"));

// ************************************* //	

		btnNew.addActionListener(new AddEntity());
		btnDelete.addActionListener(new DeleteEntity());
		btnEdit.addActionListener(new EditEntity());
		btnSearch.addActionListener(new SearchEntity());
		searchField.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				searchField.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		
		srpski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.getInstance().changeLanguage();
				
			}
			
		});
		
		engleski.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.getInstance().changeLanguage();
				
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
		
		add(srpski);
		add(engleski);
		add(searchField);
		add(btnSearch);

	}
}
