package studentapp.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CourseGR extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GUI gui;

	//Test
	private JLabel courseInfoLabel1, courseInfoLabel2;

	private ProjectGR projectGR;
	private JLabel labelProjectName, labelProjectDeadline, labelProjectGrade;
	private JLabel labelExamDate, labelExamRoom, labelExamLastApplicationDate, labelExamGrade;

	private JPanel rootPanel;
	private JButton buttonDeleteCourse, buttonEditCourse, buttonCreateTask, buttonDeleteTask, buttonCreateExam, buttonDeleteExam,
	buttonDeleteProject, buttonCreateProject;
	private GridBagConstraints c;

	private String courseCode;
	private String applicationCode;
	private String points;
	private String coursePace;
	private String lastApplicationDate;
	private String courseName;
	private String coursePlan;
	private String schedule;
	private String radioButtonAction;

	private ExamGR examGR;
	private JLabel labelExamGR;

	private ArrayList<TaskGR> taskGRList;

	public CourseGR(GUI gui, JPanel panel, String courseName, String courseCode, String applicantionCode, String points, 
			String coursePace, String lastApplicationDate, String coursePlan, String schedule, String radioButtonAction) {
		this.gui = gui;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.applicationCode = applicantionCode;
		this.points = points;
		this.coursePace = coursePace;
		this.lastApplicationDate = lastApplicationDate;
		this.coursePlan = coursePlan;
		this.schedule = schedule;
		this.rootPanel = panel;
		this.radioButtonAction = radioButtonAction;

		taskGRList = new ArrayList<TaskGR>();

		createCourseGR(gui, panel);
	}

	private void createCourseGR(GUI gui, JPanel panel) {

		setLayout(new GridBagLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;

		courseInfoLabel1 = new JLabel(courseName + " | " + points + " | " + courseCode);
		courseInfoLabel2 = new JLabel(lastApplicationDate + " | " + applicationCode + " | " + coursePace);

		add(courseInfoLabel1, c);
		c.gridy++;

		add(courseInfoLabel2, c);
		c.gridy++;

		c.gridy++;
		buttonCreateTask = new JButton("Create Task");
		buttonCreateTask.setActionCommand(courseCode + "");
		add(buttonCreateTask, c);

		c.gridy++;
		buttonDeleteTask = new JButton("Delete Task");
		buttonDeleteTask.setActionCommand(courseCode + "");
		add(buttonDeleteTask, c);

		c.gridy++;
		buttonCreateProject = new JButton("Create Project");
		buttonCreateProject.setActionCommand(courseCode + "");
		add(buttonCreateProject, c);

		c.gridy++;
		buttonDeleteProject = new JButton("Delete Project");
		buttonDeleteProject.setActionCommand(courseCode + "");
		add(buttonDeleteProject, c);

		c.gridy++;
		buttonCreateExam = new JButton("Create Exam");
		buttonCreateExam.setActionCommand(courseCode + "");
		add(buttonCreateExam, c);

		c.gridy++;
		buttonDeleteExam = new JButton("Delete Exam");
		buttonDeleteExam.setActionCommand(courseCode + "");
		add(buttonDeleteExam, c);

		c.gridy++;
		buttonEditCourse = new JButton("Edit Course");
		buttonEditCourse.setActionCommand(courseCode + "");
		add(buttonEditCourse, c);

		c.gridy++;
		buttonDeleteCourse = new JButton("Delete Course");
		buttonDeleteCourse.setActionCommand(courseCode + "");
		add(buttonDeleteCourse, c);

		gui.addComponent(panel, this);
	}

	private void updateGR() {
		buttonEditCourse.setActionCommand(courseCode + "");

		courseInfoLabel1.setText(courseName + " | " + points + " | " + courseCode);
		courseInfoLabel2.setText(lastApplicationDate + " | " + applicationCode + " | " + coursePace);
	}

	public void editCourseGR(CourseGR courseGR, JPanel panel, String courseName, String courseCode, String applicantionCode, String points, 
			String coursePace, String lastApplicationDate, String coursePlan, String schedule, String radioButtonAction) {

		this.courseName = courseName;
		this.courseCode = courseCode;
		this.applicationCode = applicantionCode;
		this.points = points;
		this.coursePace = coursePace;
		this.lastApplicationDate = lastApplicationDate;
		this.coursePlan = coursePlan;
		this.schedule = schedule;
		this.radioButtonAction = radioButtonAction;

		removeCourseGR(rootPanel, courseGR);

		updateGR();

		gui.addComponent(panel, courseGR);
		rootPanel = panel;
	}

	public void removeCourseGR(JPanel panel, CourseGR courseGR) {
		panel.remove(courseGR);
		panel.revalidate();
		panel.repaint();
	}

	//Tasks
	public void addTaskGR(TaskGR taskGR) {

		taskGR.createTaskGRLabels(taskGR.getTaskName(), taskGR.getTaskDeadline(), taskGR.getTaskGrade());

		taskGRList.add(taskGR);

		c.gridy++;
		add(taskGR.getLabelTaskName(), c);

		c.gridy++;
		add(taskGR.getLabelTaskDeadline(), c);

		c.gridy++;
		add(taskGR.getLabelTaskGrade(), c);

		revalidate();
		repaint();

	}

	public void removeTask() {

		if(taskGRList.size() > 0) {

			remove(taskGRList.get(taskGRList.size()-1).getLabelTaskName());
			remove(taskGRList.get(taskGRList.size()-1).getLabelTaskDeadline());
			remove(taskGRList.get(taskGRList.size()-1).getLabelTaskGrade());

			taskGRList.remove(taskGRList.size()-1);

			revalidate();
			repaint();
		}

	}

	public void addProjectGR(ProjectGR projectGR) {

		//Skapade instansvariabler av typen JLabel i denna klass
		//Gettar namnet från ProjectGR till labels

		labelProjectName = new JLabel(projectGR.getProjectName());
		labelProjectDeadline = new JLabel(projectGR.getProjectDeadline());
		labelProjectGrade = new JLabel(projectGR.getProjectGrade());

		c.gridy++;
		add(labelProjectName, c);

		c.gridy++;
		add(labelProjectDeadline, c);

		c.gridy++;
		add(labelProjectGrade, c);

		revalidate();
		repaint();

	}

	public void deleteProject() {

		remove(labelProjectName);
		remove(labelProjectDeadline);
		remove(labelProjectGrade);
		
		revalidate();
		repaint();
	}

	//Exams
	public void addExamGR(ExamGR examGR) {

		labelExamDate = new JLabel(examGR.getExamDate());
		labelExamRoom = new JLabel(examGR.getExamRoom());
		labelExamLastApplicationDate = new JLabel(examGR.getExamLastApplicationDate());
		labelExamGrade = new JLabel(examGR.getExamGrade());

		c.gridy++;
		add(labelExamDate, c);

		c.gridy++;
		add(labelExamRoom, c);

		c.gridy++;
		add(labelExamLastApplicationDate, c);
		
		c.gridy++;
		add(labelExamGrade, c);

		revalidate();
		repaint();

	}

	public void removeExam() {

		remove(labelExamDate);
		remove(labelExamRoom);
		remove(labelExamLastApplicationDate);
		remove(labelExamGrade);

		revalidate();
		repaint();
	}

	public String taskGRListToString() {

		String returnString = "";

		for(int i = 0; i < taskGRList.size(); i++) {

			returnString += taskGRList.get(i).getTaskName() + " " + taskGRList.get(i).getTaskDeadline() + " " + taskGRList.get(i).getTaskGrade() + "\n";
		}

		return returnString;

	}

	//Getters n Setters

	public JButton getButtonCreateProject() {

		return buttonCreateProject;
	}

	public JButton getButtonDeleteProject() {
		return buttonDeleteProject;
	}

	public JButton getButtonCreateExam() {
		return buttonCreateExam;
	}
	
	public JButton getButtonDeleteExam() {
		return buttonDeleteExam;
	}

	public JButton getButtonCreateTask() {
		return buttonCreateTask;
	}

	public JButton getButtonDeleteTask() {
		return buttonDeleteTask;
	}

	public JButton getButtonRemoveCourse() {
		return buttonDeleteCourse;
	}

	public JButton getButtonEditCourse() {
		return buttonEditCourse;
	}

	public String getRadioButtonAction() {
		return radioButtonAction;
	}

	public void setRadioButtonAction(String radioButtonAction) {
		this.radioButtonAction = radioButtonAction;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public JPanel getJPanel() {
		return rootPanel;
	}

}
