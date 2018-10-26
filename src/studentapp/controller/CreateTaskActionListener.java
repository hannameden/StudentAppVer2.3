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

public class CreateTaskActionListener implements ActionListener {

	private Manager manager;
	private String courseCode;
	
	private GridBagConstraints c;

	private JPanel addTaskPanel;
	private JTextField textFieldTaskName, textFieldTaskDeadline, textFieldTaskGrade;

	private int y;
	
	public CreateTaskActionListener(Manager manager) {
		this.manager = manager;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		courseCode = e.getActionCommand();
		createAddTaskDialog();

	}

	private void createAddTaskDialog() {

		JDialog addTaskDialog = new JDialog();
		addTaskDialog.setModal(true);             
		addTaskDialog.setMinimumSize(new Dimension(700, 500));
		addTaskDialog.setLocationRelativeTo(null);
		addTaskDialog.setTitle("Create task");

		addTaskPanel = new JPanel(new GridBagLayout());
		addTaskPanel.setBackground(Color.WHITE);

		c = new GridBagConstraints();

		c.insets = new Insets(5, 0, 0, 0);

		//Textfields
		textFieldTaskName = new JTextField(20);
		createField("Task name: ", textFieldTaskName);

		textFieldTaskDeadline = new JTextField(20);
		createField("Task deadline: ", textFieldTaskDeadline);
		
		textFieldTaskGrade = new JTextField(20);
		createField("Task grade: ", textFieldTaskGrade );

		JButton buttonAddTask = new JButton("Add");
		buttonAddTask.setMnemonic(KeyEvent.VK_C);
		buttonAddTask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String taskName = textFieldTaskName.getText();
				String taskDeadline = textFieldTaskDeadline.getText();
				String taskGrade = textFieldTaskGrade.getText();
				
				manager.createTask(courseCode, taskName, taskDeadline, taskGrade);

				addTaskDialog.dispose();
			}
		});

		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		c.gridwidth = 2;
		addTaskPanel.add(buttonAddTask, c);

		addTaskDialog.getContentPane().add(addTaskPanel); 
		addTaskDialog.pack();
		addTaskDialog.setVisible(true);
	}
	
	private void createField(String labelName, JTextField textField) {

		c.gridx = 0;
		c.gridy = y;

		JLabel label1 = new JLabel(labelName);
		addTaskPanel.add(label1, c);

		c.gridx++;

		addTaskPanel.add(textField, c);

		y++;

	}

}
