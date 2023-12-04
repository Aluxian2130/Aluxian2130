package org.ecp.gui.files;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.ecp.people.User;

public class SellerPage {
	JFrame frame = new JFrame();
	JLabel title = new JLabel("E-Commerce Platform");
	JLabel header = new JLabel("Welcome Seller!");
	
	SellerPage(User u){
		title.setBounds(30,10,300,30);
		title.setFont(new Font("serif", Font.BOLD, 25));
		title.setForeground(new java.awt.Color(211,84,0));
		header.setBounds(50,20,200,35);
		header.setFont(new Font("serif", Font.BOLD, 15));
		header.setForeground(new java.awt.Color(225,246,76)); //lime
		
		frame.add(header);
		frame.add(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new java.awt.Color(40,55,71)); 
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	// This is here for debugging and coding purposes. Remove for final deliverable.
    public static void main(String[] args) {
        // Instantiate SellerPage and see the GUI
        new SellerPage(null);
    }
}
