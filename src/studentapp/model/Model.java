package studentapp.model;

import java.util.ArrayList;

public class Model {

	private ArrayList<Course> courses;

	public Model() {

		initiate();
	}

	private void initiate() {
		courses = new ArrayList<Course>();
	}

	//Courses
	public void createCourse(String name, String courseCode, String applicantionCode, String points, String speed, String lastApplicationDate, String coursePlan, String schedule) {

		Course course = new Course(name, courseCode, applicantionCode, points, speed, lastApplicationDate, coursePlan, schedule);

		courses.add(course);

		System.out.println("Model courses: " + courses.size());

	}

	public void editCourse(String courseName, String courseCode, String applicantionCode, String points, String coursePace, String lastApplicationDate, String coursePlan, String schedule) {

		int indexOfCourseToEdit = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToEdit);

		course.editCourse(courseName, courseCode, applicantionCode, points, coursePace, lastApplicationDate, coursePlan, schedule);
	}

	public void deleteCourse(String courseCode) {

		int indexOfCourseToRemove = getIndexOfCourse(courseCode);

		courses.remove(indexOfCourseToRemove);

		System.out.println("Model courses: " + courses.size());
	}

	//Tasks
	public void createTask(String courseCode, String taskName, String taskDeadline, String taskGrade) {

		int indexOfCourseToAddTaskTo = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToAddTaskTo);

		Task task = new Task(taskName, taskDeadline, taskGrade);

		course.addTask(task);

	}
	
	//Projects
	public void createProject(String courseCode, String projectName, String projectDeadline, String projectGrade) {

		int indexOfCourseToAddProjectTo = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToAddProjectTo);

		Project project = new Project(projectName, projectDeadline, projectGrade);

		course.addProject(project);

		System.out.println(project.getProjectName());

	}

	public void deleteProject(String courseCode) {

		int indexOfCourseToDeleteProjectTo = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToDeleteProjectTo);
		
		course.deleteProject();

	}

	public void deleteTask(String courseCode) {

		int indexOfCourseToRemoveTaskFrom = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToRemoveTaskFrom);

		course.removeTask();
	}

	//Exams
	public void createExam(String courseCode, String examDate, String examRoom, String examLastApplicationDate, String examGrade) {
		
		int indexOfCourseToAddExamTo = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToAddExamTo);

		Exam exam = new Exam(examDate, examRoom, examLastApplicationDate, examGrade);

		course.addExam(exam);
		
		System.out.println("Model exam: " + exam.getExamDate() + " " + exam.getExamRoom() + " " + exam.getExamLastApplicationDate() + " " + exam.getExamGrade());
	}
	
	public void deleteExam(String courseCode) {
		int indexOfCourseToRemoveExamFrom = getIndexOfCourse(courseCode);

		Course course = courses.get(indexOfCourseToRemoveExamFrom);

		course.removeExam();
	}

	//Getters n setters
	public Course getCourse(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode));
	}

	private int getIndexOfCourse(String courseCode) {

		for(int i = 0; i < courses.size(); i++) {

			if(courseCode.equals(courses.get(i).getCourseCode())) {
				return i;
			}

		}

		return -2;
	}

	public String getCourseName(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getCourseName().toString();
	}

	public String getCourseCode(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getCourseCode().toString();
	}

	public String getCoursePoints(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getPoints().toString();
	}

	public String getCoursePace(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getCoursePace().toString();
	}

	public String getCoursePlan(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getCoursePlan().toString();
	}

	public String getCourseSchedule(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getCourseSchedule().toString();
	}

	public String getCourseApplicationCode(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getApplicationCode().toString();
	}

	public String getApplicationDate(String courseCode) {
		return courses.get(getIndexOfCourse(courseCode)).getApplicationCode().toString();
	}

}
