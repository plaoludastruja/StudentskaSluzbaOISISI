package listener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.SerializableController;
import gui.MainFrame;

public class MyWindowListener implements WindowListener {


		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			JFrame frame = (JFrame) arg0.getComponent();
			SerializableController.getInstance().serijalizacija();
			
			int code = JOptionPane.showConfirmDialog(frame, MainFrame.getInstance().getResourceBundle().getString("dalistesigurniZatvori"),
					"Zatvaranje aplikacije?", JOptionPane.YES_NO_OPTION);
			if (code != JOptionPane.YES_OPTION) {
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			} else {
				frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			}

		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void windowOpened(WindowEvent arg0) {
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

