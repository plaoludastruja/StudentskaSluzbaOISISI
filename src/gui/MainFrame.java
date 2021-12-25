package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;


import listener.MyWindowListener;

public class MainFrame extends JFrame{

	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {

		// inicijalne postavke prozora
		this.initPosition();
		// menu
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		// toolbar
		ToolBar toolbar = new ToolBar();
		add(toolbar,BorderLayout.NORTH);
		// tabbedpane
		//TabbedPane tabbedPane = new TabbedPane();
		TabbedPaneMainFrame.getInstance();
		add(TabbedPaneMainFrame.getInstance(),BorderLayout.CENTER);
//		//statusbar
		StatusBar statusbar = new StatusBar();
		add(statusbar, BorderLayout.SOUTH);
		validate();
//		//window listener
		addWindowListener(new MyWindowListener());
	
	}
	
	private void initPosition() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	

	
}
