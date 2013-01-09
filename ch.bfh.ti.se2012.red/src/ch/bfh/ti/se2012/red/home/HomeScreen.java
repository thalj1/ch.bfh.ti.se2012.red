package ch.bfh.ti.se2012.red.home;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class HomeScreen extends CustomComponent {

	private VerticalLayout homeScreen;
	private GridLayout labelgrid;

	public HomeScreen() {

		buildVerticalStructure();

		setCompositionRoot(homeScreen);

	}

	private VerticalLayout buildVerticalStructure() {

		homeScreen = new VerticalLayout();

		labelgrid = new GridLayout(3, 5);
		labelgrid.setWidth("400px");
		labelgrid.setHeight("160px");

		Panel panel = new Panel("Menü");
		panel.setWidth("420px");
		panel.addComponent(labelgrid);

		final Button button1 = new Button("Agenda");
		labelgrid.addComponent(button1);
		labelgrid.addComponent(new Button("Medikamente"));
		labelgrid.addComponent(new Button("My Day"));
		labelgrid.addComponent(new Button("Adressbuch"));
		labelgrid.addComponent(new Button("Rezepte"));
		labelgrid.addComponent(new Button("Einstellungen"));
		labelgrid.addComponent(new Button("Termin"), 1, 4);
		
		homeScreen.addComponent(panel); 

		button1.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				button1.setCaption("test2");

			}
		}

		);

		return homeScreen;
	}

}
