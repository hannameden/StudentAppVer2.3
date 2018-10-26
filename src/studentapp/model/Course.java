package studentapp.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private String courseCode;
	private String applicationCode;
	private String points;
	private String coursePace;
	private String lastApplicationDate;
	private String courseName;
	private String coursePlan;
	private String courseSchedule;
	private List<Task> taskList;
	private Exam exam;
	private Project project;

	public Course(String courseName, String courseCode, String applicantionCode, String points, String coursePace, String lastApplicationDate, String coursePlan, String schedule) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.applicationCode = applicantionCode;
		this.points = points;
		this.coursePace = coursePace;
		this.lastApplicationDate = lastApplicationDate;
		this.coursePlan = coursePlan;
		this.courseSchedule = schedule;
		taskList = new ArrayList<Task>();

	}

	public void editCourse(String courseName, String courseCode, String applicantionCode, String points, String coursePace, String lastApplicationDate, String coursePlan, String schedule) {
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.applicationCode = applicantionCode;
		this.points =  points;
		this.coursePace = coursePace;
		this.lastApplicationDate = lastApplicationDate;
		this.coursePlan = coursePlan;
		this.courseSchedule = schedule;
	}

	//Tasks
	public void addTask(Task task) {
		taskList.add(task);
	}

	public void removeTask() {
		if(taskList.size() > 0)
			taskList.remove(taskList.size()-1);
		
		System.out.println("Model: " + this.taskListToString());
	}
	
	public String taskListToString() {

		String returnString = "";

		for(int i = 0; i < taskList.size(); i++) {

			returnString += taskList.get(i).getTaskName() + " " + taskList.get(i).getTaskDeadline() + " " + taskList.get(i).getTaskGrade() + "\n";
		}

		return returnString;

	}

	//Project
	public void addProject(Project project) {
		this.project = project;
		
	}
	
	public void deleteProject() {
		this.project.setProjectName("");
		this.project.setProjectDeadline("");
		this.project.setProjectGrade("");
		
	}
	
	//Exams
	public void addExam(Exam exam) {
		this.exam = exam;
	}
	
	public void removeExam() {
		this.exam.setExamDate("");
		this.exam.setExamRoom("");
		this.exam.setExamLastApplicationDate("");
		this.exam.setExamGrade("");
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getPoints() {
		return points;
	}

	public String getCoursePace() {
		return coursePace;
	}

	public String getLastApplicationDate() {
		return lastApplicationDate;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCoursePlan() {
		return coursePlan;
	}

	public String getCourseSchedule() {
		return courseSchedule;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public Exam getExam() {
		return exam;
	}

	public Project getProject() {
		return project;
	}

	

}
