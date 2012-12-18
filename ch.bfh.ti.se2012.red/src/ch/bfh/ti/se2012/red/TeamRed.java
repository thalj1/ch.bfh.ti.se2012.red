package ch.bfh.ti.se2012.red;

import com.vaadin.Application;
import com.vaadin.ui.*;

public class TeamRed extends Application {
	@Override
	public void init() {
		Window mainWindow = new Window("TeamRed");
		Label label = new Label("Hello Vaadin user");
		mainWindow.addComponent(label);
		setMainWindow(mainWindow);
	}

}
