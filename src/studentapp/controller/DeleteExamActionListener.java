package studentapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteExamActionListener implements ActionListener {

	private Manager manager;
	
	public DeleteExamActionListener(Manager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String courseCode = e.getActionCommand();

		manager.examAlreadyExists = false;
		manager.deleteExam(courseCode);
	}

}
