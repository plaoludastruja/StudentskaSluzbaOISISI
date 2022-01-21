package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.SerializableController;
import listener.MyWindowListener;

public class MainFrame extends JFrame{

	private ResourceBundle resourceBundle;
	private MenuBar menu;
	private ToolBar toolbar;
	private StatusBar statusbar;
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	private MainFrame() {

		//
		SerializableController.getInstance().deserijalizacija();
		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		// inicijalne postavke prozora
		this.initPosition();
		// menu
		menu = new MenuBar();
		this.setJMenuBar(menu);
		// toolbar
		toolbar = new ToolBar();
		add(toolbar,BorderLayout.NORTH);
		// tabbedpane
		//TabbedPane tabbedPane = new TabbedPane();
		TabbedPaneMainFrame.getInstance();
		add(TabbedPaneMainFrame.getInstance(),BorderLayout.CENTER);
//		//statusbar
		statusbar = new StatusBar();
		add(statusbar, BorderLayout.SOUTH);
		TabbedPaneMainFrame.getInstance().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(TabbedPaneMainFrame.getInstance().getSelectedIndex() == 0) {
					statusbar.getTabName().setText("Student");
				}else if(TabbedPaneMainFrame.getInstance().getSelectedIndex() == 1) {
					statusbar.getTabName().setText("Profesor");
				}else  {
					statusbar.getTabName().setText("Predmet");
					
				}
				
			}
		});
		validate();
		
		// lokalizacija
		
		
//		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
//		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
//		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
//		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
		
		
		//window listener
		addWindowListener(new MyWindowListener());
	
	}
	public void changeLanguage() {

		resourceBundle = ResourceBundle.getBundle("gui.MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("naslovAplikacije"));
		//Locale.setDefault(new Locale("sr", "RS"));
		menu.initComponents();
		toolbar.initComponents();
		statusbar.initComponents();

//		UIManager.put("OptionPane.yesButtonText", resourceBundle.getObject("yesOption"));
//		UIManager.put("OptionPane.noButtonText", resourceBundle.getObject("noOption"));
//		UIManager.put("OptionPane.okButtonText", resourceBundle.getObject("okOption"));
//		UIManager.put("OptionPane.cancelButtonText", resourceBundle.getObject("cancelOption"));
//		mnuStudenti.setText(MainFrame.getInstance().getResourceBundle().getString("mnuStudenti"));
//		mniRegistarStudenata.setText(MainFrame.getInstance().getResourceBundle().getString("mniRegistarStudenata"));
//		mniNepolozeniPredmeti.setText(MainFrame.getInstance().getResourceBundle().getString("mniNepolozeniPredmeti"));
//		mnuAdministracija.setText(MainFrame.getInstance().getResourceBundle().getString("mnuAdministracija"));
//
//		mniEngleski.setText(MainFrame.getInstance().getResourceBundle().getString("mniEngleski"));
//		mniSrpski.setText(MainFrame.getInstance().getResourceBundle().getString("mniSrpski"));
//		btnDialog.initAction();
	}
	
	private void initPosition() {
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle(resourceBundle.getString("naslovAplikacije"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public JTable getTable() {
		if(TabbedPaneMainFrame.getInstance().getSelectedIndex() == 0) {
			return StudentTable.getInstance();
		}else if(TabbedPaneMainFrame.getInstance().getSelectedIndex() == 1) {
			return ProfessorTable.getInstance();
		}else {
			return SubjectTable.getInstance();
		}
		
	}
	
	

	
}
