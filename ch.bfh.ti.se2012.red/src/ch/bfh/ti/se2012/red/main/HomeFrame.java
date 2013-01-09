package ch.bfh.ti.se2012.red.main;

import ch.bfh.ti.se2012.red.home.HomeScreen;
import ch.bfh.ti.se2012.red.login.LoginWindow;


import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeFrame extends CustomComponent {

	private static VerticalLayout mainLayout;

	private HorizontalLayout headerLayout;
	
	private static HorizontalLayout buttomLayout;


	private static LoginWindow login;
	private static HomeScreen home; 

	public HomeFrame() {

		buildVerticalStructure();

		setCompositionRoot(mainLayout);

	}

	private VerticalLayout buildVerticalStructure() {

		mainLayout = new VerticalLayout(); 
		
		headerLayout = new HorizontalLayout();
		headerLayout.setWidth("640px");
//		GridLayout labelgridheader = new GridLayout(3, 5);
//		labelgridheader.setWidth("420px");
//		labelgridheader.setHeight("80px");
//		Label label = new Label("Team Red Application");
//		labelgridheader.addComponent(label); 
//		headerLayout.addComponent(labelgridheader);
		
		mainLayout.addComponent(headerLayout);
		
		
		login =  new LoginWindow();
		mainLayout.addComponent(login);
		home = new HomeScreen();
		
		buttomLayout = new HorizontalLayout();
		Panel panel = new Panel("Navigation");
		panel.setWidth("420px");
		GridLayout labelgrid = new GridLayout(3, 5);
		labelgrid.setWidth("400px");
		labelgrid.setHeight("25px");
		labelgrid.addComponent(new Button("Zurück"));
		labelgrid.addComponent(new Button("Menü"));
		labelgrid.addComponent(new Button("Logout"));
		panel.addComponent(labelgrid);
		buttomLayout.addComponent(panel);
		
		return mainLayout;

	}
	
	public static void changetoMenu(){
		mainLayout.replaceComponent(login, home); 
		mainLayout.addComponent(buttomLayout);
	}
}
