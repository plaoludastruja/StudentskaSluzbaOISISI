package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
