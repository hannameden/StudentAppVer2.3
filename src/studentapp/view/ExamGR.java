package studentapp.view;

import javax.swing.JLabel;

public class ExamGR {

	private String examDate;
	private String examRoom;
	private String examLastApplicationDate;
	private String examGrade;
	
	private JLabel labelExamDate, labelExamRoom, labelExamLastApplicationDate, labelExamGrade;
	
	public ExamGR(String examDate, String examRoom, String examLastApplicationDate, String examGrade) {
		
		this.examDate = examDate;
		this.examRoom = examRoom;
		this.examLastApplicationDate = examLastApplicationDate;
		this.examGrade = examGrade;
	}
	
	public void createExamGRLabels(String examDate, String examRoom, String examLastApplicationDate, String examGrade) {
		labelExamDate = new JLabel(examDate);
		labelExamRoom = new JLabel(examRoom);
		labelExamLastApplicationDate = new JLabel(examLastApplicationDate);
		labelExamGrade = new JLabel(examGrade);
	}
	
	public JLabel getLabelExamDate() {
		return labelExamDate;
	}

	public JLabel getLabelExamRoom() {
		return labelExamRoom;
	}

	public JLabel getLabelExamLastApplicationDate() {
		return labelExamLastApplicationDate;
	}
	
	public JLabel getLabelExamGrade() {
		return labelExamGrade;
	}

	public String getExamDate() {
		return examDate;
	}

	public String getExamRoom() {
		return examRoom;
	}

	public String getExamLastApplicationDate() {
		return examLastApplicationDate;
	}

	public String getExamGrade() {
		return examGrade;
	}

	
	
}