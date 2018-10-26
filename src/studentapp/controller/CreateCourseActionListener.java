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

public class CreateCourseActionListener implements ActionListener {
	
	private Manager manager;
	private GridBagConstraints c;
	private JPanel createCoursePanel;
	private JButton buttonCreate;
	private JTextField textFieldCourseName, textFieldCourseCode, textFieldCoursehp, textFieldCoursePace, textFieldCoursePlan, textFieldCourseSchedule, textFieldApplicationCode, textFieldApplicationDate;
	private int textFieldWidth = 25, y;
	
	
	private String radioButtonAction;
	
	private JRadioButton radioButtonCurrent, radioButtonUpcoming, radioButtonUncompleted, radioButtonCompleted;
	
	public CreateCourseActionListener(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		createCourseDialog();
	
		}
		
	private void createCourseDialog() {
		
		JDialog createCourseDialog = new JDialog();
		createCourseDialog.setModal(true);             
		createCourseDialog.setMinimumSize(new Dimension(700, 500));
		createCourseDialog.setLocationRelativeTo(null);
		createCourseDialog.setTitle("Create course");
		
		createCoursePanel = new JPanel(new GridBagLayout());
		createCoursePanel.setBackground(Color.WHITE);
		
		c = new GridBagConstraints();
		
		c.insets = new Insets(5, 0, 0, 0);
		
		//Textfields
		textFieldCourseName = new JTextField(textFieldWidth);
		createField("Course name: ", textFieldCourseName);
		
		textFieldCourseCode = new JTextField(textFieldWidth);
		createField("Course code: ", textFieldCourseCode);
		
		textFieldCoursehp = new JTextField(textFieldWidth);
		createField("Course hp: ", textFieldCoursehp);
		
		textFieldCoursePace = new JTextField(textFieldWidth);
		createField("Course pace: ", textFieldCoursePace);
		
		textFieldCoursePlan = new JTextField(textFieldWidth);
		createField("Course plan URL: ", textFieldCoursePlan);
		
		textFieldCourseSchedule = new JTextField(textFieldWidth);
		createField("Course schedule URL: ", textFieldCourseSchedule);
		
		textFieldApplicationCode = new JTextField(textFieldWidth);
		createField("Application code: ", textFieldApplicationCode);
		
		textFieldApplicationDate = new JTextField(textFieldWidth);
		createField("Last application date: ", textFieldApplicationDate);
		
		//Radio buttons
		c.gridx= 0;
		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		
		createCoursePanel.add(new JLabel("Course status:"), c);
		
		radioButtonCurrent = new JRadioButton("Current");
		radioButtonCurrent.setActionCommand("current");
		radioButtonCurrent.setBackground(Color.WHITE);
		radioButtonCurrent.setSelected(true);
	
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.gridx++;
		createCoursePanel.add(radioButtonCurrent, c);
		
		radioButtonUpcoming = new JRadioButton("Upcoming");
		radioButtonUpcoming.setActionCommand("upcoming");
		radioButtonUpcoming.setBackground(Color.WHITE);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.gridy++;
		createCoursePanel.add(radioButtonUpcoming, c);
		
		radioButtonUncompleted = new JRadioButton("Uncompleted");
		radioButtonUncompleted.setActionCommand("uncompleted");
		radioButtonUncompleted.setBackground(Color.WHITE);
		
		c.gridy++;
		createCoursePanel.add(radioButtonUncompleted, c);
		
		radioButtonCompleted = new JRadioButton("Completed");
		radioButtonCompleted.setActionCommand("completed");
		radioButtonCompleted.setBackground(Color.WHITE);
		
		c.gridy++;
		createCoursePanel.add(radioButtonCompleted, c);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(radioButtonCurrent);
	    group.add(radioButtonUpcoming);
	    group.add(radioButtonUncompleted);
	    group.add(radioButtonCompleted);
	    
	    class RadioButtonActionListener implements ActionListener{

	    	private String action = "current";
	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				action = e.getActionCommand();
			}
			
			public ActionListener getRadioButtonActionListener() {
				return this;
			}
			
			public String getActionString() {
				return action;
			}
			
	    }
	    
	    RadioButtonActionListener radioButtonActionListener = new RadioButtonActionListener();
	    radioButtonCurrent.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
	    radioButtonUpcoming.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
	    radioButtonUncompleted.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
	    radioButtonCompleted.addActionListener(radioButtonActionListener.getRadioButtonActionListener());
	    
	    
		//Test code
		textFieldCourseName.setText("Objektorienterad design och programmering");
		textFieldCourseCode.setText("DVG326");
		textFieldCoursehp.setText("7.5");
		textFieldCoursePace.setText("50%");
		textFieldCoursePlan.setText("http://utb.hig.se/fafne/app/public/pdf/jasper/course.pdf?identifier=DVG326");
		textFieldCourseSchedule.setText("http://schema.hig.se/setup/jsp/Schema.jsp?intervallTyp=m&sprak=SV&forklaringar=true&sokMedAND=true&intervallAntal=6&startDatum=idag&resurser=k.DVG326.18426.18-");
		textFieldApplicationCode.setText("18426");
		textFieldApplicationDate.setText("2018-09-03");
		//
		
		
		buttonCreate = new JButton("Create");
		buttonCreate.setMnemonic(KeyEvent.VK_C);
		buttonCreate.addActionListener(new ActionListener() {
			
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
				
				manager.createCourse(courseName, courseCode, applicationCode, coursehp, coursePace, lastApplicationDate, coursePlan, courseSchedule, radioButtonAction);
				
				createCourseDialog.dispose();
			}
		});
		
		c.gridy++;
		c.insets = new Insets(20, 0, 0, 0);
		c.gridwidth = 2;
		createCoursePanel.add(buttonCreate, c);
		
		createCourseDialog.getContentPane().add(createCoursePanel); 
		createCourseDialog.pack();
		createCourseDialog.setVisible(true);
	}
	
	private void createField(String labelName, JTextField textField) {
		
		c.gridx = 0;
		c.gridy = y;
		
		JLabel label1 = new JLabel(labelName);
		createCoursePanel.add(label1, c);
		
		c.gridx++;
		
		createCoursePanel.add(textField, c);
		
		y++;
		
	}

}
