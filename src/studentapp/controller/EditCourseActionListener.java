package studentapp.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EditCourseActionListener implements ActionListener {
	
	//FIX THIS PLZ
	//textFieldCourse get old courseCode to edit from courses and coursesGR
	//Instead of not editable, else index out of bounds e

	private Manager manager;
	private GridBagConstraints c;
	private JPanel editCoursePanel;
	private JTextField textFieldCourseName, textFieldCourseCode, textFieldCoursehp, textFieldCoursePace, textFieldCoursePlan, textFieldCourseSchedule, textFieldApplicationCode, textFieldApplicationDate;

	private int y;
	private String courseCode;
	private String radioButtonAction;

	private JRadioButton radioButtonCurrent, radioButtonUpcoming, radioButtonUncompleted, radioButtonCompleted;

	public EditCourseActionListener(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		courseCode = e.getActionCommand();
		createEditDialog();

	}

	private void createEditDialog() {

		JDialog editCourseDialog = new JDialog();
		editCourseDialog.setModal(true);             
		editCourseDialog.setMinimumSize(new Dimension(700, 500));
		editCourseDialog.setLocationRelativeTo(null);
		editCourseDialog.setTitle("Edit course");

		editCoursePanel = new JPanel(new GridBagLayout());
		editCoursePanel.setBackground(Color.WHITE);

		c = new GridBagConstraints();

		c.insets = new Insets(5, 0, 0, 0);

		//Textfields
		textFieldCourseName = new JTextField(20);
		textFieldCourseName.setText(manager.getCourseName(courseCode));
		createField("Course name: ", textFieldCourseName);

		textFieldCourseCode = new JTextField(20);
		textFieldCourseCode.setText(manager.getCourseCode(courseCode));
		textFieldCourseCode.setEditable(false);
		createField("Course code: ", textFieldCourseCode);

		textFieldCoursehp = new JTextField(20);
		textFieldCoursehp.setText(manager.getCourseCodehp(courseCode));
		createField("Course hp: ", textFieldCoursehp);

		textFieldCoursePace = new JTextField(20);
		textFieldCoursePace.setText(manager.getCoursePace(courseCode));
		createField("Course pace: ", textFieldCoursePace);

		textFieldCoursePlan = new JTextField(20);
		textFieldCoursePlan.setText(manager.getCoursePlan(courseCode));
		createField("Course plan URL: ", textFieldCoursePlan);

		textFieldCourseSchedule = new JTextField(20);
		textFieldCourseSchedule.setText(manager.getCourseSchedule(courseCode));
		createField("Course schedule URL: ", textFieldCourseSchedule);

		textFieldApplicationCode = new JTextField(20);
		textFieldApplicationCode.setText(manager.getCourseApplicationCode(courseCode));
		createField("Application code: ", textFieldApplicationCode);

		textFieldApplicationDate = new JTextField(20);
		textFieldApplicationDate.setText(manager.getCourseApplicationDate(courseCode));
		createField("Last application date: ", textFieldApplicationDate);

		//Radio buttons
		c.gridx= 0;
		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);

		editCoursePanel.add(new JLabel("Course status:"), c);

		radioButtonCurrent = new JRadioButton("Current");
		radioButtonCurrent.setActionCommand("current");
		radioButtonCurrent.setBackground(Color.WHITE);

		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx++;
		editCoursePanel.add(radioButtonCurrent, c);

		radioButtonUpcoming = new JRadioButton("Upcoming");
		radioButtonUpcoming.setActionCommand("upcoming");
		radioButtonUpcoming.setBackground(Color.WHITE);

		c.insets = new Insets(0, 0, 0, 0);
		c.gridy++;
		editCoursePanel.add(radioButtonUpcoming, c);

		radioButtonUncompleted = new JRadioButton("Uncompleted");
		radioButtonUncompleted.setActionCommand("uncompleted");
		radioButtonUncompleted.setBackground(Color.WHITE);

		c.gridy++;
		editCoursePanel.add(radioButtonUncompleted, c);

		radioButtonCompleted = new JRadioButton("Completed");
		radioButtonCompleted.setActionCommand("completed");
		radioButtonCompleted.setBackground(Color.WHITE);

		c.gridy++;
		editCoursePanel.add(radioButtonCompleted, c);
		
		
		if(manager.getRadioButtonAction(courseCode).equals("current")) {
			radioButtonCurrent.setSelected(true);
		}else if(manager.getRadioButtonAction(courseCode).equals("upcoming")) {
			radioButtonUpcoming.setSelected(true);
		}else if(manager.getRadioButtonAction(courseCode).equals("uncompleted")) {
			radioButtonUncompleted.setSelected(true);
		}else if(manager.getRadioButtonAction(courseCode).equals("completed")) {
			radioButtonCompleted.setSelected(true);
		}
		
		ButtonGroup group = new ButtonGroup();
		group.add(radioButtonCurrent);
		group.add(radioButtonUpcoming);
		group.add(radioButtonUncompleted);
		group.add(radioButtonCompleted);

		class RadioButtonActionListener implements ActionListener{

			private String radioButtonAction = "current";

			@Override
			public void actionPerformed(ActionEvent e) {
				radioButtonAction = e.getActionCommand();
			}

			public ActionListener getRadioButtonActionListener() {
				return this;
			}

			public String getActionString() {
				return radioButtonAction;
			}

		}

		RadioButtonActionListener radioButtonActionListener = new RadioButtonActionListener();
		radioButtonCurrent.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
		radioButtonUpcoming.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
		radioButtonUncompleted.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
		radioButtonCompleted.addActionListener(radioButtonActionListener.getRadioButtonActionListener());

		JButton buttonAccept = new JButton("Accept");
		buttonAccept.setMnemonic(KeyEvent.VK_C);
		buttonAccept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String applicationCode = textFieldApplicationCode.getText();
				String lastApplicationDate = textFieldApplicationDate.getText();
				String coursehp = textFieldCoursehp.getText();
				String courseCode = textFieldCourseCode.getText();
				String courseName = textFieldCourseName.getText();
				String coursePace = textFieldCoursePace.getText();
				String coursePlan = textFieldCoursePlan.getText();
				String courseSchedule = textFieldCourseSchedule.getText();
				radioButtonAction = radioButtonActionListener.getActionString();

				manager.editCourse(courseName, courseCode, applicationCode, coursehp, coursePace, lastApplicationDate, coursePlan, courseSchedule, radioButtonAction);

				editCourseDialog.dispose();
			}
		});

		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		c.gridwidth = 2;
		editCoursePanel.add(buttonAccept, c);

		editCourseDialog.getContentPane().add(editCoursePanel); 
		editCourseDialog.pack();
		editCourseDialog.setVisible(true);
	}

	private void createField(String labelName, JTextField textField) {

		c.gridx = 0;
		c.gridy = y;

		JLabel label1 = new JLabel(labelName);
		editCoursePanel.add(label1, c);

		c.gridx++;

		editCoursePanel.add(textField, c);

		y++;

	}


}
