package studentapp.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateProjectActionListener implements ActionListener{

	private Manager manager;
	private JPanel createProjectPanel, errorPanel;
	private GridBagConstraints c;
	private JButton buttonCreateProject, buttonError;
	private JTextField textFieldProjectName, textFieldProjectDeadline, textFieldProjectGrade;
	private int y;
	private String courseCode;
	



	public CreateProjectActionListener(Manager manager) {
		this.manager = manager;
		manager.projectAlreadyExists = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(manager.projectAlreadyExists == true) {

			errorDialog();
		
		}else {
			courseCode = e.getActionCommand();
			createProjectDialog();
		}
	}
	private void errorDialog() {
		JDialog errorDialog = new JDialog();
		
		errorDialog.setModal(true);             
		errorDialog.setMinimumSize(new Dimension(700, 500));
		errorDialog.setLocationRelativeTo(null);
		errorDialog.setTitle("dis is not funking workiNG, u can only have one ONE projeckt");
		
		errorPanel = new JPanel(new GridBagLayout());
		errorPanel.setBackground(Color.WHITE);
		
		buttonError = new JButton("AWAY'WISHU");
		buttonError.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				errorDialog.dispose();
			
			}
		});
		
		c.gridy++;
		errorPanel.add(buttonError, c);
		errorDialog.getContentPane().add(errorPanel); 
		errorDialog.pack();
		errorDialog.setVisible(true);
		
	}

	private void createProjectDialog() {

		manager.projectAlreadyExists = true;

		JDialog createProjectDialog = new JDialog();
		createProjectDialog.setModal(true);             
		createProjectDialog.setMinimumSize(new Dimension(700, 500));
		createProjectDialog.setLocationRelativeTo(null);
		createProjectDialog.setTitle("Create project");

		createProjectPanel = new JPanel(new GridBagLayout());
		createProjectPanel.setBackground(Color.white);

		c = new GridBagConstraints();

		c.insets = new Insets(5, 0, 0, 0);

		//Textfields
		textFieldProjectName = new JTextField(20);
		createField("Project name: ", textFieldProjectName);

		textFieldProjectDeadline = new JTextField(20);
		createField("Deadline: ", textFieldProjectDeadline);

		textFieldProjectGrade = new JTextField(20);
		createField("Grade: ", textFieldProjectGrade);

		buttonCreateProject = new JButton("Addddd");
		buttonCreateProject.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				manager.createProject(courseCode, textFieldProjectName.getText(), textFieldProjectDeadline.getText(), textFieldProjectGrade.getText());
				createClosingDialog();
				createProjectDialog.dispose();

			}
		});
		c.gridy++;
		createProjectPanel.add(buttonCreateProject, c);
		createProjectDialog.getContentPane().add(createProjectPanel); 
		createProjectDialog.pack();
		createProjectDialog.setVisible(true);

	}

	private void createClosingDialog() {

		JDialog dialogClosing = new JDialog();
		dialogClosing.setModal(true);             
		dialogClosing.setMinimumSize(new Dimension(400, 200));
		dialogClosing.setLocationRelativeTo(null);
		dialogClosing.setTitle("Success!");
		JLabel labelSuccess = new JLabel("You hade successfully created a new project! ");
		createProjectPanel = new JPanel(new GridBagLayout());

		createProjectPanel.setBackground(Color.WHITE);
		JButton buttonClose = new JButton("Close");

		buttonClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dialogClosing.dispose();

			}
		});

		createProjectPanel.add(labelSuccess,c);
		c.gridy++;
		c.insets = new Insets(20,0,0,0);
		createProjectPanel.add(buttonClose, c);


		dialogClosing.getContentPane().add(createProjectPanel); 
		dialogClosing.pack();
		dialogClosing.setVisible(true);

	}

	private void createField(String labelName, JTextField textField) {

		c.gridx = 0;
		c.gridy = y;

		JLabel label1 = new JLabel(labelName);
		createProjectPanel.add(label1, c);

		c.gridx++;

		createProjectPanel.add(textField, c);

		y++;
	}
}
