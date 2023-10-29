package org.ecp.gui.files;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePage extends JFrame implements ActionListener {
	JButton log_in_out_b;
	JButton sign_up_b;
	JButton email_b;
	JButton username_b;
	JButton password_b;
	
	
	
	public HomePage() {
		this.setTitle("E-commerce platform");
		this.getContentPane().setBackground(new Color(146,162,166));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setResizable(false);//so as to make it not resizeable (can remove it later)
		this.setVisible(true);
		
		
		log_in_out_b = new JButton();
		log_in_out_b.setText("Login/Logout");
		log_in_out_b.setBounds(50,10,130,50);
		log_in_out_b.setFocusable(false);
		log_in_out_b.addActionListener(this);
		log_in_out_b.setLayout(new BorderLayout());
		this.add(log_in_out_b);
		JPanel x1 = new JPanel();
		//x1.setBounds(50,10,130,50);
		//x1.setBackground(Color.green);
		//x1.setVisible(true);
		//this.add(x1);
		
		
		sign_up_b = new JButton();
		sign_up_b.setText("Sign up");
		sign_up_b.setBounds(190,10,130,50);
		sign_up_b.setFocusable(false);
		sign_up_b.addActionListener(this);
		sign_up_b.setLayout(new BorderLayout());
		this.add(sign_up_b);
		JPanel x2 = new JPanel();
		//x2.setBounds(190,10,130,50);
		//x2.setBackground(Color.red);
		//x2.setVisible(true);
		//this.add(x2);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		System.out.println("Log in button pressed");
		// TODO Auto-generated method stub
		if(e.getSource() == log_in_out_b) {
			//log_in_out_b.setVisible(false);
			String email = JOptionPane.showInputDialog(null, "Enter Email");
			System.out.println(email);
			
			String username = JOptionPane.showInputDialog(null, "Enter username");
			System.out.println(username);
			
			String password = JOptionPane.showInputDialog(null, "Enter password");
			System.out.println(password);
			//log_in_out_b.setEnabled(false);
			
			
		}
		else if(e.getSource() == sign_up_b) {
			
		}
	}
}
