package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar {

	Color toolbarBg = new Color(208, 182, 255);
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		setBackground(toolbarBg);
//////////////////////////////////
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Dodaj novi entitet");
		btnNew.setBackground(toolbarBg);
		btnNew.setIcon(new ImageIcon("images/toolbar/new.png"));
		
		add(btnNew);

		addSeparator();
//////////////////////////////////
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmijeni entitet");
		btnEdit.setBackground(toolbarBg);
		btnEdit.setIcon(new ImageIcon("images/toolbar/edit.png"));
		
		add(btnEdit);

		addSeparator();
//////////////////////////////////
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Obrisi");
		btnDelete.setBackground(toolbarBg);
		btnDelete.setIcon(new ImageIcon("images/toolbar/delete.png"));
		
		add(btnDelete);
		
		addSeparator();
//////////////////////////////////	
		JTextField searchField = new JTextField("Unesi pretragu...", 20);
		searchField.setMaximumSize(new Dimension(100,32));
		searchField.setToolTipText("Unesi pretragu");
//////////////////////////////////		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Pretrazi");		
		btnSearch.setBackground(toolbarBg);		
		btnSearch.setIcon(new ImageIcon("images/toolbar/search.png"));
		
		add(Box.createHorizontalGlue());
		add(searchField);
		add(btnSearch);


	}
}
