package studentapp.model;

public class Project {
	private String projectGrade;
	private String projectDeadline;
	private String projectName;

	public Project(String projectName, String projectDeadline, String projectGrade) {

		this.projectName = projectName;
		this.projectDeadline = projectDeadline;
		this.projectGrade = projectGrade;
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

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}