package studentapp.view;

import javax.swing.JLabel;

public class TaskGR {

	private String taskGrade;
	private String taskName;
	private String taskDeadline;
	
	private JLabel labelTaskName, labelTaskDeadline, labelTaskGrade;
	
	public TaskGR(String taskName, String taskDeadline, String taskGrade) {
		this.taskName = taskName;
		this.taskDeadline = taskDeadline;
		this.taskGrade = taskGrade;
	}
	
	public void createTaskGRLabels(String taskName, String taskDeadline, String taskGrade) {
		labelTaskName = new JLabel(taskName);
		labelTaskDeadline = new JLabel(taskDeadline);
		labelTaskGrade = new JLabel(taskGrade);
	}

	public JLabel getLabelTaskName() {
		return labelTaskName;
	}

	public JLabel getLabelTaskDeadline() {
		return labelTaskDeadline;
	}

	public JLabel getLabelTaskGrade() {
		return labelTaskGrade;
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