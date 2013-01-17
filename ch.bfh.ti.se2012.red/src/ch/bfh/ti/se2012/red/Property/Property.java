package ch.bfh.ti.se2012.red.Property;

import ch.bfh.ti.se2012.red.db.SqlLogin;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class Property extends CustomComponent {

	private VerticalLayout PropertyScreen;
	private GridLayout PropertyLayout;
	private Label UsernameLabel;
	private TextField UsernameField;
	private Label PwOldLabel;
	private TextField PwOldField;
	private Label PwNewLabel;
	private TextField PwNewField;
	private Label PwNewLabel2;
	private TextField PwNewField2;
	private Button buttonCancel;
	private Button buttonOk;
	private Label labelok;
	private Label labellogin;
	private Label labelpw;

	public Property() {

		buildPropertyStructure();
		setCompositionRoot(PropertyScreen);
	}

	private VerticalLayout buildPropertyStructure() {

		PropertyScreen = new VerticalLayout();
		PropertyScreen.setWidth("420px");
		PropertyScreen.setHeight("300px");

		labelok = new Label("Das Passwort wurde geändert");
		labelok.setVisible(false);
		labellogin = new Label(
				"Alter Benutzername/Passwort ist falsch");
		labellogin.setVisible(false);
		labelpw = new Label(
				"Passworteingaben sind nicht gleich");
		labelpw.setVisible(false);

		PropertyLayout = new GridLayout(2, 8);
		PropertyLayout.setSpacing(true);
		PropertyLayout.setSizeFull();

		Panel panel = new Panel("Einstellungen");
		panel.setWidth("420px");
		panel.addComponent(PropertyLayout);

		// Zeile 1
		UsernameLabel = new Label("Benutzername: ");
		UsernameField = new TextField();
		PropertyLayout.addComponent(UsernameLabel);
		PropertyLayout.addComponent(UsernameField);

		// Zeile 2
		PwOldLabel = new Label("Altes Passwort: ");
		PwOldField = new TextField();
		PropertyLayout.addComponent(PwOldLabel);
		PropertyLayout.addComponent(PwOldField);

		PwNewLabel = new Label("Neues Passwort: ");
		PwNewField = new TextField();
		PropertyLayout.addComponent(PwNewLabel);
		PropertyLayout.addComponent(PwNewField);

		PwNewLabel2 = new Label("Wiederholen Sie Ihr neues Passwort: ");
		PwNewField2 = new TextField();
		PropertyLayout.addComponent(PwNewLabel2);
		PropertyLayout.addComponent(PwNewField2);

		buttonCancel = new Button("Cancel");
		buttonOk = new Button("OK");
		PropertyLayout.addComponent(buttonCancel);
		PropertyLayout.addComponent(buttonOk);

		buttonCancel.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				labellogin.setVisible(false);
				labelpw.setVisible(false);
				labelok.setVisible(false);
				UsernameField.setValue(""); 
				PwOldField.setValue(""); 
				PwNewField.setValue(""); 
				PwNewField2.setValue(""); 
			}
		});

		buttonOk.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				labellogin.setVisible(false);
				labelpw.setVisible(false);
				labelok.setVisible(false);
				SqlLogin sqllogin = new SqlLogin();
				if (sqllogin.validateLogin(UsernameField.getValue().toString(),
						PwOldField.getValue().toString())) {
					if (PwNewField.getValue().toString()
							.equals(PwNewField2.getValue().toString())) {
						sqllogin.setpassword(UsernameField.getValue()
								.toString(), PwNewField.getValue().toString());
						labelok.setVisible(true);
					} else {
						labelpw.setVisible(true);
					}
				} else {
					labellogin.setVisible(true);
				}
			}
		});

		PropertyLayout.addComponent(labelok, 1, 5);
		PropertyLayout.addComponent(labellogin, 1, 6);
		PropertyLayout.addComponent(labelpw, 1, 7);
		PropertyScreen.addComponent(panel);

		return PropertyScreen;
	}

}
