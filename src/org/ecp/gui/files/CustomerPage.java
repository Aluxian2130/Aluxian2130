package org.ecp.gui.files;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import org.ecp.items.Product;
import org.ecp.people.Customer;
import org.ecp.people.Driver;
import org.ecp.people.Seller;
import org.ecp.people.User;
import org.ecp.system.Admin;


public class CustomerPage extends JFrame implements ActionListener{
	
	
	DefaultListModel<String> myList = new DefaultListModel<>();
	JList<String> list = new JList<>(myList);
	
    JFrame frame = new JFrame();
    JLabel title = new JLabel("E-Commerce Platform");
    JLabel header;
    JButton seeProductsBtn = new JButton("View Available Products");
    JButton accountDetailsButton = new JButton("Account Details");
    JButton cartBtn = new JButton("Go to Checkout");

    Seller seller_A = new Seller();
    Seller seller_B = new Seller();
    
    Driver driver_A = new Driver();
    
    Product prod_A = new Product();
	Product prod_B = new Product();
	Product prod_C = new Product();

	Customer c1;
    
    public CustomerPage(Customer customer_1) {
    	//creating account
    	c1 = customer_1;
    	header = new JLabel("Welcome " + customer_1.getUsername() + " to your " + customer_1.getAccountType() + " account!");
    	
    	//Just as a Driver file to test CustomerPage
    	Admin.getUserList().clear();
    	Admin.getUserList().add(customer_1);
    	Admin.getCustomerList().add(customer_1); //WHAT TO DO WITH THIS

    	//seller A and B
    	
    	seller_A.setUsername("Aman");
    	Admin.getUserList().add(seller_A);
    	
    	seller_B.setUsername("Nav");
    	Admin.getUserList().add(seller_B);
    	
    	//dirver A 
    	driver_A.setUsername("Osman");
    	Admin.getUserList().add(driver_A);
    	
    	//creating product A and B and C
    	
    	prod_A.setName("iPhone");
    	prod_A.setPrice(1199);
    	prod_A.setDescription("Really useful tool. Can make calls, text, take pictures and more!");

    	prod_B.setName("suitcase");
    	prod_B.setPrice(45);
    	prod_B.setDescription("Can carry up to 28kg of weight.");

    	prod_C.setName("printer");
    	prod_C.setPrice(155);
    	prod_C.setDescription("Prints in all colours");
    	
    	//Seller A has 2 and Seller B has 1
    	seller_A.addToProductList(prod_A);
    	seller_A.addToProductList(prod_B);
    	seller_B.addToProductList(prod_C);
    	
    	//JLabel messageLabel = new JLabel();
    	//messageLabel.setBounds(10,120,150,25);
		//messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
		//messageLabel.setForeground(new java.awt.Color(244,246,246));
		//messageLabel.setText("Current Shopping:");
    	//frame.add(messageLabel);
		
    	//p1.setBounds(10, 100, 100, 100);
    	
    	//list.setBounds(10,140, 200, 200);
    	
    	
    	
        title.setBounds(30, 10, 300, 30);
        title.setFont(new Font("serif", Font.BOLD, 25));
        title.setForeground(new java.awt.Color(211, 84, 0));
        header.setBounds(40, 60, 300, 35); // Moved down the welcome message
        header.setFont(new Font("serif", Font.BOLD, 15));
        header.setForeground(new java.awt.Color(12, 222, 193)); // cyan

        // Set positions and sizes for buttons
        seeProductsBtn.setBounds(150, 110, 200, 30);
        accountDetailsButton.setBounds(150, 160, 200, 30);
        cartBtn.setBounds(150, 210, 200, 30);
        
		seeProductsBtn.addActionListener(this);
		accountDetailsButton.addActionListener(this);
		cartBtn.addActionListener(this);


        frame.add(header);
        frame.add(title);
        frame.add(seeProductsBtn);
        frame.add(accountDetailsButton);
        frame.add(cartBtn);

        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new java.awt.Color(40, 55, 71));
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        
        
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	 if (e.getSource() == seeProductsBtn) { 
    		 	System.out.println("seeProducts");
 				handleAvailableProducts(); 
 			}
    	 else if (e.getSource() == accountDetailsButton) { 
    		 	System.out.println("accountDetails");
    		 	handleAccountDetails();
 				 
 			}
    	 else if (e.getSource() == cartBtn) { 
 		 	System.out.println("Checkout");
 		 	handleCheckoutDetails();
				 
			}
		
	}
    
    
   
    
	private void handleCheckoutDetails() {
		// TODO Auto-generated method stub
		
	}

	private void handleAccountDetails() {
		// TODO Auto-generated method stub
		JFrame frame3 = new JFrame("Your Account Details");
		
		 JLabel emailLabel = new JLabel();
		 emailLabel.setBounds(10,10,200,30);
	     emailLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     emailLabel.setForeground(new java.awt.Color(244,246,246));
	     emailLabel.setText("Email: " + c1.getEmail());
	     frame3.add(emailLabel);
	     
         JLabel usernameLabel = new JLabel();
		 usernameLabel.setBounds(10,30,200,30);
	     usernameLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     usernameLabel.setForeground(new java.awt.Color(244,246,246));
	     usernameLabel.setText("Username: " + c1.getUsername());
	     frame3.add(usernameLabel);
	     
	     JLabel accountTypeLabel = new JLabel();
		 accountTypeLabel.setBounds(10,50,200,30);
	     accountTypeLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     accountTypeLabel.setForeground(new java.awt.Color(244,246,246));
	     accountTypeLabel.setText("Account type: " + c1.getAccountType());
	     frame3.add(accountTypeLabel);
	     
	     JLabel addressLabel = new JLabel();
		 addressLabel.setBounds(10,70,200,30);
	     addressLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     addressLabel.setForeground(new java.awt.Color(244,246,246));
	     addressLabel.setText("Address: " + c1.getAddress());
	     frame3.add(addressLabel);
	     
	     
	     
	     frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame3.getContentPane().setBackground(new java.awt.Color(40,55,71)); 
	     frame3.setSize(450,400);
	     frame3.setLayout(null);
	     frame3.setVisible(true);
	     
		
	     frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame3.setVisible(true);
	     
		
	}

	private void handleAvailableProducts() {
		// TODO Auto-generated method stub
		JFrame frame2 = new JFrame();
		list.setBackground(new java.awt.Color(133, 118, 76));
    	myList.addElement(prod_A.getName()) ;
    	myList.addElement(prod_B.getName());
    	myList.addElement(prod_C.getName()) ;
    	myList.addElement("TEST PRODUCT 12345678" ) ;
    	
    	      
    	frame2 = new JFrame("View Products Page");
       // String sports[]= {"Tennis","Archery","Football","Fencing","Cricket","Squash","Hockey","Rugby"};
       // list = new JList(sports);
        JScrollPane scrollPane = new JScrollPane(list);
        Container contentPane = frame.getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        frame2.add(scrollPane);
        frame2.setSize(150,400);
        frame2.setVisible(true);
        
        frame2.getContentPane().setBackground(new java.awt.Color(35, 55, 71));
        frame2.setSize(450, 400);
        frame2.setLocation(20,30);
        frame2.setLayout(null);
        frame2.setVisible(true);
     
        
        JLabel messageLabel = new JLabel();
        messageLabel.setBounds(160,10,200,300);
        messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
        messageLabel.setForeground(new java.awt.Color(244,246,246));
        

		messageLabel.setForeground(new java.awt.Color(211,84,0));
        messageLabel.setText("No item selected");
        
        String testString = "A really cool string\n if you like. \nAm doing random stuff\n";
       
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 1) {
                  JList target = (JList)me.getSource();
                  int index = target.locationToIndex(me.getPoint());
                  if (index >= 0) {
                     Object item = target.getModel().getElementAt(index);
                    // JOptionPane.showMessageDialog(null, item.toString());
                     messageLabel.setForeground(new java.awt.Color(244,246,246));
                	 messageLabel.setText("<html>Product Information<br/>Item:"  + item.toString() + "<br/>Description: " + prod_B.getDescription().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");

                  }
                  else {
                	messageLabel.setForeground(new java.awt.Color(211,84,0));
                  	messageLabel.setText("No item selected"); 
                  }
               }
            }
         });
        frame2.add(messageLabel);
        frame2.add(messageLabel);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

    // This is here for debugging and coding purposes. Remove for final deliverable.
    //public static void main(String[] args) {
        // Instantiate CustomerPage and see the GUI
     //   new CustomerPage();
    //}
}
