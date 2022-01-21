package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import gui.dialog.AddEditStudentDialog;
import gui.dialog.DepartmentDialog;
import listener.AddEntity;
import listener.DeleteEntity;
import listener.EditEntity;

public class MenuBar extends JMenuBar {
	
	JMenu file, open, edit, help;
	JMenuItem mbnew, save, close, studenti, predmeti, profesori, katedre, edit1, delete, help1, about;
	public MenuBar() {

// ************************************* //	
		file = new JMenu("File");
		mbnew = new JMenuItem("New", KeyEvent.VK_N);
		save = new JMenuItem("Save", KeyEvent.VK_S);
		open = new JMenu("Open");
		close = new JMenuItem("Close", KeyEvent.VK_C);
		
		studenti = new JMenuItem("Studenti", KeyEvent.VK_S);
		predmeti = new JMenuItem("Predmeti", KeyEvent.VK_P);
		profesori = new JMenuItem("Profesori", KeyEvent.VK_F);
		 katedre = new JMenuItem("Katedre", KeyEvent.VK_K);
		
		edit = new JMenu("Edit");
		edit1 = new JMenuItem("Edit", KeyEvent.VK_E);
		delete = new JMenuItem("Delete", KeyEvent.VK_D);
		
		help = new JMenu("Help");
		help1 = new JMenuItem("Help", KeyEvent.VK_H);		
		about = new JMenuItem("About", KeyEvent.VK_A);
		
// ************************************* //		
		file.setMnemonic(KeyEvent.VK_F);
		open.setMnemonic(KeyEvent.VK_O);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
// ************************************* //	
		mbnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		
		

		
// ************************************* //		
		mbnew.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "plus.png"));
		save.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "diskette.png"));
		open.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "share.png"));
		close.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "close.png"));
		studenti.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "student.png"));
		predmeti.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "bookshelf.png"));
		profesori.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "professor.png"));
		katedre.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "department.png"));
		edit1.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "edit.png"));
		delete.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "bin.png"));
		help1.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "question.png"));
		about.setIcon(new ImageIcon("images" + File.separator + "menubar" + File.separator + "info.png"));

		
// ************************************* //
		
		mbnew.addActionListener(new AddEntity());
		delete.addActionListener(new DeleteEntity());
		edit1.addActionListener(new EditEntity());
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//MainFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				System.exit(ABORT);
			}
		});

		
		studenti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TabbedPaneMainFrame.getInstance().setSelectedIndex(0);
			}
		});
		
		predmeti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TabbedPaneMainFrame.getInstance().setSelectedIndex(1);
			}
		});
		
		profesori.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TabbedPaneMainFrame.getInstance().setSelectedIndex(2);
			}
		});
		
		katedre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DepartmentDialog department = new DepartmentDialog();
				department.setVisible(true);
			}
		});
		
// ************************************* //
		file.add(mbnew);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(close);	
		open.add(studenti);
		open.addSeparator();
		open.add(predmeti);
		open.addSeparator();
		open.add(profesori);
		open.addSeparator();
		open.add(katedre);
		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);	
		help.add(help1);
		help.addSeparator();
		help.add(about);
		
		add(file);
		add(edit);
		add(help);
		
		}
	public void initComponents() {
		
		file.setText(MainFrame.getInstance().getResourceBundle().getString("file"));
		open.setText(MainFrame.getInstance().getResourceBundle().getString("open"));
		edit.setText(MainFrame.getInstance().getResourceBundle().getString("edit"));
		help.setText(MainFrame.getInstance().getResourceBundle().getString("help"));
		
		mbnew.setText(MainFrame.getInstance().getResourceBundle().getString("mbnew"));
		save.setText(MainFrame.getInstance().getResourceBundle().getString("save"));
		close.setText(MainFrame.getInstance().getResourceBundle().getString("close"));
		studenti.setText(MainFrame.getInstance().getResourceBundle().getString("studenti"));
		predmeti.setText(MainFrame.getInstance().getResourceBundle().getString("predmeti"));
		profesori.setText(MainFrame.getInstance().getResourceBundle().getString("profesori"));
		katedre.setText(MainFrame.getInstance().getResourceBundle().getString("katedre"));
		edit1.setText(MainFrame.getInstance().getResourceBundle().getString("edit1"));
		delete.setText(MainFrame.getInstance().getResourceBundle().getString("delete"));
		help1.setText(MainFrame.getInstance().getResourceBundle().getString("help1"));
		about.setText(MainFrame.getInstance().getResourceBundle().getString("about"));
		
	}

}
