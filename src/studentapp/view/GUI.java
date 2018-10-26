package studentapp.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;


public class GUI {
	
	//HEjsan github fakking testing

	private JFrame frame;
	private JPanel panelMain, panelCurrent, panelUpcoming, panelUncompleted, panelCompleted,
	panelSPCurrent, panelSPUpcoming, panelSPUncompleted, panelSPCompleted;
	private JTabbedPane panelTabbed;
	private JButton buttonCreateCourse, buttonCreateStudyProgramme;

	private LogInDialog loginDialog;
	private JTextField username;
	private String frameTitle;

	private int frameWidth = 1600, frameHeight = 900;

	private GridBagLayout gbl;
	private GridBagConstraints c;

	private ArrayList<CourseGR> coursesGR;
	private ActionListener removeCourseActionListener;

	public GUI() {

		coursesGR = new ArrayList<CourseGR>();

		createTabbedPanel();
		createFrame();
		createToolBar();
		//createLogInDialog(800, 450);
	}


	private void createLogInDialog(int frameWidth, int frameHeight) {

		JDialog logInDialog = new JDialog();
		logInDialog.setModal(true);             
		logInDialog.setMinimumSize(new Dimension(frameWidth, frameHeight));
		logInDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		logInDialog.setLocationRelativeTo(null);
		logInDialog.setTitle("Login");

		JPanel panelLogInDialog = new JPanel(new GridBagLayout());
		panelLogInDialog.setBackground(Color.WHITE);

		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;

		JLabel usernameLabel = new JLabel("Give me your name ");
		panelLogInDialog.add(usernameLabel, c);

		c.gridy++;
		username = new JTextField(10);	
		panelLogInDialog.add(username,c);
		c.gridy++;
		JButton buttonLogin = new JButton("Log in");
		buttonLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				logInDialog.dispose();
				createTabbedPanel();
				createFrame();
				createToolBar();


			}
		});
		panelLogInDialog.add(buttonLogin, c);

		logInDialog.getContentPane().add(panelLogInDialog);
		logInDialog.pack();
		logInDialog.setVisible(true);
	}

	private void createFrame() {
		//frame = new JFrame(username.getText());
		frame = new JFrame("StudentApp");
		frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//new MenuBar(this);

		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);

		panelMain.add(panelTabbed);

		frame.getContentPane().add(panelMain);
		frame.pack();
		frame.setVisible(true);

	}

	private void createToolBar() {

		JToolBar toolbar = new JToolBar();
		toolbar.setBackground(Color.WHITE);

		ImageIcon icon1 = new ImageIcon("res/TestAdd.png");


		buttonCreateCourse = new JButton(icon1);
		buttonCreateCourse.setToolTipText("Add course");
		buttonCreateCourse.setMnemonic(KeyEvent.VK_C);
		toolbar.add(buttonCreateCourse);

		buttonCreateStudyProgramme = new JButton(icon1);
		buttonCreateStudyProgramme.setToolTipText("Add study programme");
		buttonCreateStudyProgramme.setMnemonic(KeyEvent.VK_S);
		toolbar.add(buttonCreateStudyProgramme);

		frame.add(toolbar, BorderLayout.PAGE_START);
	}

	private void createTabbedPanel() {

		gbl = new GridBagLayout();
		Border blackline = BorderFactory.createLineBorder(Color.black);

		panelTabbed = new JTabbedPane();
		panelTabbed.setPreferredSize(new Dimension(frameWidth, frameHeight));

		//West
		panelCurrent  = new JPanel(gbl);
		panelCurrent.setBackground(Color.white);
		TitledBorder titleBorder1 = BorderFactory.createTitledBorder(blackline, "Current");
		titleBorder1.setTitlePosition(TitledBorder.ABOVE_TOP);
		panelCurrent.setBorder(titleBorder1);
		JScrollPane scrollPanelCurrent = new JScrollPane(panelCurrent);

		//Center
		panelUpcoming  = new JPanel(gbl);
		panelUpcoming.setBackground(Color.white);
		TitledBorder titleBorder2 = BorderFactory.createTitledBorder(blackline, "Upcoming");
		titleBorder2.setTitlePosition(TitledBorder.ABOVE_TOP);
		panelUpcoming.setBorder(titleBorder2);
		JScrollPane scrollPanelUpcoming = new JScrollPane(panelUpcoming);

		//East
		panelUncompleted = new JPanel(gbl);
		panelUncompleted.setBackground(Color.white);
		TitledBorder titleBorder3 = BorderFactory.createTitledBorder(blackline, "Uncompleted");
		titleBorder3.setTitlePosition(TitledBorder.ABOVE_TOP);
		panelUncompleted.setBorder(titleBorder3);
		JScrollPane scrollPanelUncompleted = new JScrollPane(panelUncompleted);

		//Main
		JPanel mainCurrentEducationPanel = new JPanel(new GridLayout(1, 3));
		mainCurrentEducationPanel.add(scrollPanelCurrent);
		mainCurrentEducationPanel.add(scrollPanelUpcoming);
		mainCurrentEducationPanel.add(scrollPanelUncompleted);


		panelTabbed.addTab("Current education", mainCurrentEducationPanel);
		panelTabbed.setMnemonicAt(0, KeyEvent.VK_1);

		panelCompleted = new JPanel(gbl);
		panelTabbed.addTab("Completed education", panelCompleted);
		panelTabbed.setMnemonicAt(1, KeyEvent.VK_2);

	}

	public void createStudyProgrammePanel(String programmeName ,String programmePoints) {

		Border blackline = BorderFactory.createLineBorder(Color.black);
		TitledBorder titleBorderName = BorderFactory.createTitledBorder(blackline, programmeName);

		//WEST
		panelSPCurrent = new JPanel(gbl);
		panelSPCurrent.setBackground(Color.WHITE);
		panelSPCurrent.setBorder(titleBorderName);

		JButton buttonAddCourseToSP = new JButton("ADD course to de SP");

		panelSPCurrent.add(buttonAddCourseToSP);
		addComponent(this.getPanelCurrent(), panelSPCurrent);

		panelCurrent.revalidate();
		panelCurrent.repaint();

		//Center
		panelSPUpcoming  = new JPanel(gbl);
		panelSPUpcoming.setBackground(Color.white);

		panelSPUpcoming.setBorder(titleBorderName);
		panelUpcoming.add(panelSPUpcoming);
		panelUpcoming.revalidate();
		panelUpcoming.repaint();


		//East
		panelSPUncompleted = new JPanel(gbl);
		panelSPUncompleted.setBackground(Color.white);
		titleBorderName.setTitlePosition(TitledBorder.ABOVE_TOP);
		panelSPUncompleted.setBorder(titleBorderName);
		panelUncompleted.add(panelSPUpcoming);
		panelUncompleted.revalidate();
		panelUncompleted.repaint();

	}

	//Courses
	public void createCourseGR(String courseName, String courseCode, String applicantionCode, String points, 
			String speed, String lastApplicationDate, String coursePlan, String schedule, 
			ActionListener editCourseActionListener, ActionListener removeCourseActionListener,
			ActionListener createTaskActionListener, ActionListener deleteTaskActionListener,
			ActionListener createProjectActionListener, ActionListener deleteProjectActionListener, 
			ActionListener createExamActionListener, ActionListener deleteExamActionListener, String radioButtonAction) {

		JPanel panel = null;

		if(radioButtonAction.equals("current")) {
			panel = this.getPanelCurrent();
		}else if(radioButtonAction.equals("upcoming")) {
			panel = this.getPanelUpcoming();
		}else if(radioButtonAction.equals("uncompleted")) {
			panel = this.getPanelUncompleted();
		}else if(radioButtonAction.equals("completed")) {
			panel = this.getPanelCompleted();
		}

		CourseGR courseGR = new CourseGR(this, panel, courseName, courseCode, applicantionCode, points, speed, lastApplicationDate, coursePlan, schedule, radioButtonAction);

		panel.revalidate();
		panel.repaint();

		courseGR.getButtonCreateTask().addActionListener(createTaskActionListener);
		courseGR.getButtonDeleteTask().addActionListener(deleteTaskActionListener);

		courseGR.getButtonCreateProject().addActionListener(createProjectActionListener);
		courseGR.getButtonDeleteProject().addActionListener(deleteProjectActionListener);

		courseGR.getButtonCreateExam().addActionListener(createExamActionListener); 
		courseGR.getButtonDeleteExam().addActionListener(deleteExamActionListener);   

		courseGR.getButtonEditCourse().addActionListener(editCourseActionListener);
		courseGR.getButtonRemoveCourse().addActionListener(removeCourseActionListener);

		coursesGR.add(courseGR);

		System.out.println("View courses: " + coursesGR.size());

	}

	public void editCourseGR(String courseName, String courseCode, String applicantionCode, String points, String speed,
			String lastApplicationDate, String coursePlan, String schedule, String radioButtonAction) {

		JPanel panel = null;

		if(radioButtonAction.equals("current")) {
			panel = this.getPanelCurrent();
		}else if(radioButtonAction.equals("upcoming")) {
			panel = this.getPanelUpcoming();
		}else if(radioButtonAction.equals("uncompleted")) {
			panel = this.getPanelUncompleted();
		}else if(radioButtonAction.equals("completed")) {
			panel = this.getPanelCompleted();
		}

		int indexOfCourseToEdit = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseToEdit);

		courseGR.editCourseGR(courseGR, panel, courseName, courseCode, applicantionCode, points, speed,
				lastApplicationDate, coursePlan, schedule, radioButtonAction);

		panel.revalidate();
		panel.repaint();

	}

	public void deleteCourse(String courseCode) {

		int indexOfCourseToRemove = getIndexOfCourseGR(courseCode);

		coursesGR.get(indexOfCourseToRemove).removeCourseGR(coursesGR.get(indexOfCourseToRemove).getJPanel(), coursesGR.get(indexOfCourseToRemove));

		coursesGR.remove(indexOfCourseToRemove);

		System.out.println("View courses: " + coursesGR.size());

	}

	//Tasks
	public void createTask(String courseCode, String taskName, String taskDeadline, String taskGrade) {

		int indexOfCourseGRToAddTaskTo = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseGRToAddTaskTo);

		TaskGR taskGR = new TaskGR(taskName, taskDeadline, taskGrade);

		courseGR.addTaskGR(taskGR);

	}

	public void deleteTask(String courseCode) {

		int indexOfCourseToRemoveTaskFrom = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseToRemoveTaskFrom);

		courseGR.removeTask();
	}

	//Project

	public void createProject(String courseCode, String projectName, String projectDeadline, String projectGrade) {

		int indexOfCourseGRToAddProjectTo = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseGRToAddProjectTo);

		ProjectGR projectGR = new ProjectGR(projectName, projectDeadline, projectGrade);

		courseGR.addProjectGR(projectGR);

	}

	public void deleteProject(String courseCode) {

		int indexOfCourseGRToDeleteProjectTo = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseGRToDeleteProjectTo);

		courseGR.deleteProject();

	}

	//Exams

	public void createExam(String courseCode, String examDate, String examRoom, String examLastApplicationDate, String examGrade) {

		int indexOfCourseGRToAddExamTo = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseGRToAddExamTo);

		ExamGR examGR = new ExamGR(examDate, examRoom, examLastApplicationDate, examGrade);

		courseGR.addExamGR(examGR);

		System.out.println("View exam: " + examGR.getExamDate() + " " + examGR.getExamRoom() + " " + examGR.getExamLastApplicationDate() + " " + examGR.getExamGrade());

	}

	public void deleteExam(String courseCode) {

		int indexOfCourseToRemoveExamFrom = getIndexOfCourseGR(courseCode);

		CourseGR courseGR = coursesGR.get(indexOfCourseToRemoveExamFrom);

		courseGR.removeExam();
	}

	//Adds

	public void addComponent(Container container, Component component) {
		c = new GridBagConstraints();
		c.insets = new Insets(10,0,10,0);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;

		c.gridwidth = GridBagConstraints.REMAINDER;

		c.weightx = 1;
		c.weighty = 1;

		container.add(component, c);
	}

	public void addCreateCourseActionListener(ActionListener createCourseActionListener) {
		buttonCreateCourse.addActionListener(createCourseActionListener);
	}

	public void addCreateStudyProgrammeActionListener(ActionListener createStudyProgrammeActionListener) {
		buttonCreateStudyProgramme.addActionListener(createStudyProgrammeActionListener);
	}


	//Getters n setters

	private int getIndexOfCourseGR(String courseCode) {

		for(int i = 0; i < coursesGR.size() ; i++) {

			if(courseCode.equals(coursesGR.get(i).getCourseCode())) {
				return i;

			}

		}

		return -3;
	}

	public String getRadioButtonAction(String courseCode) {
		return coursesGR.get(getIndexOfCourseGR(courseCode)).getRadioButtonAction();
	}

	public JPanel getPanelCurrent() {
		return panelCurrent;
	}

	public JPanel getPanelUpcoming() {
		return panelUpcoming;
	}

	public JPanel getPanelUncompleted() {
		return panelUncompleted;
	}

	public JPanel getPanelCompleted() {
		return panelCompleted;
	}

	public int getPanelCurrentWidth() {
		return panelCurrent.getWidth();
	}

	public JFrame getFrame() {
		return frame;
	}

	public JPanel getPanelMain() {
		return panelMain;
	}

}
