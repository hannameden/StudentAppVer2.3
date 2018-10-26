package studentapp.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar {
	
	private JMenuBar menuBar;
	private JMenu startMenu, profileMenu, coursesMenu;
	
	private JMenuItem startMenuItem, editProfileMenuItem, switchProfileMenuItem, createProfileMenuItem, removeProfileMenuItem,
	allCoursesMenuItem, currentCoursesMenuItem, completedCoursesMenuItem;
	
	public MenuBar(GUI gui) {
		menuBar = new JMenuBar();
		
		startMenu = new JMenu("Start");
		startMenuItem = new JMenuItem("Start");
		startMenu.add(startMenuItem);

		profileMenu = new JMenu("Profile");
		editProfileMenuItem = new JMenuItem("Edit profile");
		switchProfileMenuItem = new JMenuItem("Switch profile");
		createProfileMenuItem = new JMenuItem("Create new profile");
		removeProfileMenuItem = new JMenuItem("Remove profile");
		profileMenu.add(editProfileMenuItem);
		profileMenu.add(switchProfileMenuItem);
		profileMenu.add(createProfileMenuItem);
		profileMenu.add(removeProfileMenuItem);
		
		coursesMenu = new JMenu("Courses");
		
		allCoursesMenuItem = new JMenuItem("View all courses");
		currentCoursesMenuItem = new JMenuItem("View current courses");
		completedCoursesMenuItem = new JMenuItem("View completed courses");
		
		coursesMenu.add(allCoursesMenuItem);
		coursesMenu.add(currentCoursesMenuItem);
		coursesMenu.add(completedCoursesMenuItem);
		
		menuBar.add(startMenu);
		menuBar.add(profileMenu);
		menuBar.add(coursesMenu);
		
		gui.getFrame().setJMenuBar(menuBar);	
	}
}

