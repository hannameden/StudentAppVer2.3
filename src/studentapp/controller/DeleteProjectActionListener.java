package studentapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProjectActionListener implements ActionListener{

	private Manager manager;
	
	public DeleteProjectActionListener(Manager manager) {
		this.manager = manager;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String courseCode = e.getActionCommand();
	
		manager.projectAlreadyExists = false;
		manager.deleteProject(courseCode);
		
	}

}
