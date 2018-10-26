package studentapp.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LogInDialog {//Har allting i metod i GUI------

	public LogInDialog(int frameWidth, int frameHeight) {
		
		createLogInDialog(frameWidth, frameHeight);
		
	}
	
	private void createLogInDialog(int frameWidth, int frameHeight) {
		
		JDialog logInDialog = new JDialog();
		logInDialog.setModal(true);             
		logInDialog.setMinimumSize(new Dimension(frameWidth, frameHeight));
		logInDialog.setLocationRelativeTo(null);
		logInDialog.setTitle("Login");
		
		JPanel mainPanel = new JPanel(new GridBagLayout());
		mainPanel.setBackground(Color.WHITE);
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		
		JLabel test = new JLabel("This is the login page, höhehehehe");
		mainPanel.add(test, c);
		
		c.gridy++;
		
		JButton okButton = new JButton("Log in");
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				logInDialog.dispose();
			}
		});
		mainPanel.add(okButton, c);
		
		logInDialog.getContentPane().add(mainPanel);
		logInDialog.pack();
		logInDialog.setVisible(true);
	}
	
}
