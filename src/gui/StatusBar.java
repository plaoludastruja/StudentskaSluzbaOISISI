package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class StatusBar extends JPanel{

	/**
	 * 
	 */
	JLabel name;

	public StatusBar() {
		
		super();
		setLayout(new BorderLayout());
		name = new JLabel(" Studentska služba");
		add(name, BorderLayout.WEST);
		setBackground(Color.LIGHT_GRAY);
		
		
		Date date = new Date();
		DateFormat izgled = new SimpleDateFormat("HH:mm:ss   dd.MM.yyyy.");
		JLabel dateTime = new JLabel(izgled.format(date));
		
		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				date.setTime(System.currentTimeMillis());
				dateTime.setText(izgled.format(date));
				
			}
			
		};
		
		Timer timer = new Timer(0, actionListener);
		timer.start();
		
		add(dateTime, BorderLayout.EAST);
		
	}
	
	//public void initComponents() {
	///	name.setText(MainFrame.getInstance()..getString("naslovAplikacije"));
//	}
	
}
