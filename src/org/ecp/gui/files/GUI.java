package org.ecp.gui.files;


import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.people.Seller;
import org.ecp.people.User;
import org.ecp.system.Admin;

public class GUI extends JFrame implements ActionListener{
	private ArrayList<User> userlist = new ArrayList<>();
	private Customer customer_X = new Customer();
	private Driver driver_X = new Driver();
	private Seller seller_X = new Seller();
	String username, password, accountType, email;
	Integer valid = 0;
	char letter;
	
    JFrame frame = new JFrame();
    JButton login = new JButton("Login");
    JButton signup = new JButton("Sign up");
    JButton quit = new JButton("Quit");
    JTextField userField = new JTextField();
    JPasswordField passField = new JPasswordField();
    JTextField emailField = new JTextField();
    JTextField typeField = new JTextField();
    JLabel userLabel = new JLabel("Username: ");
    JLabel passLabel = new JLabel("Password: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel typeLabel = new JLabel("Account Type:");
    JLabel messageLabel = new JLabel("");
    JLabel TitleLabel = new JLabel("E-Commerce Platform");
    JLabel textLabel = new JLabel("Welcome to ECP, where shopping is made easy!");
    JLabel instr1Label = new JLabel("Sign in to continue where you left off ... ");
    JLabel instr2Label = new JLabel("OR make a free account with us today!");
    JLabel bottomBorder = new JLabel("-+*%$%*+-+*%$%*+-+*%$-+*%$%*+-+*%$%*+-+*%$-+*%$%*+-+*%$%*+-");
    //JLabel bottomBorder = new JLabel(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.");
    
    
	public GUI(String windowTitle) {
		super(windowTitle); //need "extends JFrame"
		
		userLabel.setBounds(70,150,90,25); //x, y, length, height
		userLabel.setFont(new Font("serif", Font.BOLD, 12));
		userLabel.setForeground(new java.awt.Color(244,246,246));
		passLabel.setBounds(70,200,90,25);
		passLabel.setFont(new Font("serif", Font.BOLD, 12));
		passLabel.setForeground(new java.awt.Color(244,246,246));
		emailLabel.setBounds(70,100,90,25);
		emailLabel.setFont(new Font("serif", Font.BOLD, 12));
		emailLabel.setForeground(new java.awt.Color(244,246,246));
		typeLabel.setBounds(70,250,90,25);
		typeLabel.setFont(new Font("serif", Font.BOLD, 12));
		typeLabel.setForeground(new java.awt.Color(244,246,246));
		userField.setBounds(155,150,200,25);
		passField.setBounds(155,200,200,25);
		emailField.setBounds(155,100,200,25);
		typeField.setBounds(155,250,200,25);
		textLabel.setBounds(140,30,350,30);
		textLabel.setFont(new Font("serif", Font.ITALIC + Font.BOLD, 15));
		textLabel.setForeground(new java.awt.Color(245,203,167));
		TitleLabel.setBounds(20,10,300,30);
		TitleLabel.setFont(new Font("serif", Font.BOLD, 25));
		TitleLabel.setForeground(new java.awt.Color(211,84,0));
		messageLabel.setBounds(70,325,400,25);
		messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
		messageLabel.setForeground(new java.awt.Color(244,246,246));
		instr1Label.setBounds(70,365,300,25);
		instr1Label.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
		instr1Label.setForeground(new java.awt.Color(251,238,230));
		instr2Label.setBounds(120,380,300,25);
		instr2Label.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
		instr2Label.setForeground(new java.awt.Color(251,238,230));
		bottomBorder.setBounds(5,445,490,20);
		bottomBorder.setFont(new Font("monospaced", Font.BOLD, 13));
		bottomBorder.setForeground(new java.awt.Color(253, 254, 254));
		
		login.setBounds(70,300,100,25);
		login.setFocusable(false);
		login.addActionListener(this);
		signup.setBounds(170,300,100,25);
		signup.setFocusable(false);
		signup.addActionListener(this);
		quit.setBounds(270,300,100,25);
		quit.setFocusable(false);
		quit.addActionListener(this);
		
		
		frame.add(userLabel);
		frame.add(passLabel);
		frame.add(emailLabel);
		frame.add(typeLabel);
		frame.add(messageLabel);
		frame.add(textLabel);
		frame.add(TitleLabel);
		frame.add(instr1Label);
		frame.add(instr2Label);
		frame.add(bottomBorder);
		frame.add(userField);
		frame.add(passField);
		frame.add(emailField);
		frame.add(typeField);
		frame.add(login);
		frame.add(signup);
		frame.add(quit);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new java.awt.Color(40,55,71)); 
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static final String capitalize(String str)   
	{  
		if (str == null || str.length() == 0) return str;  
		return str.substring(0, 1).toUpperCase() + str.substring(1);  
	
	}  
	

	@Override
	public void actionPerformed(ActionEvent e) {
		username = userField.getText();
		password = String.valueOf(passField.getPassword());
		accountType = typeField.getText().toLowerCase();
		accountType = this.capitalize(accountType);
		System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWW: " + accountType);
		email = emailField.getText();
		if (((e.getSource() == login)||(e.getSource() == signup))&&((username.length() == 0)||
				(password.length() == 0)||(accountType.length() == 0)||(email.length() == 0))) {
			messageLabel.setForeground(new java.awt.Color(211,84,0));
			messageLabel.setText("Please fill out all fields first.");
		}
		else if (e.getSource() == login) { 
			handleLogin(); 
			}
		else if (e.getSource() == signup) { 
			handleSignup(); 
			}
		else if (e.getSource() == quit) { 
			System.exit(0); 
			}
		
	}
	
	
	private void handleLogin() {
		//if (valid == 1) { 
		//	homePage(accountValid());
			//System.exit(0); //COMMENT OUT FOR NOW
		//}
		if (Admin.getUserList().isEmpty() == true) {
			messageLabel.setForeground(new java.awt.Color(231,76,60));
			messageLabel.setText("EMPTY USERLIST (login)");
		}
		else {
			if(this.accountValid() != 0) {
				if(this.allFieldMatch() == 1) {
					messageLabel.setForeground(new java.awt.Color(46,204,113));
					messageLabel.setText("Login successful");
				}
				else if(this.detectUsername_Password_Match() == 0 && this.allFieldMatch() != 1 ) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("Username and Password combination does not match");
				}
				else if(this.detectUsername_Password_Email_Match() == 0 && this.detectUsername_Password_Match() == 1 ) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("Email does not match");
				}
				else if(this.detect_AccountType_Match() == 1) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("Incorrect account type for this user.");
				}
				else  if(this.detectUsername_Email_Match() != 2) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("Email does not exist.");
				}
				else {
					//messageLabel.setForeground(new java.awt.Color(211,84,0));
					//messageLabel.setText("RANDOM BEHAVIOUR");
				}
			}
		}
		
	}
	
	public Integer detect_AccountType_Match() {//good
		Integer x = 0;
		for (User u : Admin.getUserList()) {
			if(u.getUsername().equals(username) && u.getEmail().equals(email) && u.getPassword().equals(password) && !u.getAccountType().equals(accountType)) {
				x = 1;
			}
		}
		return x;
	}
	//user for sign up
	public Integer detectUsername_Email_Match() {//good
		Integer x = 0;
		for (User u : Admin.getUserList()) {
			if(u.getUsername().equals(username)) {
				x = 1;
			}
			if(u.getEmail().equals(email)) {
				x = 2;
			}
		}
		return x;
	}
	
	public Integer detectUsername_Password_Match() {//good
		Integer x = 0;
		for (User u : Admin.getUserList()) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				x = 1;
			}
		}
		return x;
	}
	
	public Integer detectUsername_Password_Email_Match() {//to test
		Integer x = 0;
		for (User u : Admin.getUserList()) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password) && u.getEmail().equals(email)) {
				x = 1;
			}
		}
		return x;
	}
	
	public Integer allFieldMatch() {
		Integer x = 0;
		System.out.println("\nLOGGIN IN");
		for (User u : Admin.getUserList()) {
			if(u.getUsername().equals(username) && u.getEmail().equals(email) && u.getPassword().equals(password) && u.getAccountType().equals(accountType)) {
				if(accountType.equals("Customer")) {
					/*Customer customer_1 = new Customer();
					customer_1.setEmail(u.getEmail());
					customer_1.setUsername(u.getUsername());
					customer_1.setPassword(u.getPassword());
					customer_1.setAccountType(u.getAccountType());*/
					//Admin.getCustomerList().add(customer_1);
					
					CustomerPage cp = new CustomerPage(customer_X);
				}
				else if(accountType.equals("Driver")) {
					/*Driver d_1 = new Driver();
					d_1.setEmail(u.getEmail());
					d_1.setUsername(u.getUsername());
					d_1.setPassword(u.getPassword());
					d_1.setAccountType(u.getAccountType());*/
					//Admin.getDriverList().add(d_1);
					
					DriverPage dp = new DriverPage(driver_X);
				}
				else if(accountType.equals("Seller")) {
					/*Seller s_1 = new Seller();
					s_1.setEmail(u.getEmail());
					s_1.setUsername(u.getUsername());
					s_1.setPassword(u.getPassword());
					s_1.setAccountType(u.getAccountType());*/
					//Admin.getSellerList().add(s_1);
					
					SellerPage sp = new SellerPage(driver_X);
				}
				x = 1;
			}
			System.out.println("User name: "  + u.getEmail() + " Username: " +  u.getUsername() + " Password: " + u.getPassword() + " " + u.getAccountType()  +" logged in!");
		}
		
		return x;
	}
	
	private void handleSignup() {
		Boolean flag1 = false;
		if (Admin.getUserList().isEmpty() == true) {
			if (accountValid() != 0 && (this.detectUsername_Email_Match() == 0)) {		
				//if (!emailValid()) {
				//	messageLabel.setForeground(new java.awt.Color(211,84,0));
				//	messageLabel.setText("Invalid email.");
				//}
				if (password.contains(" ")) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("ERROR: Password cannot contain spaces");
				}
				else if (password.length() <= 5) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("ERROR: Password cannot be shorter than 6 characters");
				}
				else {
					flag1 = true;
				}
			}
		}
		else {
			for (User u : Admin.getUserList()) {
				if (this.detectUsername_Email_Match() == 1) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("This username is already taken.");
				}
				else if(this.detectUsername_Email_Match() == 2) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("This email is already taken.");
				}
				else if (accountValid() != 0 && (this.detectUsername_Email_Match() == 0) ) {
							//if (!emailValid()) {
							//	messageLabel.setForeground(new java.awt.Color(211,84,0));
							//	messageLabel.setText("Invalid email.");
							//}
							if (password.contains(" ")) {
								messageLabel.setForeground(new java.awt.Color(211,84,0));
								messageLabel.setText("ERROR: Password cannot contain spaces");
							}
							else if (password.length() <= 5) {
								messageLabel.setForeground(new java.awt.Color(211,84,0));
								messageLabel.setText("ERROR: Password cannot be shorter than 6 characters");
							}
							else {
								flag1 = true;
							}
							//homePage
							//homePage(accountValid());
					}
				}	
		}
		
		if(flag1 == true) {
			User user_X = new Customer();
			customer_X.setEmail(email);
			customer_X.setPassword(password);
			customer_X.setUsername(username);
			customer_X.setAccountType(accountType);
			Admin.getCustomerList().add(customer_X);
			
			if (accountValid() == 2){
				 user_X  = new Driver(); 
				 driver_X.setEmail(email);
				 driver_X.setPassword(password);
				 driver_X.setUsername(username);
				 driver_X.setAccountType(accountType);
				 Admin.getDriverList().add(driver_X);
			}
			else if (accountValid() == 3) {
				user_X = new Seller();
				seller_X.setEmail(email);
				seller_X.setPassword(password);
				seller_X.setUsername(username);
				seller_X.setAccountType(accountType);
				Admin.getSellerList().add(seller_X);
			}
			user_X.setEmail(email);
			user_X.setPassword(password);
			user_X.setUsername(username);
			user_X.setAccountType(accountType);	
			userlist.add(user_X);
			Admin.getUserList().add(user_X);
			
			
			messageLabel.setForeground(new java.awt.Color(46,204,113));
			messageLabel.setText("Your " + accountType + " account has been created."); 
			valid = 1;
		}
		flag1 = false;
		System.out.println("\nTESTING 12_1");
		for (User a : Admin.getUserList()) {
				if(a instanceof Customer) {
					System.out.println("User name: "  + a.getEmail() + " Username: " +  a.getUsername() + " Password: " + a.getPassword() + " CUSTOMER!");
				}
				else if (a instanceof Seller) {
					System.out.println("User name: "  + a.getEmail() + " Username: " +  a.getUsername() + " Password: " + a.getPassword() + " SELLER!");
				}
				else if (a instanceof Driver) {
					System.out.println("User name: "  + a.getEmail() + " Username: " +  a.getUsername() + " Password: " + a.getPassword() + " DRIVER!");
				}
		}
	}
	
	/*
	private void homePage(Integer i, User user_A) {
		switch(i) {
			case 1: CustomerPage cp = new CustomerPage(user_A);
			case 2: DriverPage dp = new DriverPage(user_A);
			case 3: SellerPage sp = new SellerPage(user_A); 
		}
	}
	*/
	
	private Integer accountValid() {
		if (accountType.equals("Customer") || accountType.equals("customer") ) { 
			return 1; 
			}
		else if (accountType.equals("Driver") || accountType.equals("driver")){
			return 2; 
			}
		else if (accountType.equals("Seller") || accountType.equals("seller")) {
			return 3; 
			}
		else {
			messageLabel.setForeground(new java.awt.Color(211,84,0));
			messageLabel.setText("Account Type options: Customer; Driver; Seller");
			return 0;
		}
	}
	
	private Boolean emailValid() {
		int vals[] = {43,45,95,126};
		int checkAt = 0;
		int checkDom = 0;
		int k = 0;
		for (int i = 0; i < email.length(); i++) {
			if (((email.charAt(i) < 48)&&(email.charAt(i) > 57)) && ((email.charAt(i) < 65)&&(email.charAt(i) > 90)) && 
					((email.charAt(i) < 97)&&(email.charAt(i) > 122))) {
				for (int j = 0; j < vals.length; j++) {
					if (email.charAt(i) != vals[j]) {
						if ((email.charAt(i) != '@') && ((email.charAt(i) != '.'))) {
							return false;
						}
						if (email.charAt(i) == '@') { 
							checkAt++; 
							if (checkAt == 1) { k = i; }
							else if (checkAt > 1) { return false; } 
						}
						else if (email.charAt(i) == '.') { 
							checkDom++; 
							if (checkDom > 1) { return false; } 
						}
					}
				}	
			}			
		}
		for (int l = 0; l < k - 1; l++) {
			if ((email.charAt(l) == '.') && (email.charAt(l+1) == '.')) {  return false;}
		}
		return true;
	}


}