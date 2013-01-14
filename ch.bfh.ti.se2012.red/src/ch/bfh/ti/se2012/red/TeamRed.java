package ch.bfh.ti.se2012.red;

import ch.bfh.ti.se2012.red.main.HomeFrame;
import com.vaadin.Application;
import com.vaadin.ui.*;

public class TeamRed extends Application {
	
	private  Window main;
	private  HomeFrame home; 
	private Window myhome;
	private HomeFrame myFrame;  

	@Override
	public void init() {
		// The main window.
		Window main = new Window("TeamRed");
		setMainWindow(main);

		//Crate HomeFrame 
		home = new HomeFrame();
//		//Add Home Frame to Main Window 
		main.addComponent(home); 

		}
	

}
