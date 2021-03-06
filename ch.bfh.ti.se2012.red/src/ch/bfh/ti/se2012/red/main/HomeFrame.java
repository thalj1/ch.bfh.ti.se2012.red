package ch.bfh.ti.se2012.red.main;

import ch.bfh.ti.se2012.red.Property.Property;
import ch.bfh.ti.se2012.red.appointment.AppointmentLetter;
import ch.bfh.ti.se2012.red.appointment.AppointmentMainWindow;
import ch.bfh.ti.se2012.red.appointment.AppointmentPhone;
import ch.bfh.ti.se2012.red.home.HomeScreen;
import ch.bfh.ti.se2012.red.login.LoginWindow;
import ch.bfh.ti.se2012.red.myDay.MyDay;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeFrame extends CustomComponent {

	private static VerticalLayout mainLayout;
	private HorizontalLayout headerLayout;
	private static AppointmentMainWindow appMain;
	private static LoginWindow login;
	private static HomeScreen home;
	private static Navigation navigation;
	private static AppointmentLetter appLetter;
	private static AppointmentPhone appPhone;
	private static Property appProperty;
	private static MyDay appmyday;

	public HomeFrame() {

		buildVerticalStructure();

		setCompositionRoot(mainLayout);

	}

	private VerticalLayout buildVerticalStructure() {

		mainLayout = new VerticalLayout();

		headerLayout = new HorizontalLayout();
		headerLayout.setWidth("640px");

		mainLayout.addComponent(headerLayout);

		login = new LoginWindow();
		mainLayout.addComponent(login);
		home = new HomeScreen();
		appMain = new AppointmentMainWindow();
		appLetter = new AppointmentLetter();
		appPhone = new AppointmentPhone();
		navigation = new Navigation();
		appProperty = new Property();

		return mainLayout;

	}

	public static void changetoWindow(String oldwindow, String newwindow) {

		if (oldwindow.equals("login") & newwindow.equals("home")) {
			mainLayout.replaceComponent(login, home);
			mainLayout.addComponent(navigation);
		} else if (oldwindow.equals("home") & newwindow.equals("appLetter")) {
			mainLayout.replaceComponent(home, appLetter);
			mainLayout.addComponent(navigation);
		} else if (oldwindow.equals("home") & newwindow.equals("appPhone")) {
			mainLayout.replaceComponent(home, appPhone);
			mainLayout.addComponent(navigation);
		} else if (oldwindow.equals("home") & newwindow.equals("appmyday")) {
			mainLayout.replaceComponent(home, appmyday);
			mainLayout.addComponent(navigation); 
		} else if (oldwindow.equals("home") & newwindow.equals("appProperty")) {
			mainLayout.replaceComponent(home, appProperty);
			mainLayout.addComponent(navigation); 
		} else if (oldwindow.equals("appProperty") & newwindow.equals("appProperty")) {
			mainLayout.replaceComponent(appProperty, appProperty);
			mainLayout.addComponent(navigation); 
		} else if (oldwindow.equals("menu") & newwindow.equals("home")) {
			mainLayout.replaceComponent(mainLayout.getComponent(1), home);
			mainLayout.addComponent(navigation);
		} else if (oldwindow.equals("logout") & newwindow.equals("login")){
			mainLayout.replaceComponent(mainLayout.getComponent(1), login);
			mainLayout.removeComponent(navigation); 
		} else if (oldwindow.equals("back") & newwindow.equals("home")){
			mainLayout.replaceComponent(mainLayout.getComponent(1), home);
			mainLayout.addComponent(navigation);
		}

	}
}
