package org.ecp.gui.files;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
	
	
	
	
    JFrame frame = new JFrame();
    JLabel title = new JLabel("E-Commerce Platform");
    JLabel header;
    JButton seeProductsBtn = new JButton("View Available Products");
    JButton accountDetailsButton = new JButton("Account Details");
    JButton cartBtn = new JButton("Go to Checkout");
    JButton addToCart = new JButton("Add to cart");
    JButton makePayment = new JButton("Make Payment");
    JButton removeFromCart = new JButton("Remove product");
    
    
    Seller seller_A = new Seller();
    Seller seller_B = new Seller();
    
    Driver driver_A = new Driver();
    
    Product prod_A = new Product();
	Product prod_B = new Product();
	Product prod_C = new Product();
	private static Integer cIndex;
	private Customer c1 = new Customer();;
	private ArrayList<Product> cart = new ArrayList<Product>();
	
	
	DefaultListModel<String> myShopList = new DefaultListModel<>();
	JList<String> listShop = new JList<>(myShopList);
	ArrayList<String> stringShopList = new ArrayList<String>();
	private String tempItem = null;
	private String remTempItem = null;
	private Double totalPrice;


	
    public CustomerPage(String emailIn, String usernameIn, String passwordIn, String accountTypeIn, double accountBalanceIn) {
    	totalPrice = 0.0;
    	cIndex = 0;
    	//creating account
    	
    	c1.setEmail(emailIn);
    	c1.setUsername(usernameIn);
    	c1.setPassword(passwordIn);
    	c1.setAccountType(accountTypeIn);
    	c1.setAccountBalance(accountBalanceIn);
    	this.populateCustomerList();
    	cIndex = this.getcIndex();
    	
    	
    	header = new JLabel("Welcome " + Admin.getCustomerList().get(cIndex).getUsername() + " to your " + Admin.getCustomerList().get(cIndex).getAccountType() + " account!");
    	Admin.printCustomerList();
    	//Just as a Driver file to test CustomerPage

    	//seller A and B
    	
    	seller_A.setUsername("Osman");
    	//Admin.getUserList().add(seller_A);
    	
    	seller_B.setUsername("Alex");
    	//Admin.getUserList().add(seller_B);
    	
    	//dirver A 
    	//Admin.getUserList().add(driver_A);
    	
    	//creating product A and B and C
    	prod_A.setName("iPhone");
    	prod_A.setPrice(30);
    	prod_A.setDescription("Really useful tool. Can make calls, text, take pictures and more!");

    	prod_B.setName("suitcase");
    	prod_B.setPrice(10);
    	prod_B.setDescription("Can carry up to 28kg of weight.");

    	prod_C.setName("printer");
    	prod_C.setPrice(20);
    	prod_C.setDescription("Prints in all colours");
    	
    	//Seller A has 2 and Seller B has 1
    	seller_A.addStaticProdList(prod_A);
    	seller_A.addStaticProdList(prod_B);
    	seller_B.addStaticProdList(prod_C);
    	Admin.getSellerList().add(seller_A);
    	Admin.getSellerList().add(seller_B);
    	
    	//JLabel messageLabel = new JLabel();
    	//messageLabel.setBounds(10,120,150,25);
		//messageLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
		//messageLabel.setForeground(new java.awt.Color(244,246,246));
		//messageLabel.setText("Current Shopping:");
    	//frame.add(messageLabel);
		
    	//p1.setBounds(10, 100, 100, 100);
    	
    	//list.setBounds(10,140, 200, 200);
    	
    	message2.setBounds(150,240,250,100);
        message2.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
    	message2.setForeground(new java.awt.Color(244,246,246));
    	message2.setText("Total payment amount: " + totalPrice + "$" );
    	
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    	 else if (e.getSource() == addToCart) { 
		 		System.out.println("Adding to cart");
		 		handleAddToCart();
			}
    	 else if (e.getSource() == removeFromCart) { 
		 		System.out.println("Removing from cart");
		 		handleRemoveFromCart();
			}
    	 else if (e.getSource() == makePayment) { 
		 		System.out.println("Making Payment");
		 		handleMakePayment();
			}
	}
    
    private void handleMakePayment() {
		// TODO Auto-generated method stub
    	myShopList.clear();
    	Admin.getCustomerList().get(cIndex).setAccountBalance(Admin.getCustomerList().get(cIndex).getAccountBalance() - totalPrice);	
    	totalPrice = 0.0;
    	message2.setText("Total payment amount: " + totalPrice + "$" );
	}

	private void handleRemoveFromCart() {
		// TODO Auto-generated method stub
    	if(myShopList.contains(remTempItem)) {
    		
    		for(Product p1: Admin.getProdAdminList()) {
           		 if( p1.getName().equals(remTempItem) ) {
           			totalPrice = totalPrice - p1.getPrice();
           			myShopList.removeElement(remTempItem);
            		stringShopList.remove(remTempItem);
            		
           		 }
           	 	
             }
    
    		message2.setText("Total payment amount: " + totalPrice + "$" );
    	}
		
	}

	public void setTotalPrice(Double x) {
		this.totalPrice = x;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	
	JLabel message2 = new JLabel();
    
    private void handleAddToCart() {
		// TODO Auto-generated method stub
    	if(!myShopList.contains(tempItem)) {
    		myShopList.addElement(tempItem);
    		stringShopList.add(tempItem);
    		
    		totalPrice = 0.0;
    		
    		for(Product p1: Admin.getProdAdminList()) {
            	for(String j: stringShopList) {
           		 if(j.equals(p1.getName())) {
           			 totalPrice = totalPrice + p1.getPrice();
           		 }
           	 	}
             }
    		message2.setText("Total payment amount: " + totalPrice + "$" );
    	}
		
	}

	private void populateCustomerList() {
		// TODO Auto-generated method stub
    	if(this.checkCustomerExistence() == false) { //means if customer does not exist then add to the customerList
    		Admin.getCustomerList().add(c1);
    	}
    	else {
    		//do nothing
    		System.out.println("*****Customer exists******");
    	}

	}

	private Boolean checkCustomerExistence() {
		// TODO Auto-generated method stub
		Integer i = 0;
		for(Customer x: Admin.getCustomerList()) {
			if( x.getUsername().equals(c1.getUsername())  && x.getEmail().equals(c1.getEmail()) && x.getAccountType().equals(c1.getAccountType()) ) {
				return true;
			}
		}
		return false;
	}

	private Integer getcIndex() {
		// TODO Auto-generated method stub
		Integer i = 0;
		for(Customer x: Admin.getCustomerList()) {
			if( x.getUsername().equals(c1.getUsername())  && x.getEmail().equals(c1.getEmail()) && x.getAccountType().equals(c1.getAccountType()) ) {
				return Admin.getCustomerList().indexOf(x);
			}
		}
		return -100;
	}

	private void handleAvailableProducts() {
		// TODO Auto-generated method stub
		DefaultListModel<String> myList = new DefaultListModel<>();
		JList<String> list = new JList<>(myList);
		JFrame frame2 = new JFrame();
		list.setBackground(new java.awt.Color(133, 118, 76));
		
		
		
		//JLabel errorLabel = new JLabel();
		 //errorLabel.setBounds(160,400,200,30);
	     //errorLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     //errorLabel.setForeground(new java.awt.Color(244,246,246));

		if(Admin.getProdAdminList().isEmpty()) {
		    //errorLabel.setText("Currently no items for sale ");
		}
		else {
			for(Product p: Admin.getProdAdminList()) {
				myList.addElement(p.getName()) ;
			}
		} 	
		
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
        
        //String testString = "A really cool string\n if you like. \nAm doing random stuff\n";
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 1) {
                  JList target = (JList)me.getSource();
                  int index = target.locationToIndex(me.getPoint());
                  if (index >= 0) {
                	 Double price = 0.0;
                	 String description = " ";
                     Object item = target.getModel().getElementAt(index);
                     for(Product p1: Admin.getProdAdminList()) {
                    	 if(p1.getName().equals(item.toString())) {
                    		 price = p1.getPrice();
                    		 description = p1.getDescription();
                    		 tempItem = item.toString();
                    	 }
                     }
                    
                    // JOptionPane.showMessageDialog(null, item.toString());
                     messageLabel.setForeground(new java.awt.Color(244,246,246));
                	 messageLabel.setText("<html>Product Information<br/>Item:"  + item.toString() +"<br/>Price: " + price +  
                			 "$<br/>Description: " + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
                  }
                  else {
                	messageLabel.setForeground(new java.awt.Color(211,84,0));
                  	messageLabel.setText("No item selected"); 
                  }
               }
            }
         });
        //frame2.add(errorLabel);

	    addToCart.setBounds(320, 310, 100, 30);//ADD TO CART
	    addToCart.addActionListener(this); //IF BUTTON PRESSED ADD TO CART
	    frame2.add(addToCart);
        frame2.add(messageLabel);
        frame2.add(messageLabel);
       //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//#########################################################################################################################################
	
	private void handleCheckoutDetails() {
		// TODO Auto-generated method stub
		
		JFrame frame2 = new JFrame();
		listShop.setBackground(new java.awt.Color(133, 118, 76));
				
    	frame2 = new JFrame("View Cart Information");
       // String sports[]= {"Tennis","Archery","Football","Fencing","Cricket","Squash","Hockey","Rugby"};
       // list = new JList(sports);
        JScrollPane scrollPane = new JScrollPane(listShop);
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
        

               
       
        listShop.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
               if (me.getClickCount() == 1) {
                  JList target = (JList)me.getSource();
                  int index = target.locationToIndex(me.getPoint());
                  if (index >= 0) {
                	 Double price = 0.0;
                 	 String description = " ";
                     Object item = target.getModel().getElementAt(index);
                      for(Product p1: Admin.getProdAdminList()) {
                     	 if(p1.getName().equals(item.toString())) {
                     		 price = p1.getPrice();
                     		 description = p1.getDescription();
                     		 remTempItem = item.toString();
                     	 }
                      }
                     // JOptionPane.showMessageDialog(null, item.toString());
                     messageLabel.setForeground(new java.awt.Color(244,246,246));
                 	 messageLabel.setText("<html>Product Information<br/>Item:"  + remTempItem.toString() +"<br/>Price: " + price +  
                 			 "$<br/>Description: " + description.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") 
                 			 + "</html>");
                    
                  }
                  else {
                	messageLabel.setForeground(new java.awt.Color(211,84,0));
                  	messageLabel.setText("No item selected"); 
                  }
               }
            }
         });
        
     
        frame2.add(message2);

	    makePayment.setBounds(290, 310, 140, 30);//ADD TO CART
	    makePayment.addActionListener(this);
	    frame2.add(makePayment);
	    
	    removeFromCart.setBounds(140, 310, 140, 30);//ADD TO CART
	    removeFromCart.addActionListener(this);
	    frame2.add(removeFromCart);
	    
        frame2.add(messageLabel);
        frame2.add(messageLabel);
        //frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void handleAccountDetails() {
		// TODO Auto-generated method stub
		JFrame frame3 = new JFrame("Your Account Details");
		
		 JLabel emailLabel = new JLabel();
		 emailLabel.setBounds(10,10,200,30);
	     emailLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     emailLabel.setForeground(new java.awt.Color(244,246,246));
	     emailLabel.setText("Email: " + Admin.getCustomerList().get(cIndex).getEmail() );
	     frame3.add(emailLabel);
	     
         JLabel usernameLabel = new JLabel();
		 usernameLabel.setBounds(10,30,200,30);
	     usernameLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     usernameLabel.setForeground(new java.awt.Color(244,246,246));
	     usernameLabel.setText("Username: " + Admin.getCustomerList().get(cIndex).getUsername() );
	     frame3.add(usernameLabel);
	     
	     JLabel accountTypeLabel = new JLabel();
		 accountTypeLabel.setBounds(10,50,200,30);
	     accountTypeLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     accountTypeLabel.setForeground(new java.awt.Color(244,246,246));
	     accountTypeLabel.setText("Account type: " + Admin.getCustomerList().get(cIndex).getAccountType() );
	     frame3.add(accountTypeLabel);
	     
	     JLabel balanceLabel = new JLabel();
		 balanceLabel.setBounds(10,70,200,30);
	     balanceLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     balanceLabel.setForeground(new java.awt.Color(244,246,246));
	     balanceLabel.setText("Account balance: " + Admin.getCustomerList().get(cIndex).getAccountBalance() );
	     frame3.add(balanceLabel);
	     
	     JLabel addressLabel = new JLabel();
		 addressLabel.setBounds(10,90,200,30);
	     addressLabel.setFont(new Font("monospaced", Font.ITALIC + Font.BOLD, 12));
	     addressLabel.setForeground(new java.awt.Color(244,246,246));
	     addressLabel.setText("Address: " + Admin.getCustomerList().get(cIndex).getAddress() );
	     frame3.add(addressLabel);
	    
	     
	     
	     
	     //frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame3.getContentPane().setBackground(new java.awt.Color(40,55,71)); 
	     frame3.setSize(450,400);
	     frame3.setLayout(null);
	     frame3.setVisible(true);
	    
	     
		
	}

	
    // This is here for debugging and coding purposes. Remove for final deliverable.
    //public static void main(String[] args) {
        // Instantiate CustomerPage and see the GUI
     //   new CustomerPage();
    //}
}