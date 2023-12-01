package org.ecp.gui.files;


import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.ecp.people.User;
import org.ecp.system.Admin;

public class GUI extends JFrame implements ActionListener{
	private ArrayList<User> userlist = new ArrayList<>();
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
		messageLabel.setBounds(70,325,300,25);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		username = userField.getText();
		password = String.valueOf(passField.getPassword());
		accountType = typeField.getText();
		email = emailField.getText();
		if (((e.getSource() == login)||(e.getSource() == signup))&&((username.length() == 0)||
				(password.length() == 0)||(accountType.length() == 0)||(email.length() == 0))) {
			messageLabel.setForeground(new java.awt.Color(211,84,0));
			messageLabel.setText("Please fill out all fields first.");
		}
		else if (e.getSource() == login) { handleLogin(); }
		else if (e.getSource() == signup) { handleSignup(); }
		else if (e.getSource() == quit) { System.exit(0); }
		
	}
	
	
	private void handleLogin() {
		if (valid == 1) { 
			System.exit(0);
			homePage(accountValid());
		}
		if (Admin.getUserList().isEmpty() == true) {
			messageLabel.setForeground(new java.awt.Color(231,76,60));
			messageLabel.setText("EMPTY USERLIST (login)");
		}
		for (User u : Admin.getUserList()) {
			if (u.getUsername() == username) {
				if(u.getPassword() == password) {
					messageLabel.setForeground(new java.awt.Color(46,204,113));
					messageLabel.setText("Login successful.");
					
					if (u.getEmail() == email) {
						if (accountValid() != 0) {
							if (u.getAccountType() == accountType) {
								homePage(accountValid());
							}
							else{
								messageLabel.setForeground(new java.awt.Color(211,84,0));
								messageLabel.setText("Incorrect account type.");
							}
						}
					}
					else {
						messageLabel.setForeground(new java.awt.Color(211,84,0));
						messageLabel.setText("Incorrect email.");
					}
				}
				else {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("Incorrect password.");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Error: This user does not exist. Please click Sign up.");
			}
		}
		
		
	}
	private void handleSignup() {
		if (Admin.getUserList().isEmpty() == true) {
			messageLabel.setForeground(new java.awt.Color(231,76,60));
			messageLabel.setText("EMPTY USERLIST (signup)");
		}
		for (User u : Admin.getUserList()) {
			if (u.getUsername().equals(username)) {
				messageLabel.setForeground(new java.awt.Color(211,84,0));
				messageLabel.setText("This username is already taken.");
			}
			else {
				if (u.getEmail() == email) {
					messageLabel.setForeground(new java.awt.Color(211,84,0));
					messageLabel.setText("This email is already taken.");
				}
				else {
					if (accountValid() != 0) {
						if (!emailValid()) {
							messageLabel.setForeground(new java.awt.Color(211,84,0));
							messageLabel.setText("Invalid email.");
						}
						else if (password.contains(" ")) {
							messageLabel.setForeground(new java.awt.Color(211,84,0));
							messageLabel.setText("ERROR: Password cannot contain spaces");
						}
						else if (password.length() <= 5) {
							messageLabel.setForeground(new java.awt.Color(211,84,0));
							messageLabel.setText("ERROR: Password cannot be shorter than 6 characters");
						}
						u.setEmail(email);
						u.setPassword(password);
						u.setUsername(username);
						u.setAccountType(accountType);
						userlist.add(u);
						Admin.getUserList().add(u);
						messageLabel.setForeground(new java.awt.Color(46,204,113));
						messageLabel.setText("Successfully created account."); 
						valid = 1;
						//homePage(accountValid());
					}
				}	
			}	
				
		}
	}
	
	private void homePage(Integer i) {
		switch(i) {
			case 1: CustomerPage cp = new CustomerPage();
			case 2: DriverPage dp = new DriverPage();
			case 3: SellerPage sp = new SellerPage(); 
		}
	}
	
	private Integer accountValid() {
		if (accountType == "Customer" || accountType == "customer") { return 1; }
		else if (accountType == "Driver" || accountType == "driver"){ return 2; }
		else if (accountType == "Seller" || accountType == "seller") { return 3; }
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
