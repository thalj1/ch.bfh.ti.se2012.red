package ch.bfh.ti.se2012.red;

import ch.bfh.ti.se2012.red.home.TheButton;
import ch.bfh.ti.se2012.red.login.LoginWindow;
import ch.bfh.ti.se2012.red.main.HomeFrame;
import com.vaadin.Application;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.Resource;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

//?restartApplication

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
		
	
//		main.addComponent(new Button("Click to Home Frame",
//				new Button.ClickListener() {
//					public void buttonClick(ClickEvent event) {
//						// Open the window.
//						//main.open(new ExternalResource(myhome.getURL()), "_new");
//						main.replaceComponent(login, myFrame); 
//				
//					}
//				}));

		}
	

}
