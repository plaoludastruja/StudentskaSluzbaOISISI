package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	
	public MenuBar() {

// ************************************* //	
		JMenu file = new JMenu("File");
		JMenuItem MBnew = new JMenuItem("New", KeyEvent.VK_N);
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
		JMenu open = new JMenu("Open");
		JMenuItem close = new JMenuItem("Close", KeyEvent.VK_C);
		
		JMenuItem studenti = new JMenuItem("Studenti", KeyEvent.VK_S);
		JMenuItem predmeti = new JMenuItem("Predmeti", KeyEvent.VK_P);
		JMenuItem profesori = new JMenuItem("Profesori", KeyEvent.VK_F);
		JMenuItem katedre = new JMenuItem("Katedre", KeyEvent.VK_K);
		
		JMenu edit = new JMenu("Edit");
		JMenuItem edit1 = new JMenuItem("Edit", KeyEvent.VK_E);
		JMenuItem delete = new JMenuItem("Delete", KeyEvent.VK_D);
		
		JMenu help = new JMenu("Help");
		JMenuItem help1 = new JMenuItem("Help", KeyEvent.VK_H);		
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);
		
// ************************************* //		
		file.setMnemonic(KeyEvent.VK_F);
		open.setMnemonic(KeyEvent.VK_O);
		edit.setMnemonic(KeyEvent.VK_E);
		help.setMnemonic(KeyEvent.VK_H);
		
// ************************************* //	
		MBnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
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
		MBnew.setIcon(new ImageIcon("images/menubar/plus.png"));
		save.setIcon(new ImageIcon("images/menubar/diskette.png"));
		open.setIcon(new ImageIcon("images/menubar/share.png"));
		close.setIcon(new ImageIcon("images/menubar/close.png"));
		studenti.setIcon(new ImageIcon("images/menubar/student.png"));
		predmeti.setIcon(new ImageIcon("images/menubar/bookshelf.png"));
		profesori.setIcon(new ImageIcon("images/menubar/professor.png"));
		katedre.setIcon(new ImageIcon("images/menubar/department.png"));
		edit1.setIcon(new ImageIcon("images/menubar/edit.png"));
		delete.setIcon(new ImageIcon("images/menubar/bin.png"));
		help1.setIcon(new ImageIcon("images/menubar/question.png"));
		about.setIcon(new ImageIcon("images/menubar/info.png"));

		
// ************************************* //		
		file.add(MBnew);
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

}
