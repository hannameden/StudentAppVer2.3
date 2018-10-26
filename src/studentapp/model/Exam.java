package studentapp.model;

public class Exam {

	private String examDate;
	private String examRoom;
	private String examLastApplicationDate;
	private String examGrade;
	
	public Exam(String examDate, String examRoom, String examLastApplicationDate, String examGrade) {
		this.examDate = examDate;
		this.examRoom = examRoom;
		this.examLastApplicationDate = examLastApplicationDate;
		this.examGrade = examGrade;
	}

	//Getters n Setters
	public String getExamDate() {
		return examDate;
	}

	public String getExamRoom() {
		return examRoom;
	}

	public String getExamGrade() {
		return examGrade;
	}

	public String getExamLastApplicationDate() {
		return examLastApplicationDate;
	}

	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}

	public void setExamRoom(String examRoom) {
		this.examRoom = examRoom;
	}

	public void setExamLastApplicationDate(String examLastApplicationDate) {
		this.examLastApplicationDate = examLastApplicationDate;
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}
	
}
