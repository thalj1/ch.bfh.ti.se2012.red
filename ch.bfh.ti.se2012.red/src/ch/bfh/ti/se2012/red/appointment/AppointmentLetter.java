package ch.bfh.ti.se2012.red.appointment;


import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.TextField;


@SuppressWarnings("serial")
public class AppointmentLetter extends CustomComponent {
	
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
		setCompositionRoot(letterLayout);
	}

	
	private GridLayout buildAppointmentLStructure() {
		
		letterLayout = new GridLayout(5,2);
		
		doctor = new Label("Attending Doctor:");
		doctorField = new TextField();
		letterLayout.addComponent(doctor);
		letterLayout.addComponent(doctorField);
		
		date = new Label("Requested Date:");
		datePanel = new Panel();
		datePanel.addComponent(datetime);
		letterLayout.addComponent(date);
		letterLayout.addComponent(dateField);
		
		urgency = new Label("Urgency:");
//		urgencyField = new TextField();
		urgencyBox = new ComboBox();
		urgencyBox.addItem("very urgent");
		urgencyBox.addItem("urgent");
		urgencyBox.addItem("not indicated");
		
//		urgencyBox.setFilteringMode(Filtering.FILTERINGMODE_OFF);
//      urgencyBox.setImmediate(true);
//      urgencyBox.addListener(this);
		
		letterLayout.addComponent(urgency);
		letterLayout.addComponent(urgencyBox);
		
		comment = new Label("Any further Comments:");
		commentField = new TextField();
		letterLayout.addComponent(comment);
		letterLayout.addComponent(commentField);
		
		buttonCancel = new Button("Cancel");
		buttonOk = new Button("OK");
		letterLayout.addComponent(buttonCancel);
		letterLayout.addComponent(buttonOk);
		
//		buttonCancel.addListener(new Button.ClickListener() {
//    	public void buttonClick(ClickEvent event) {
//    		buttonCancel.setCaption("You pushed it!");
//    		}
//		});
		
//		buttonok.addListener(new Button.ClickListener() {
//    	public void buttonClick(ClickEvent event) {
//    		buttonOk.setCaption("You pushed it!");
//    		}
//		});
		
		return letterLayout;
	}
	

	
}
