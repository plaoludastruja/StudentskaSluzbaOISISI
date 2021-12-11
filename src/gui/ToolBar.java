package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import gui.dialog.AddStudentDialog;
import listener.addEntity;
//import listener.addEntity;

public class ToolBar extends JToolBar {

	Color toolbarBg = new Color(208, 182, 255);
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
		searchField.setMaximumSize(new Dimension(100,32));
		searchField.setText("Unesi pretragu...");
		
// ************************************* //	
		btnSearch.setToolTipText("Pretrazi");		
		btnSearch.setBackground(toolbarBg);		
		btnSearch.setIcon(new ImageIcon("images/toolbar/search.png"));
		
// ************************************* //	
		
		btnNew.addActionListener(new addEntity());
		/*btnNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddStudentDialog dialog = new AddStudentDialog(parent, "Primer modalnog prozora", true);
				dialog.setVisible(true);

			}
		});*/
		
		
		
		
// ************************************* //			
		//dodavanje
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
