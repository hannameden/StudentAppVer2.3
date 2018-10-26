package studentapp;

import studentapp.controller.Manager;
import studentapp.model.Model;
import studentapp.view.GUI;

public class Launcher {

	public static void main(String[] args) {

		GUI gui = new GUI();
		
		Model model = new Model();
		
		new Manager(gui, model);
		
	}

}