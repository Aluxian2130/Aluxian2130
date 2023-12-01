package org.ecp.gui.files;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DriverPage {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("E-Commerce Platform");
    JLabel header = new JLabel("Welcome Driver!");
    JButton deliveryRouteBtn = new JButton("View Delivery Routes");
    JButton ordersBtn = new JButton("Number of Orders");
    JButton mapBtn = new JButton("Map"); // New button for the map

    DriverPage() {
        title.setBounds(30, 10, 300, 30);
        title.setFont(new Font("serif", Font.BOLD, 25));
        title.setForeground(new java.awt.Color(211, 84, 0));
        header.setBounds(40, 60, 200, 35); // Moved down the welcome message
        header.setFont(new Font("serif", Font.BOLD, 15));
        header.setForeground(new java.awt.Color(187, 34, 228)); // magenta

        // Set positions and sizes for buttons
        deliveryRouteBtn.setBounds(150, 110, 200, 30);
        ordersBtn.setBounds(150, 160, 200, 30);
        mapBtn.setBounds(150, 210, 200, 30); // Position for the Map button

        frame.add(header);
        frame.add(title);
        frame.add(deliveryRouteBtn);
        frame.add(ordersBtn);
        frame.add(mapBtn); // Added the Map button

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(40, 55, 71));
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    
    // This is here for debugging and coding purposes. Remove for final deliverable.
    public static void main(String[] args) {
        // Instantiate DriverPage and see the GUI
        new DriverPage();
    }
}
