package ch.bfh.ti.se2012.red.main;

import ch.bfh.ti.se2012.red.login.LoginWindow;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;

import com.vaadin.ui.CustomComponent;

import com.vaadin.ui.HorizontalLayout;

import com.vaadin.ui.Label;

import com.vaadin.ui.Panel;

import com.vaadin.ui.VerticalLayout;

public class HomeFrame extends CustomComponent {

	private VerticalLayout mainLayout;

	private HorizontalLayout headerLayout;

	private Button back;

	private Button homeBT;

	private Label label;

	private Component input;

	public HomeFrame() {

		buildVerticalStructure();

		setCompositionRoot(mainLayout);

	}

	private VerticalLayout buildVerticalStructure() {

		mainLayout = new VerticalLayout();

		headerLayout = new HorizontalLayout();

		headerLayout.setWidth("640px");

		headerLayout.setHeight("10%");

		back = new Button("zurück");

		headerLayout.addComponent(back);

		label = new Label("M.A.P.");

		headerLayout.addComponent(label);

		homeBT = new Button("HOME");

		headerLayout.addComponent(homeBT);

		// inputLayout.setWidth("640px");

		// inputLayout.setHeight("90%");

		input =  new LoginWindow();

		// inputLayout.addComponent(input);

		mainLayout.addComponent(headerLayout);

		mainLayout.addComponent(input);

		return mainLayout;

	}

	class InputComponent extends CustomComponent {

		public InputComponent() {
			
	
//			// A layout structure used for composition
//
//			Panel panel = new Panel();
//
//			panel.setContent(new HorizontalLayout());
//
//			// Compose from multiple components
//
//			Label label = new Label("test");
//
//			label.setSizeUndefined(); // Shrink
//
//			panel.addComponent(label);
//
//			panel.addComponent(new Button("Agenda"));
//
//			panel.addComponent(new Button("Rezepte"));
//
//			panel.addComponent(new Button("MyDay"));
//
//			// Set the size as undefined at all levels
//
//			panel.getContent().setSizeUndefined();
//
//			panel.setSizeUndefined();
//
//			setSizeUndefined();
//
//			// The composition root MUST be set
//
//			setCompositionRoot(panel);

		}

	}

}
