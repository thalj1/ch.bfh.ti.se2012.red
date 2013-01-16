package ch.bfh.ti.se2012.red.appointment;


import com.vaadin.data.util.IndexedContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class AppointmentPhone extends CustomComponent {

	private VerticalLayout appointmentPhoneScreen;
	private VerticalLayout phoneLayout;

	private static String[] fields = {"Name", "Telefonnummer", "Ort", "Typ"};
	private static String[] visibleCols = new String[] {"Name", "Telefonnummer", "Ort", "Typ"};
	
	private Table contactList = new Table();
	private IndexedContainer addressBookData = createData();

	public AppointmentPhone() {
		AddressList();
		buildAppointmentPStructure();
		setCompositionRoot(appointmentPhoneScreen);
	}

	private VerticalLayout buildAppointmentPStructure() {
		
		appointmentPhoneScreen = new VerticalLayout();
		appointmentPhoneScreen.setWidth("420px");
		appointmentPhoneScreen.setHeight("250px");

		phoneLayout = new VerticalLayout();
		phoneLayout.setSpacing(true);
		phoneLayout.setSizeFull();
		
		Panel panel = new Panel("Arzt anrufen");
		panel.setWidth("420px");
		panel.addComponent(phoneLayout);

		phoneLayout.addComponent(contactList);
		
		appointmentPhoneScreen.addComponent(panel);

		return appointmentPhoneScreen;
	}

	private void AddressList() {
		contactList.setContainerDataSource(addressBookData);
		contactList.setVisibleColumns(visibleCols);
		contactList.setSelectable(true);
		contactList.setImmediate(true);
		contactList.setWidth("380px");
		contactList.setHeight("190px");
	}

	private static IndexedContainer createData() {

		String[] names = {"Dr. Allzeit Bereit", "Dr. Kann Alles", "Hilft Immer"};

		String[] phones = {"0719487290", "0719409832", "0787590911"};

		String[] places = {"Biel", "Bern", "Lyss"};

		String[] types = {"psychiatrist", "psychologist", "spitex"};

		IndexedContainer ic = new IndexedContainer();

		for (String p : fields) {
			ic.addContainerProperty(p, String.class, "");
		}

		// Create dummy data by randomly combining first and last names
		for (int i = 0; i < 3; i++) {
			Object id = ic.addItem();
			ic.getContainerProperty(id, "Name").setValue(names[(int) i]);
			ic.getContainerProperty(id, "Telefonnummer").setValue(phones[(int) i]);
			ic.getContainerProperty(id, "Ort").setValue(places[(int) i]);
			ic.getContainerProperty(id, "Typ").setValue(types[(int) i]);
		}
		
		return ic;
	}

}
