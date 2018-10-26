package studentapp.view;

import javax.swing.JLabel;

public class ProjectGR {

	private String projectGrade;
	private String projectDeadline;
	private String projectName;
	private JLabel labelProjectName, labelProjectDeadline, labelProjectGrade;

	public ProjectGR(String projectName, String projectDeadline, String projectGrade) {

		this.projectName = projectName;
		this.projectDeadline = projectDeadline;
		this.projectGrade = projectGrade;
	}
	public void createProjectLabels(String projectName, String projectDeadline, String projectGrade) {
		labelProjectName = new JLabel(projectName);
		labelProjectDeadline = new JLabel(projectDeadline);
		labelProjectGrade = new JLabel(projectGrade);
	}

	public String getProjectGrade() {
		return projectGrade;
	}

	public void setProjectGrade(String projectGrade) {
		this.projectGrade = projectGrade;
	}

	public String getProjectDeadline() {
		return projectDeadline;
	}

	public void setProjectDeadline(String projectDeadline) {
		this.projectDeadline = projectDeadline;
	}

	public String getProjectName() {
		return projectName;
	}

	public JLabel getLabelProjectName() {
		return labelProjectName;
	}
	public JLabel getLabelProjectDeadline() {
		return labelProjectDeadline;
	}
	public JLabel getLabelProjectGrade() {
		return labelProjectGrade;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}

