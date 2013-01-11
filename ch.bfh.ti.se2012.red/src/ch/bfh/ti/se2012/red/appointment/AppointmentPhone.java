package ch.bfh.ti.se2012.red.appointment;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class AppointmentPhone extends CustomComponent {
	
	private GridLayout phoneLayout;
	private Label tlName;
	private Label tlNumber;
	private Label tlPlace;
	
	public AppointmentPhone() {
		
		buildAppointmentPStructure();
		setCompositionRoot(phoneLayout);
	}
	
	private GridLayout buildAppointmentPStructure() {
		
		phoneLayout = new GridLayout(4,3);
		
		tlName = new Label("Name");
		tlNumber = new Label("Phonenumber");
		tlPlace = new Label("Place");
		
		phoneLayout.addComponent(tlName);
		phoneLayout.addComponent(tlNumber);
		phoneLayout.addComponent(tlPlace);
		
		Label doctor1 = new Label("Broennimann");
		Label phone1 = new Label("0719487290");
		Label place1 = new Label("Biel");
		
		phoneLayout.addComponent(doctor1);
		phoneLayout.addComponent(phone1);
		phoneLayout.addComponent(place1);
		
		Label doctor2 = new Label("Metzger");
		Label phone2 = new Label("0719409832");
		Label place2 = new Label("Berne");
		
		phoneLayout.addComponent(doctor2);
		phoneLayout.addComponent(phone2);
		phoneLayout.addComponent(place2);
		
		Label doctor3 = new Label("Schuster");
		Label phone3 = new Label("0787590911");
		Label place3 = new Label("Lyss");
		
		phoneLayout.addComponent(doctor3);
		phoneLayout.addComponent(phone3);
		phoneLayout.addComponent(place3);
		
		return phoneLayout;
	}

}
