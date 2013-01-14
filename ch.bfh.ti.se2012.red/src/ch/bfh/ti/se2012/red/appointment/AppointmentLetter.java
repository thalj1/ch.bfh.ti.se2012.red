package ch.bfh.ti.se2012.red.appointment;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class AppointmentLetter extends CustomComponent {

	private VerticalLayout appointmentLetterScreen;
	private GridLayout letterLayout;
	private Label doctor;
	private TextField doctorField;
	private Label date;
	private TextField dateField;
	private Label urgency;
	private Label comment;
	private TextField commentField;
	private Button buttonCancel;
	private Button buttonOk;
	private Panel datePanel;
	private PopupDateField datetime;
	private ComboBox urgencyBox;

	public AppointmentLetter() {

		buildAppointmentLStructure();
		setCompositionRoot(appointmentLetterScreen);
	}

	private VerticalLayout buildAppointmentLStructure() {

		appointmentLetterScreen = new VerticalLayout();
		appointmentLetterScreen.setWidth("420px");
		appointmentLetterScreen.setHeight("250px");

		letterLayout = new GridLayout(2, 5);
		letterLayout.setSpacing(true);
		letterLayout.setSizeFull();

		Panel panel = new Panel("Written Request");
		panel.setWidth("420px");
		panel.addComponent(letterLayout);

		// Zeile 1
		doctor = new Label("Attending Doctor:");
		doctorField = new TextField();
		letterLayout.addComponent(doctor);
		letterLayout.addComponent(doctorField);

		// Zeile 2
		date = new Label("Requested Date:");
		datePanel = new Panel();
		datetime = new PopupDateField();
		datePanel.addComponent(datetime);
		letterLayout.addComponent(date);
		letterLayout.addComponent(datetime);

		// Zeile 3
		urgency = new Label("Urgency:");
		// urgencyField = new TextField();
		urgencyBox = new ComboBox();
		urgencyBox.addItem("very urgent");
		urgencyBox.addItem("urgent");
		urgencyBox.addItem("not indicated");

		// urgencyBox.setFilteringMode(Filtering.FILTERINGMODE_OFF);
		// urgencyBox.setImmediate(true);
		// urgencyBox.addListener(this);

		letterLayout.addComponent(urgency);
		letterLayout.addComponent(urgencyBox);

		// Zeile 4
		comment = new Label("Any further Comments:");
		commentField = new TextField();
		letterLayout.addComponent(comment);
		letterLayout.addComponent(commentField);

		// Zeile 5
		buttonCancel = new Button("Cancel");
		buttonOk = new Button("OK");
		letterLayout.addComponent(buttonCancel);
		letterLayout.addComponent(buttonOk);

		// buttonCancel.addListener(new Button.ClickListener() {
		// public void buttonClick(ClickEvent event) {
		// buttonCancel.setCaption("You pushed it!");
		// }
		// });

		// buttonok.addListener(new Button.ClickListener() {
		// public void buttonClick(ClickEvent event) {
		// buttonOk.setCaption("You pushed it!");
		// }
		// });

		appointmentLetterScreen.addComponent(panel);

		return appointmentLetterScreen;
	}

}
