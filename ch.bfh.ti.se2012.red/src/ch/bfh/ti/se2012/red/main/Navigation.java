package ch.bfh.ti.se2012.red.main;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;


@SuppressWarnings("serial")
public class Navigation extends CustomComponent {


	private HorizontalLayout navigationLayout;


	public Navigation() {

		buildVerticalStructure();

		setCompositionRoot(navigationLayout);

	}

	private HorizontalLayout buildVerticalStructure() {

		navigationLayout = new HorizontalLayout();


		Panel panel = new Panel("Navigation");
		panel.setWidth("420px");
		GridLayout labelgrid = new GridLayout(3, 5);
		labelgrid.setWidth("400px");
		labelgrid.setHeight("25px");
		final Button button1 = new Button("Zurück");
		labelgrid.addComponent(button1);
		final Button button2 = new Button("Menü");
		labelgrid.addComponent(button2);
		final Button button3 = new Button("Logout");
		labelgrid.addComponent(button3);
		panel.addComponent(labelgrid);
		navigationLayout.addComponent(panel);

		button1.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HomeFrame.changetoWindow("back", "home");
				}
		});
		
		button2.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HomeFrame.changetoWindow("menu", "home");
			}
		});
		
		button3.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				HomeFrame.changetoWindow("logout", "login");
			}
		});

		return navigationLayout;

	}


}

