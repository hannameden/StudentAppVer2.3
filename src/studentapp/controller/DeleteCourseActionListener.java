package studentapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteCourseActionListener implements ActionListener {

	private Manager manager;

	public DeleteCourseActionListener(Manager manager) {
		this.manager = manager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();

		manager.deleteCourse(action);
		
	}


}
