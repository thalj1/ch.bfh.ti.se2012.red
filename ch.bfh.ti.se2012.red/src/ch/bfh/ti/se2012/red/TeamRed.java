package ch.bfh.ti.se2012.red;

import ch.bfh.ti.se2012.red.login.LoginWindow;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class TeamRed extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("TeamRed");
		mainWindow.getContent().setSizeFull();
		LoginWindow login = new LoginWindow();
		mainWindow.addComponent(login);
		setMainWindow(mainWindow);
	}

}
