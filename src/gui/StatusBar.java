package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import dateHandler.DateHandler;

public class StatusBar extends JPanel {

	public StatusBar() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JLabel appName = new JLabel("Studentska slu�ba");

		JLabel dateLabel = new JLabel();

		LocalDateTime date = LocalDateTime.now();
		dateLabel.setText(DateHandler.dateTimeToString(date));

		add(Box.createHorizontalStrut(10));
		add(appName);
		add(Box.createGlue());
		add(dateLabel);
		add(Box.createHorizontalStrut(30));

		ActionListener taskPerformer = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
		LocalDateTime date = LocalDateTime.now();
		dateLabel.setText(DateHandler.dateTimeToString(date));
		}
		};
		Timer timer = new Timer(10000 ,taskPerformer);
		timer.setRepeats(true);
		timer.start();


	}
}