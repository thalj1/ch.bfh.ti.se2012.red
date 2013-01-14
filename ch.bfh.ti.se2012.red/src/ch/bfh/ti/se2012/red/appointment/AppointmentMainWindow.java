package ch.bfh.ti.se2012.red.appointment;


import ch.bfh.ti.se2012.red.main.HomeFrame;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;


@SuppressWarnings("serial")
public class AppointmentMainWindow extends CustomComponent{
	
	private VerticalLayout appointmentLayout;	
	
	public AppointmentMainWindow() {
		
		buildAppointmentStructure();
		setCompositionRoot(appointmentLayout);
	}
	
	
	private VerticalLayout buildAppointmentStructure()
	{

		appointmentLayout = new VerticalLayout();
		Panel panel = new Panel("Art der Kontaktaufnahme");
		final Button buttonWritten = new Button("Nachricht senden");
		final Button buttonPhone = new Button("Telefonieren");
		
		panel.setWidth("420px");
		panel.addComponent(buttonPhone);
		panel.addComponent(buttonWritten);
		appointmentLayout.addComponent(panel); 
		
//		buttonPhone.addListener(new Button.ClickListener() {
//            	public void buttonClick(ClickEvent event) {
//            		HomeFrame.changetoAppointmentPhone();
//            	}
//		});
//		
//		buttonWritten.addListener(new Button.ClickListener() {
//        	public void buttonClick(ClickEvent event) {
//        		//HomeFrame.changetoAppointmentLetter();
//        		}
//			});
		
		return appointmentLayout;
	}
	
}
