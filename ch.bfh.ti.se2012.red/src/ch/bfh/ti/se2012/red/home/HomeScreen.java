package ch.bfh.ti.se2012.red.home;

import ch.bfh.ti.se2012.red.TeamRed;
import ch.bfh.ti.se2012.red.login.LoginWindow;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class HomeScreen extends CustomComponent {

	private GridLayout labelgrid;

	public HomeScreen() {

		buildVerticalStructure();

		setCompositionRoot(labelgrid);

	}

	@SuppressWarnings("serial")
	private GridLayout buildVerticalStructure() {

		labelgrid = new GridLayout(3, 5);
		labelgrid.setWidth("400px");
		labelgrid.setHeight("160px");

		final Button button1 = new Button("Agenda");
		labelgrid.addComponent(button1);
		labelgrid.addComponent(new Button("Medikamente"));
		labelgrid.addComponent(new Button("My Day"));
		labelgrid.addComponent(new Button("Adressbuch"));
		labelgrid.addComponent(new Button("Rezepte"));
		labelgrid.addComponent(new Button("Einstellungen"));
		labelgrid.addComponent(new Button("Termin"), 1, 4);

		button1.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				LoginWindow login = new LoginWindow();
				TeamRed team = new TeamRed(); 
				team.setScreen(login); 
				//button1.setCaption("You pushed it!");
			}
		});

		return labelgrid;
	}

}
