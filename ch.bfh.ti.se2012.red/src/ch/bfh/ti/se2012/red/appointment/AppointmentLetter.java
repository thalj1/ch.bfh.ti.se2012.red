package ch.bfh.ti.se2012.red.appointment;



import java.util.Date;

import ch.bfh.ti.se2012.red.db.SqlLogin;

import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;


public class AppointmentLetter extends CustomComponent {
	
	private VerticalLayout appointmentLetterScreen;
	private GridLayout letterLayout;
	private Label doctor;
	private TextField doctorField;
	private Label date;
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
		
		final Termine termine = new Termine(); 
		
		appointmentLetterScreen = new VerticalLayout();
		appointmentLetterScreen.setWidth("420px");
		appointmentLetterScreen.setHeight("250px");
		
		letterLayout = new GridLayout(2, 5);
		letterLayout.setSpacing(true);
		letterLayout.setSizeFull();
		
		Panel panel = new Panel("Nachricht an Arzt senden");
		panel.setWidth("420px");
		panel.addComponent(letterLayout);
		
		//Zeile 1
		doctor = new Label("Arzt:");
		doctorField = new TextField();
		letterLayout.addComponent(doctor);
		letterLayout.addComponent(doctorField);
		
		//Zeile 2
		date = new Label("GewŁnschtes Datum:");
		datePanel = new Panel();
		datetime = new PopupDateField();
		datetime.setValue(new Date());
		datetime.setDateFormat("yyyy-MM-dd");
		datetime.setWidth("100px");
		datePanel.addComponent(datetime);
		letterLayout.addComponent(date);
		letterLayout.addComponent(datetime);
		
		//Zeile 3
		urgency = new Label("Dringlichkeit:");
		urgencyBox = new ComboBox();
		urgencyBox.addItem("sehr dringend");
		urgencyBox.addItem("dringend");
		urgencyBox.addItem("nicht angegeben");
		
		letterLayout.addComponent(urgency);
		letterLayout.addComponent(urgencyBox);
		
		//Zeile 4
		comment = new Label("Kommentar:");
		commentField = new TextField();
		letterLayout.addComponent(comment);
		letterLayout.addComponent(commentField);
		
		//Zeile 5
		buttonCancel = new Button("Abbruch");
		buttonOk = new Button("OK");
		letterLayout.addComponent(buttonCancel);
		letterLayout.addComponent(buttonOk);
		
		buttonCancel.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				doctorField.setValue(""); 
				commentField.setValue("");
			}
				
		});
		
		buttonOk.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				if ((doctorField.getValue().toString().equals("") & urgencyBox.getValue().toString().equals("") & commentField.getValue().toString().equals(""))){
					System.out.println("Error");
					
				}
				else{
					Termin termin = new Termin(doctorField.getValue().toString(),datetime.getValue().toString(), urgencyBox.getValue().toString(),commentField.getValue().toString() ); 
					termine.addTermin(termin); 
				}
			}
				
		});
		
		appointmentLetterScreen.addComponent(panel);
		
		return appointmentLetterScreen;
	}
	

	
}
