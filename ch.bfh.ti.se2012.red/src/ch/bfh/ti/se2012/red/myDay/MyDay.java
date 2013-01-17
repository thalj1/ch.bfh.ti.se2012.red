package ch.bfh.ti.se2012.red.myDay;

import java.util.Date;

import org.vaadin.vaadinvisualizations.LineChart;

import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class MyDay extends CustomComponent {

	private VerticalLayout myDayScreen;
	private GridLayout myDayLayout;
	private HorizontalLayout entryLayout;
	private Label entry;
	private ComboBox state;
	private Button buttonOk;
	private PopupDateField date;
	private String stateValue;
	private String dateValue;

	LineChart lc;

	public MyDay() {
		buildMyDayStructure();
		setCompositionRoot(myDayScreen);
	}

	public VerticalLayout buildMyDayStructure() {

		myDayScreen = new VerticalLayout();
		myDayScreen.setWidth("420px");
		myDayScreen.setHeight("250px");

		myDayLayout = new GridLayout(1, 2);
		myDayLayout.setSpacing(true);
		myDayLayout.setSizeFull();
		
		entryLayout = new HorizontalLayout();
		
		Panel panel = new Panel("My Day");
		panel.setWidth("420px");
		panel.setHeight("250px");
		panel.addComponent(myDayLayout);
		
		lc = new LineChart();

		lc.setOption("legend", "none");
		lc.setOption("height", "140");
		
		lc.addXAxisLabel("date");
		lc.addLine("state");
		lc.add("06.01", new double[]{5});
		lc.add("07.01", new double[]{5});
		lc.add("08.01", new double[]{4});
		lc.add("09.01", new double[]{5});
		lc.add("10.01", new double[]{3});
		lc.add("11.01", new double[]{1});
		lc.add("12.01", new double[]{2});
		lc.add("13.01", new double[]{5});
		
		lc.setWidth("420px");
		lc.setHeight("140px");
				
		entry = new Label("Neuer Eintrag:");
		state = new ComboBox();
		state.addItem(" ");
		state.addItem("1");
		state.addItem("2");
		state.addItem("3");
		state.addItem("4");
		state.addItem("5");
		state.setWidth("50px");
		
		state.addListener(new Property.ValueChangeListener() {
            private static final long serialVersionUID = 2067455464466500520L;

            public void valueChange(ValueChangeEvent event) {
                stateValue = event.getProperty().getValue().toString();
            }
        });
		
		
		buttonOk = new Button("speichern");
		buttonOk.addListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				System.out.println(stateValue + dateValue);
			}
		});
		
		date = new PopupDateField();
		date.setValue(new Date());
		date.setDateFormat("yyyy-MM-dd");
		date.setWidth("100px");
		date.setImmediate(true);
		date.addListener(new Property.ValueChangeListener() {
            private static final long serialVersionUID = 2067455464466500520L;

            public void valueChange(ValueChangeEvent event) {
                dateValue = event.getProperty().getValue().toString();
            }
        });

		
		entryLayout.addComponent(entry);
		entryLayout.addComponent(state);
		entryLayout.addComponent(date);
		entryLayout.addComponent(buttonOk);

		myDayLayout.addComponent(lc, 0, 0);
		myDayLayout.addComponent(entryLayout, 0, 1);
		
		myDayScreen.addComponent(panel);

		return myDayScreen;
	}

}
