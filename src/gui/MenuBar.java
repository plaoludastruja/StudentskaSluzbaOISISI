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

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem MBnew = new JMenuItem("New", KeyEvent.VK_N);
		MBnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		MBnew.setIcon(new ImageIcon("images/menubar/plus.png"));
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_S);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.setIcon(new ImageIcon("images/menubar/diskette.png"));
		JMenu open = new JMenu("Open");
		open.setMnemonic(KeyEvent.VK_O);
		open.setIcon(new ImageIcon("images/menubar/share.png"));
		JMenuItem close = new JMenuItem("Close", KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		close.setIcon(new ImageIcon("images/menubar/close.png"));
		
		file.add(MBnew);
		file.addSeparator();
		file.add(save);
		file.addSeparator();
		file.add(open);
		file.addSeparator();
		file.add(close);
		
		JMenuItem studenti = new JMenuItem("Studenti", KeyEvent.VK_S);
		JMenuItem predmeti = new JMenuItem("Predmeti", KeyEvent.VK_P);
		JMenuItem profesori = new JMenuItem("Profesori", KeyEvent.VK_F);
		JMenuItem katedre = new JMenuItem("Katedre", KeyEvent.VK_K);
		
		studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
		
		studenti.setIcon(new ImageIcon("images/menubar/student.png"));
		predmeti.setIcon(new ImageIcon("images/menubar/bookshelf.png"));
		profesori.setIcon(new ImageIcon("images/menubar/professor.png"));
		katedre.setIcon(new ImageIcon("images/menubar/department.png"));
		
		open.add(studenti);
		open.addSeparator();
		open.add(predmeti);
		open.addSeparator();
		open.add(profesori);
		open.addSeparator();
		open.add(katedre);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem delete = new JMenuItem("Delete", KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delete.setIcon(new ImageIcon("images/menubar/bin.png"));
		JMenuItem edit1 = new JMenuItem("Edit", KeyEvent.VK_E);
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		edit1.setIcon(new ImageIcon("images/menubar/edit.png"));
		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		JMenuItem help1 = new JMenuItem("Help", KeyEvent.VK_H);
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		help1.setIcon(new ImageIcon("images/menubar/question.png"));
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		about.setIcon(new ImageIcon("images/menubar/info.png"));
		
		help.add(help1);
		help.addSeparator();
		help.add(about);
		
		add(file);
		add(edit);
		add(help);
		
		}

}
