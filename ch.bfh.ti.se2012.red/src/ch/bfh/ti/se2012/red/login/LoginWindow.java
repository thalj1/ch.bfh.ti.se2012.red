package ch.bfh.ti.se2012.red.login;

import ch.bfh.ti.se2012.red.db.SqlLogin;
import ch.bfh.ti.se2012.red.main.HomeFrame;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

/**
 * Login Screen. You are able to enter a Username and a password. If your
 * combination is correct, you can enter into your application.
 * 
 * @author: Thalmann Jennifer
 * @date: 14.12.2012
 */
// Seite 189
@SuppressWarnings("serial")
public class LoginWindow extends CustomComponent {

	@AutoGenerated
	private AbsoluteLayout mainLayout;

	/**
	 * The constructor should first build the main layout, set the composition
	 * root and then do any custom initialization.
	 * 
	 * The constructor will not be automatically regenerated by the visual
	 * editor. Now it should work.
	 */

	private Panel loginPanel;
	private VerticalLayout vlayout;
	private LoginForm login;
	private Label label; 
	private SqlLogin sqllogin;
	private String username;
	private String password;


	public LoginWindow() {
		buildLoginLayout();
		setCompositionRoot(vlayout);

	}

	public VerticalLayout buildLoginLayout() {
		vlayout = new VerticalLayout();

		loginPanel = new Panel("Login");
		loginPanel.setWidth("250px");

		login = new LoginForm();

		label = new Label("=> Username und/oder Passwort ist falsch!");
		label.setVisible(false);
		
		login.addListener(new LoginForm.LoginListener() {
			public void onLogin(LoginForm.LoginEvent event) {
				 username = event.getLoginParameter("username");
			     password = event.getLoginParameter("password");
			     
     
			     System.out.println(username);
			     System.out.println(password);
				
//				if(username.equals("Hans") & password.equals("1234")){
//					HomeFrame.changetoWindow("login","home");
//				}
//				else{
//					label.setVisible(true);	
//				}
				
			
			     sqllogin = new SqlLogin();
				if(sqllogin.validateLogin(username, password)){
					HomeFrame.changetoWindow("login", "home") ;
					label.setVisible(false);
				}
				else{
					label.setVisible(true);	
				}

							
//				
//				String password = event.getLoginParameter("password");
//				String username = event.getLoginParameter("username");
//
//				
//				SqlLogin login = new SqlLogin();
//				boolean result = login.validateLogin(username, password);
//
//				loginPanel.addComponent(new Button("true"));
//				// if (!result) {
//				// setUser(username);
//				// currentUser.setValue(username);
//
//				// getWindow().showNotification(
//				// "Logged in user: " + username);
//				// getWindow().replaceComponent(loginForm_1,maiPanel);
//				// el.expand(mainPanel);
//				// } else {
//				// getMainWindow().showNotification(
//				// "Wrong password. Hint, try '1234' ",
//				// Notification.TYPE_WARNING_MESSAGE);
//
//				// Button myButton = new Button();
//				// String result2 = " " + result;
//				// myButton.setDescription(result2);
//				// vlayout.addComponent(myButton);
//
//				// }
			}
		});
		
		
		loginPanel.addComponent(login);
		
		
		vlayout.addComponent(loginPanel);
		vlayout.addComponent(label); 

		return vlayout;
	}

	
}
