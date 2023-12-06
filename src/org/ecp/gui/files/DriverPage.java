package org.ecp.gui.files;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.ecp.items.Order;
import org.ecp.items.Product;
import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.system.Admin;

public class DriverPage implements ActionListener{
    JFrame frame = new JFrame();
    JLabel title = new JLabel("E-Commerce Platform");
    JLabel header = new JLabel("Welcome Driver!");
    JLabel deliveryMessage = new JLabel("Choose an item to modify Delivery List");
    JLabel message = new JLabel();
    JButton deliveryList = new JButton("View Delivery List");
    JButton addToDeliveryList = new JButton("Add");
    JButton removeFromDeliveryList = new JButton("Remove");
    JButton ordersBtn = new JButton("Orders");
    JButton mapBtn = new JButton("View Map"); // New button for the map

    DefaultListModel<String> OrderList = new DefaultListModel<>();
	ArrayList<String> stringOrderList = new ArrayList<String>();
    private ArrayList<Order> orderList = new ArrayList<>();
    private int deliveries = 0;
    private String tempItem = null;
	private Order oas1 = new Order();;

    public DriverPage(Driver d1) {
        title.setBounds(30, 10, 300, 30);
        title.setFont(new Font("serif", Font.BOLD, 25));
        title.setForeground(new java.awt.Color(211, 84, 0));
        header.setBounds(40, 60, 200, 35); // Moved down the welcome message
        header.setFont(new Font("serif", Font.BOLD, 15));
        header.setForeground(new java.awt.Color(187, 34, 228)); // magenta

        // Set positions and sizes for buttons
        deliveryList.setBounds(150, 110, 200, 30);
        ordersBtn.setBounds(150, 160, 200, 30);
        mapBtn.setBounds(150, 210, 200, 30); // Position for the Map button
        
        deliveryList.addActionListener(this);
        ordersBtn.addActionListener(this);
        mapBtn.addActionListener(this);

        frame.add(header);
        frame.add(title);
        frame.add(ordersBtn);
        frame.add(mapBtn);

       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(40, 55, 71));
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == ordersBtn) { handleViewOrders(); }
    	else if (e.getSource() == deliveryList) {
    		//handleViewDeliveryList(); 
    		}
    	else if (e.getSource() == mapBtn) { handleViewMap(); }
    	else if (e.getSource() == addToDeliveryList) { 
    		//handleAddToDeliveryList(); 
    		} 
    	else if (e.getSource() == removeFromDeliveryList) { 
    		//handleRemoveFromDeliveryList(); 
    		}
    }
    
    private void handleViewDeliveryList() {
    	System.out.println("TTTTTTTTEEEEEEEEEEEEEEESTTTTTTTTTTTT");
    	JFrame deliveries = new JFrame("Delivery List");
    	deliveries.setSize(400, 300);
        
        DefaultListModel<String> myList = new DefaultListModel<>();
        JList<String> list = new JList<>(myList);
		list.setBackground(new java.awt.Color(133, 118, 76));
		
		JScrollPane scrollPane = new JScrollPane(list);
        Container contentPane = frame.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
		
        deliveries.add(scrollPane);
        deliveries.setSize(150,400);
        deliveries.setVisible(true);
         
        deliveries.getContentPane().setBackground(new java.awt.Color(35, 55, 71));
        deliveries.setSize(450, 400);
        deliveries.setLocation(20,30);
        deliveries.setLayout(null);
        deliveries.setVisible(true);
      
         
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(160,10,200,300);
        messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
        messageLabel.setForeground(new java.awt.Color(244,246,246));
        
        
		
	}


	private void handleViewOrders() {
    	JLabel errorLabel = new JLabel();
    	errorLabel.setBounds(160,400,200,30);
        errorLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
        errorLabel.setForeground(new java.awt.Color(244,246,246));
    	
        DefaultListModel<String> myList = new DefaultListModel<>();
        JList<String> list = new JList<>(myList);
        JFrame Orders = new JFrame();
		list.setBackground(new java.awt.Color(133, 118, 76));
		Orders.setSize(400, 300);
      
        
	
			for(Order o: Admin.getDeliveryList()) {
				myList.addElement(o.getCustomerName()) ;
			}
		
		
		
		Orders = new JFrame("Orders");
        JScrollPane scrollPane = new JScrollPane(list);
        Container contentPane = frame.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        Orders.add(scrollPane);
        Orders.setSize(150,400);
        Orders.setVisible(true);
         
        Orders.getContentPane().setBackground(new java.awt.Color(35, 55, 71));
        Orders.setSize(450, 400);
        Orders.setLocation(20,30);
        Orders.setLayout(null);
        Orders.setVisible(true);
      
         
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(160,10,200,300);
        messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
        messageLabel.setForeground(new java.awt.Color(244,246,246));
         

 		messageLabel.setForeground(new java.awt.Color(211,84,0));
        messageLabel.setText("No item selected");
        
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 1) {
                  JList target = (JList)me.getSource();
                  int index = target.locationToIndex(me.getPoint());
                  if (index >= 0) {
                	 String customerName = "unknown";
                	 String customerAddress = "unknown";
                	 String status = "unknown";
                	 String deliveryDate = "unknown";
                	 ArrayList<String> products = null;
                	 Object item = target.getModel().getElementAt(index);
                     for(Order o1 : Admin.getDeliveryList()) {
                    	 if(o1.getCustomerName().equals(item.toString())) {
                    		 customerName = o1.getCustomerName();
                    		 customerAddress = o1.getCustomerAddress();
                    		 status = o1.getStatus();
                    		 deliveryDate = o1.getDeliveryDate().toString();
                    		 products = o1.getProducts();
                    		 tempItem = item.toString();
                    	 }
                     }
                     messageLabel.setForeground(new java.awt.Color(244,246,246));
                	 messageLabel.setText("<html>Order Information<br/>Customer Name: "  + item.toString() +"<br/>Customer Address: " + customerAddress +  
                			 "<br/>Status: " + status + "<br/>Delivery Date: " + deliveryDate + "</html>" );
                			 //description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                  }
                  else {
                	messageLabel.setForeground(new java.awt.Color(211,84,0));
                  	messageLabel.setText("No item selected"); 
                  }
               }
            }
         });

        deliveryMessage.setBounds(150, 330, 250, 25);
        deliveryMessage.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 10));
        deliveryMessage.setForeground(new java.awt.Color(244,246,246));
       // addToDeliveryList.setBounds(300, 300, 130, 30);//ADD TO CART
       // addToDeliveryList.addActionListener(this); //IF BUTTON PRESSED ADD TO CART
       // removeFromDeliveryList.setBounds(150, 300, 130, 30);
       // addToDeliveryList.addActionListener(this);
       // Orders.add(removeFromDeliveryList);
       // Orders.add(addToDeliveryList);
        Orders.add(deliveryMessage);
        Orders.add(messageLabel);
        Orders.add(messageLabel);
         
    	
    }
	
	JFrame map = new JFrame("Map");
	JLabel displayField;
	ImageIcon image;
	
    private void handleViewMap() {
    	
    	map = new JFrame("Map");
    	
    	try {
    		image = new ImageIcon(getClass().getResource("OurMaps.png"));
    		displayField = new JLabel(image);
    		map.add(displayField);
    	}catch(Exception e) {
    		System.out.println("Cant found");
    	}
    	map.pack();
    	map.setVisible(true);
    	
    	
        String Address3 = "9001 S Sycamore Ln";
        JLabel l1 = new JLabel("8098 N Stone St");
        JLabel l2 = new JLabel("3508 W Blvd St");
       // addressList.add("8098 N Stone St");
       // addressList.add("3508 W Blvd St");
        //JLabel l1 = new JLabel(orderList.get(0).getCustomerAddress());
        //JLabel l2 = new JLabel(orderList.get(1).getCustomerAddress());
        JLabel l3 = new JLabel(Address3);
        
        l1.setFont(new Font("monospaced", Font.BOLD, 11));
        l1.setForeground(new java.awt.Color(244,246,246));
        l1.setBackground(new java.awt.Color(187, 34, 228));
        l1.setOpaque(true);
        l2.setFont(new Font("monospaced", Font.BOLD, 11));
        l2.setForeground(new java.awt.Color(244,246,246));
        l2.setBackground(new java.awt.Color(187, 34, 228));
        l2.setOpaque(true);
        l3.setFont(new Font("monospaced", Font.BOLD, 11));
        l3.setForeground(new java.awt.Color(244,246,246));
        l3.setBackground(new java.awt.Color(187, 34, 228));
        l3.setOpaque(true);
        
        l1.setBorder(BorderFactory.createLineBorder(Color.white));
        l2.setBorder(BorderFactory.createLineBorder(Color.white));
        l3.setBorder(BorderFactory.createLineBorder(Color.white));
        
        l1.setBounds(275,250,150,35);
        l2.setBounds(75,100,150,35);
        l3.setBounds(350,30,150,35);
        
        map.add(l1);
        map.add(l2);
        map.add(l3);
        
        map.getContentPane().setBackground(new java.awt.Color(40,55,71));
    	map.setLayout(null);
    	map.setVisible(true);
        //map.setSize(550, 400);   
        
    }
    
    private void handleRemoveFromDeliveryList() {
    	if(OrderList.contains(tempItem)) {
    		for(Product p1: Admin.getProdAdminList()) {
           		 if( p1.getName().equals(tempItem) ) {
           			OrderList.removeElement(tempItem);
            		stringOrderList.remove(tempItem);
           		 }
             }
    		message.setText("Total amount of deliveries: " + deliveries);
    	}
		
	}


	private void handleAddToDeliveryList() {
		if(!OrderList.contains(tempItem)) {
			OrderList.addElement(tempItem);
			stringOrderList.add(tempItem);
    		deliveries = 0;
    		for(Order o1: Admin.getDeliveryList()) {
            	for(String j: stringOrderList) {
           		 if(j.equals(o1.getCustomerName())) {deliveries++;}
           	 	}
            }
    		message.setText("Total amount of deliveries: " + deliveries);
    	}
		
	}
    
    
    
}
