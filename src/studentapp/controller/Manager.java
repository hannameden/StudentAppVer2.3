package studentapp.controller;

import studentapp.model.Model;
import studentapp.view.GUI;

public class Manager {

	private Model model;
	private GUI gui;
	
	public boolean projectAlreadyExists;
	public boolean examAlreadyExists;

	private CreateStudyProgrammeActionListener createStudyProgrammeActionListener;

	private CreateCourseActionListener createCourseActionListener;
	private EditCourseActionListener editCourseActionListener;
	private DeleteCourseActionListener removeCourseActionListener;

	private CreateTaskActionListener createTaskActionListener;
	private DeleteTaskActionListener removeTaskActionListener;
	
	private CreateProjectActionListener createProjectActionListener;
	private DeleteProjectActionListener deleteProjectActionListener;

	private CreateExamActionListener createExamActionListener;
	private DeleteExamActionListener deleteExamActionListener;

	public Manager(GUI gui, Model model) {
		this.gui = gui;
		this.model = model;

		initiateListeners();
	}

	private void initiateListeners() {

		createCourseActionListener = new CreateCourseActionListener(this);
		gui.addCreateCourseActionListener(createCourseActionListener);

		createStudyProgrammeActionListener = new CreateStudyProgrammeActionListener(this);
		gui.addCreateStudyProgrammeActionListener(createStudyProgrammeActionListener);

	}

	//Study Programme
	public void addcreateStudyProgrammePanel(String programeName, String programmePoints) {
		gui.createStudyProgrammePanel(programeName,programmePoints);

	}

	//Courses
	public void createCourse(String courseName, String courseCode, String applicantionCode, String points, String speed, String lastApplicationDate, String coursePlan, String schedule, String radioButtonAction) {

		editCourseActionListener = new EditCourseActionListener(this);
		removeCourseActionListener = new DeleteCourseActionListener(this);

		createTaskActionListener = new CreateTaskActionListener(this);
		removeTaskActionListener = new DeleteTaskActionListener(this);
		
		createProjectActionListener = new CreateProjectActionListener(this);
		deleteProjectActionListener = new DeleteProjectActionListener(this);

		createExamActionListener = new CreateExamActionListener(this);
		deleteExamActionListener = new DeleteExamActionListener(this);

		model.createCourse(courseName, courseCode, applicantionCode, points, speed, lastApplicationDate, coursePlan, schedule);

		gui.createCourseGR(courseName, courseCode, applicantionCode,  points, speed, lastApplicationDate, coursePlan, schedule,
				editCourseActionListener, removeCourseActionListener, 
				createTaskActionListener, removeTaskActionListener, 
				createProjectActionListener, deleteProjectActionListener,
				createExamActionListener, deleteExamActionListener, radioButtonAction);

	}

	public void editCourse(String courseName, String courseCode, String applicantionCode, String points, String coursePace, String lastApplicationDate, String coursePlan, String schedule, String radioButtonAction) {

		//System.out.println(courseCode);

		model.editCourse(courseName, courseCode, applicantionCode, points, coursePace, lastApplicationDate, coursePlan, schedule);

		gui.editCourseGR(courseName, courseCode, applicantionCode, points, coursePace, lastApplicationDate, coursePlan, schedule, radioButtonAction);

	}

	public void deleteCourse(String courseCode) {

		model.deleteCourse(courseCode);
		gui.deleteCourse(courseCode);

	}

	//Tasks
	public void createTask(String courseCode,String taskName, String taskDeadline, String taskGrade) {

		model.createTask(courseCode, taskName, taskDeadline, taskGrade);
		gui.createTask(courseCode, taskName, taskDeadline, taskGrade);
	}

	public void deleteTask(String courseCode) {

		model.deleteTask(courseCode);
		gui.deleteTask(courseCode);
	}

	//Project
	public void createProject(String courseCode, String projectName, String projectDeadline, String projectGrade) {

		model.createProject(courseCode, projectName, projectDeadline, projectGrade);
		gui.createProject(courseCode, projectName, projectDeadline, projectGrade);
	}
	public void deleteProject(String courseCode) {

		model.deleteProject(courseCode);
		gui.deleteProject(courseCode);
	}

	//Exams
	public void createExam(String courseCode, String examDate, String examRoom, String examLastApplicationDate, String examGrade) {

		model.createExam(courseCode, examDate, examRoom, examLastApplicationDate, examGrade);
		gui.createExam(courseCode, examDate, examRoom, examLastApplicationDate, examGrade);

	}

	public void deleteExam(String courseCode) {

		model.deleteExam(courseCode);
		gui.deleteExam(courseCode);
	}

	//View getters
	public String getRadioButtonAction(String courseCode) {
		return gui.getRadioButtonAction(courseCode);
	}


	//Model getters
	public String getCourseName(String courseCode) {
		return model.getCourseName(courseCode);
	}

	public String getCourseCode(String courseCode) {
		return model.getCourseCode(courseCode);
	}

	public String getCourseCodehp(String courseCode) {
		return model.getCoursePoints(courseCode);
	}

	public String getCoursePace(String courseCode) {
		return model.getCoursePace(courseCode);
	}

	public String getCoursePlan(String courseCode) {
		return model.getCoursePlan(courseCode);
	}

	public String getCourseSchedule(String courseCode) {
		return model.getCourseSchedule(courseCode);
	}

	public String getCourseApplicationCode(String courseCode) {
		return model.getCourseApplicationCode(courseCode);
	}

	public String getCourseApplicationDate(String courseCode) {
		return model.getApplicationDate(courseCode);
	}

}
