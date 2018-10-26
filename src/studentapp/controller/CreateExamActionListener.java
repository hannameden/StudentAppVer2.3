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

public class CreateExamActionListener implements ActionListener {

	private Manager manager;

	private GridBagConstraints c;
	private JButton buttonError;
	private JPanel panelCreateExam, errorPanel;
	private JTextField textFieldExamDate, textFieldExamRoom, textFieldExamLastApplicationDate, textFieldExamGrade;

	private String courseCode;
	private int y;

	public CreateExamActionListener(Manager manager) {
		this.manager = manager;
		manager.examAlreadyExists = false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(manager.examAlreadyExists == true) {
			errorDialog();
			
		}else {
			courseCode = e.getActionCommand();
			createExamDialog();
		}
	}
	private void errorDialog() {
		JDialog errorDialog = new JDialog();
		
		errorDialog.setModal(true);             
		errorDialog.setMinimumSize(new Dimension(700, 500));
		errorDialog.setLocationRelativeTo(null);
		errorDialog.setTitle("dis is not funking workiNG, u can only have one ONE EKSAMMMM!!");
		
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

	private void createExamDialog() {

		JDialog dialogCreateExam = new JDialog();
		dialogCreateExam.setModal(true);             
		dialogCreateExam.setMinimumSize(new Dimension(700, 500));
		dialogCreateExam.setLocationRelativeTo(null);
		dialogCreateExam.setTitle("Create exam");

		panelCreateExam = new JPanel(new GridBagLayout());
		panelCreateExam.setBackground(Color.WHITE);

		c = new GridBagConstraints();

		c.insets = new Insets(5, 0, 0, 0);

		//Textfields
		textFieldExamDate = new JTextField(20);
		createField("Exam date: ", textFieldExamDate);

		textFieldExamRoom = new JTextField(20);
		createField("Exam room: ", textFieldExamRoom);

		textFieldExamLastApplicationDate = new JTextField(20);
		createField("Exam last application date: ", textFieldExamLastApplicationDate );

		textFieldExamGrade = new JTextField(20);
		createField("Exam grade: ", textFieldExamGrade);

		JButton buttonAddTask = new JButton("Create");
		buttonAddTask.setMnemonic(KeyEvent.VK_C);
		buttonAddTask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String examDate = textFieldExamDate.getText();
				String examRoom = textFieldExamRoom.getText();
				String examLastApplicationDate = textFieldExamLastApplicationDate.getText();
				String examGrade = textFieldExamGrade.getText();

				manager.examAlreadyExists = true;
				manager.createExam(courseCode, examDate, examRoom, examLastApplicationDate, examGrade);

				dialogCreateExam.dispose();
			}
		});

		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		c.gridwidth = 2;
		panelCreateExam.add(buttonAddTask, c);

		dialogCreateExam.getContentPane().add(panelCreateExam); 
		dialogCreateExam.pack();
		dialogCreateExam.setVisible(true);
	}

	private void createField(String labelName, JTextField textField) {

		c.gridx = 0;
		c.gridy = y;

		JLabel label1 = new JLabel(labelName);
		panelCreateExam.add(label1, c);

		c.gridx++;

		panelCreateExam.add(textField, c);

		y++;

	}

}
