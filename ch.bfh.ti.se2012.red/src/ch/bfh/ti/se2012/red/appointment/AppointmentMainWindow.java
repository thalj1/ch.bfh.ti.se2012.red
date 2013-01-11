package ch.bfh.ti.se2012.red.appointment;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;


public class AppointmentMainWindow extends CustomComponent{
	
	private VerticalLayout appointmentLayout;
	private Button buttonPhone;
	private Button buttonWritten;
	
	
	public AppointmentMainWindow() {
		
		buildAppointmentStructure();
		setCompositionRoot(appointmentLayout);
	}
	
	
	private VerticalLayout buildAppointmentStructure()
	{
		
		appointmentLayout = new VerticalLayout();
		buttonPhone = new Button("Phone Request");
		appointmentLayout.addComponent(buttonPhone);
		
//		buttonPhone.addListener(new Button.ClickListener() {
//            	public void buttonClick(ClickEvent event) {
//            		buttonPhone.setCaption("You pushed it!");
//            		}
//				});
		
		buttonWritten = new Button("Written Request");
		appointmentLayout.addComponent(buttonWritten);
		
//		buttonWritten.addListener(new Button.ClickListener() {
//        	public void buttonClick(ClickEvent event) {
//        		buttonWritten.setCaption("You pushed it!");
//        		}
//			});
		
		return appointmentLayout;
	}
	
}
