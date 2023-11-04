package org.ecp.gui.files;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomerFrame extends JFrame implements ActionListener{
	private JButton button;
	
	public CustomerFrame() {
		this.setTitle("Account homepage");
		button = new JButton();
		button.setBounds(200,100,100,50);
		button.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		button.setText("Select");
		button.setFocusable(false);
		
		
		this.getContentPane().setBackground(new Color(146,162,166));
		/*JButton b1 = new JButton();
	   	b1.setBounds(100,100,100,100);
		this.setVisible(true);
	   	this.setSize(500,500);
	 	//this.add(b1);
	   	this.setTitle("Customer");
	   	
	   	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	this.getContentPane().setBackground(new Color(146,162,166));
	   	System.out.println("Hell, World!");
	   	*/
	   	System.out.println("test");
	   	//creating a button
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			System.out.println("EH");
			button.setVisible(false);
		}
	}

    
	
}
