package studentapp.model;

public class Task {

	private String taskGrade;
	private String taskName;
	private String taskDeadline;
	
	public Task(String taskName, String taskDeadline, String taskGrade) {
		this.taskName = taskName;
		this.taskDeadline = taskDeadline;
		this.taskGrade = taskGrade;
	}

	public String getTaskGrade() {
		return taskGrade;
	}

	public void setTaskGrade(String taskGrade) {
		this.taskGrade = taskGrade;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDeadline() {
		return taskDeadline;
	}

	public void setTaskDeadline(String taskDeadline) {
		this.taskDeadline = taskDeadline;
	}
	
}
