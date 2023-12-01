package org.ecp.gui.files;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CustomerPage {
    JFrame frame = new JFrame();
    JLabel title = new JLabel("E-Commerce Platform");
    JLabel header = new JLabel("Welcome Customer!");
    JButton seeProductsBtn = new JButton("See Products");
    JButton accountBalanceBtn = new JButton("Account Balance");
    JButton cartBtn = new JButton("Cart");

    CustomerPage() {
        title.setBounds(30, 10, 300, 30);
        title.setFont(new Font("serif", Font.BOLD, 25));
        title.setForeground(new java.awt.Color(211, 84, 0));
        header.setBounds(40, 60, 200, 35); // Moved down the welcome message
        header.setFont(new Font("serif", Font.BOLD, 15));
        header.setForeground(new java.awt.Color(12, 222, 193)); // cyan

        // Set positions and sizes for buttons
        seeProductsBtn.setBounds(150, 110, 200, 30);
        accountBalanceBtn.setBounds(150, 160, 200, 30);
        cartBtn.setBounds(150, 210, 200, 30);

        frame.add(header);
        frame.add(title);
        frame.add(seeProductsBtn);
        frame.add(accountBalanceBtn);
        frame.add(cartBtn);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(40, 55, 71));
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // This is here for debugging and coding purposes. Remove for final deliverable.
    public static void main(String[] args) {
        // Instantiate CustomerPage and see the GUI
        new CustomerPage();
    }
}
