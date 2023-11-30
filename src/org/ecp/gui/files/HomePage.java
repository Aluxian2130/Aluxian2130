package org.ecp.gui.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ecp.people.Customer;
import org.ecp.people.User;
import org.ecp.system.Admin;

public class HomePage extends JFrame implements ActionListener {
	JButton login_out;
	JButton exitApp;
	JButton signup;
	
	private User person;
	private ArrayList<User> personlist;
	private ArrayList<Customer> customerList; 
	
	public HomePage(String windowTitle) {
		super(windowTitle);
		
		customerList = new ArrayList<Customer>();
		
		this.setTitle("E-Commerce Platform");
		this.setLayout(new FlowLayout());
		this.getContentPane().setBackground(new Color( 11, 83, 69 ));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setResizable(false);//so as to make it not resizeable (can remove it later)
		this.setVisible(true);
		
		Box titleText = Box.createHorizontalBox();
		JLabel title = new JLabel("<html><span style='color: white;'>ECommerce Platform</span></html>");
		title.setFont (title.getFont().deriveFont(25.0f));
		//JLabel slogan = new JLabel("<html>Full Potential<br>Minimal Knowledge</html>");
		titleText.add(title);
		//titleText.add(slogan);
		titleText.setAlignmentX(this.getWidth() / 2);
		this.add(title);
		buildGUI();
		
	}
	public void buildGUI() {
		//create input boxes for user info on same screen
		JTextField username = new JTextField(15);
	    JTextField password = new JTextField(15);
	    this.add(new JLabel("Username: "));
	    this.add(username);
	    this.add(new JLabel("Password: "));
	    this.add(password);
	    String name = username.getText();
        String pass = password.getText(); 
	    
		login_out = new JButton();
		login_out.setText("Login/Logout");
		login_out.setBounds(50,150,130,50);
		login_out.setFocusable(false);
		login_out.addActionListener(this);
		//login_out.addActionListener(new MenuListener());
		login_out.setLayout(new BorderLayout());
		this.add(login_out);
		JPanel x1 = new JPanel();
		
		
		signup = new JButton();
		signup.setText("Sign up");
		signup.setBounds(190,150,130,50);
		signup.setFocusable(false);
		signup.addActionListener(this);
		signup.addActionListener(new MenuListener());
		signup.setLayout(new BorderLayout());
		this.add(signup);
		JPanel x2 = new JPanel();
		
		exitApp = new JButton();
		exitApp.setText("Exit");
		exitApp.setBounds(400,440,80,20);
		exitApp.setFocusable(false);
		exitApp.addActionListener(this);
		exitApp.setLayout(new BorderLayout());
		this.add(exitApp);
		JPanel x3 = new JPanel();
		
	}
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			//JMenuItem source = (JMenuItem)(e.getSource());
			if(e.getSource() == login_out) { handleLogin_out(); }
			else if(e.getSource() == signup) { handleSignup(); }
			else if(e.getSource() == exitApp) { handleExit(); } 
			//if(source.equals(login_out)) { handleLogin_out(); }
				/*System.out.println("Log in button pressed");
				//log_in_out_b.setVisible(false);
				//log_in_out_b.setEnabled(false);
			}*/
			//else if(source.equals(signup)) { handleSignup(); }
			
			
		}
		private void handleExit() {
			 System.exit(0);
		}
		private void handleLogin_out() {
			
		}
		private void handleSignup() {
			Customer x = new Customer();

			String email = JOptionPane.showInputDialog(null, "Enter Email");
			//System.out.println(email);
			
			String username = JOptionPane.showInputDialog(null, "Enter username");
			//System.out.println(username);
			
			String password = JOptionPane.showInputDialog(null, "Enter password");
			//System.out.println(password);
			if(email != null && username != null && password != null) {
				x.setEmail(email);
				x.setUsername(username);
				x.setPassword(password);
				customerList.add(x);
			}
		}
		

	/*public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login_out) {
			System.out.println("Log in button pressed");
			//log_in_out_b.setVisible(false);
			//log_in_out_b.setEnabled(false);
		}
		else if(e.getSource() == signup) {
			
			//testing if it's customer
			Customer x = new Customer();
			
			System.out.println("Sign up button pressed");
			String email = JOptionPane.showInputDialog(null, "Enter Email");
			//System.out.println(email);
			
			String username = JOptionPane.showInputDialog(null, "Enter username");
			//System.out.println(username);
			
			String password = JOptionPane.showInputDialog(null, "Enter password");
			//System.out.println(password);
			if(email != null && username != null && password != null) {
				x.setEmail(email);
				x.setUsername(username);
				x.setPassword(password);
				customerList.add(x);
			}
		}
		System.out.println("Customers present in system");
		for(Customer y: customerList) {
			System.out.println(y.getUsername());
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//JMenuItem source = (JMenuItem)(e.getSource());
		if(e.getSource() == login_out) { handleLogin_out(); }
		else if(e.getSource() == signup) { handleSignup(); }
		else if(e.getSource() == exitApp) { handleExit(); } 
		//if(source.equals(login_out)) { handleLogin_out(); }
			/*System.out.println("Log in button pressed");
			//log_in_out_b.setVisible(false);
			//log_in_out_b.setEnabled(false);
		}*/
		//else if(source.equals(signup)) { handleSignup(); }
		
		
		}
		private void handleExit() {
			System.exit(0);
		}
		private void handleLogin_out() {
		
		}
		private void handleSignup() {
			JPanel window = new JPanel();
		    JFrame frame = new JFrame();
		    window.setLayout(new GridLayout(0, 2, 2, 2));
		    JTextField email = new JTextField(15);
		    JTextField username = new JTextField(15);
		    JTextField password = new JTextField(15);
			
	        window.add(new JLabel("Email: "));
	        window.add(email);
	        window.add(new JLabel("Username "));
	        window.add(username);
	        window.add(new JLabel("password "));
	        window.add(password);
	        
	        int option = JOptionPane.showConfirmDialog(frame, window, "Please fill all the fields", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

	        if (option == JOptionPane.YES_OPTION) {
	        	String userEmail = email.getText();
	        	String userUsername = username.getText(); 
	        	String userPassword = password.getText(); 
	        	
	        	if((userEmail != null)|(userUsername != null)|(userPassword != null)) {
					if((userEmail.trim().equals(""))|(userUsername.trim().equals(""))|(userPassword.trim().equals(""))){
						JOptionPane.showMessageDialog(null, "Please enter all fields", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else if (!userEmail.contains("@") || (!userEmail.contains("."))) {
						JOptionPane.showMessageDialog(null, "Invalid Email", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else if (userPassword.contains(" ")) {
						JOptionPane.showMessageDialog(null, "Password cannot contain spaces", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else if (userPassword.length() <= 5) {
						JOptionPane.showMessageDialog(null, "Password cannot be shorter than 6 characters", "Error", JOptionPane.PLAIN_MESSAGE);
					}
					else{
						Customer x = new Customer();
						for (User u : Admin.getUserList()){
							if(u.getUsername().equals(userUsername)) {
								JOptionPane.showMessageDialog(null, "User " + userUsername + "already exists in the system.", "Error Creating User", JOptionPane.ERROR);
							}
							if(u.getEmail().equals(userEmail)) {
								JOptionPane.showMessageDialog(null, "Email " + userEmail + "already exists in the system.", "Error Creating User", JOptionPane.ERROR);
							}
							else {
								/*for (CampusCourse cc : d.getCampusCourseList()) {
									if (cc.getCourseNumber().equals(Integer.parseInt(courseNum))) {
										d.addCourse(cc);
										JOptionPane.showMessageDialog(null, 
												"You have assigned "+ d.getDepartmentName() + cc.getCourseNumber(), "Success",
												JOptionPane.PLAIN_MESSAGE);
									}
								}*/
								if(userEmail != null && userUsername != null && userPassword != null) {
									x.setEmail(userEmail);
									x.setUsername(userUsername);
									x.setPassword(userPassword);
									customerList.add(x);
								}		
							}
								
							
						}
		
					}
				}
			}
	        	
	        
			
		}
	
	
}
