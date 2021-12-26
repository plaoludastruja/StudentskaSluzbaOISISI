package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.TimerTask;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import dateHandler.DateHandler;

public class StatusBar extends JPanel {
	private JLabel tabName;
	public StatusBar() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));


		JLabel appName = new JLabel("Studentska sluzba");

		tabName = new JLabel("Student");


		JLabel dateLab = new JLabel();

		LocalDateTime date = LocalDateTime.now();
		dateLab.setText(DateHandler.dateTimeToString(date));

		add(Box.createHorizontalStrut(10));
		add(appName);
		add(tabName);
		add(Box.createGlue());
		add(dateLab);
		add(Box.createHorizontalStrut(30));

		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime date = LocalDateTime.now();
				dateLab.setText(DateHandler.dateTimeToString(date));
			}
		};
		
		Timer timer = new Timer(10000 ,taskPerformer);
		timer.setRepeats(true);
		timer.start();
		
	}
	public JLabel getTabName() {
		return tabName;
	}
	
	
}