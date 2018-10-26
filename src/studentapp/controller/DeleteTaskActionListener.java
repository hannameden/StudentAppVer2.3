package studentapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTaskActionListener implements ActionListener {

	private Manager manager;
	
	public DeleteTaskActionListener(Manager manager) {
		this.manager = manager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String courseCode = e.getActionCommand();

		manager.deleteTask(courseCode);
	}

}
