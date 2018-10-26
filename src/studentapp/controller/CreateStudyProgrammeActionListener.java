package studentapp.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateStudyProgrammeActionListener implements ActionListener {

	private Manager manager;
	private GridBagConstraints c;
	private JPanel studyProgrammePanel2, studyProgrammePanel;
	private JTextField textProgrammeName, textProgrammePoints;
	private int y = 0;

	public CreateStudyProgrammeActionListener(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		createDialog();
	}

	private void createDialog() {
		JDialog createSPDialog = new JDialog();
		createSPDialog.setModal(true);             
		createSPDialog.setMinimumSize(new Dimension(700, 500));
		createSPDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		createSPDialog.setLocationRelativeTo(null);
		c = new GridBagConstraints();
		c.insets = new Insets(5,0,0,0);
		c.gridx = 0;
		c.gridy = 0;

		createSPDialog.setTitle("Create study programme");

		studyProgrammePanel = new JPanel(new GridBagLayout());
		studyProgrammePanel.setBackground(Color.WHITE);

		textProgrammeName = new JTextField(20); 
		textProgrammeName.setText("Bug eliminated");
		createField("Programme name: ",textProgrammeName);
		
		textProgrammePoints = new JTextField(20);
		textProgrammePoints.setText("100%");
		createField("Total points: ", textProgrammePoints);

		JButton buttonCreateSP = new JButton("Create");
		buttonCreateSP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				manager.addcreateStudyProgrammePanel(textProgrammeName.getText(), textProgrammePoints.getText());

				//createClosingDialog();
				createSPDialog.dispose();				
			};
		});
		c.gridy++;
		studyProgrammePanel.add(buttonCreateSP, c);
		createSPDialog.getContentPane().add(studyProgrammePanel); 
		createSPDialog.pack();
		createSPDialog.setVisible(true);
	}
	private void createClosingDialog() {

		JDialog dialogClosing = new JDialog();
		dialogClosing.setModal(true);             
		dialogClosing.setMinimumSize(new Dimension(400, 200));
		dialogClosing.setLocationRelativeTo(null);
		dialogClosing.setTitle("Success!");
		JLabel labelSuccess = new JLabel("You hade successfully created a new study programme! ");
		studyProgrammePanel2 = new JPanel(new GridBagLayout());

		studyProgrammePanel2.setBackground(Color.WHITE);
		JButton buttonClose = new JButton("Close");

		buttonClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dialogClosing.dispose();
				
			}
		});

		studyProgrammePanel2.add(labelSuccess,c);
		c.gridy++;
		c.insets = new Insets(20,0,0,0);
		studyProgrammePanel2.add(buttonClose, c);


		dialogClosing.getContentPane().add(studyProgrammePanel2); 
		dialogClosing.pack();
		dialogClosing.setVisible(true);

	}
	private void createField(String labelName, JTextField textFieldName) {

		c.gridx = 0;
		c.gridy = y;

		JLabel label1 = new JLabel(labelName);
		studyProgrammePanel.add(label1, c);

		c.gridx++;

		studyProgrammePanel.add(textFieldName, c);
		y++;
	}
}