package ch.bfh.ti.se2012.red.home;

import ch.bfh.ti.se2012.red.main.HomeFrame;

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
	private GridLayout labelgrid2;

	public HomeScreen() {

		buildVerticalStructure();

		setCompositionRoot(homeScreen);

	}

	private VerticalLayout buildVerticalStructure() {

		homeScreen = new VerticalLayout();
		
		labelgrid2 = new GridLayout(2, 1);
		labelgrid2.setWidth("400px");
		labelgrid2.setHeight("25px");
		
		Panel panelhelp = new Panel("Hilfe anfordern");
		panelhelp.setWidth("420px");
		final Button button7 = new Button("Arzt anrufen");
		labelgrid2.addComponent(button7);
		final Button button8 = new Button("Nachricht an Arzt senden");
		labelgrid2.addComponent(button8);
		panelhelp.addComponent(labelgrid2); 

		labelgrid = new GridLayout(3, 3);
		labelgrid.setWidth("400px");
		labelgrid.setHeight("80px");

		Panel panelmenu = new Panel("Menü");
		panelmenu.setWidth("420px");
		panelmenu.addComponent(labelgrid);

		final Button button1 = new Button("Agenda");
		labelgrid.addComponent(button1);
		final Button button2 = new Button("Medikamente");
		labelgrid.addComponent(button2);
		final Button button3 = new Button("My Day");
		labelgrid.addComponent(button3);
		final Button button4 = new Button("Adressbuch");
		labelgrid.addComponent(button4);
		final Button button5 = new Button("Rezepte");
		labelgrid.addComponent(button5);
		final Button button6 = new Button("Einstellungen");
		labelgrid.addComponent(button6);
		
		
		homeScreen.addComponent(panelhelp); 
		homeScreen.addComponent(panelmenu); 

		button7.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HomeFrame.changetoWindow("home", "appPhone");

			}
		});
		
		button8.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HomeFrame.changetoWindow("home", "appLetter"); 

			}
		}

		);

		return homeScreen;
	}

}
