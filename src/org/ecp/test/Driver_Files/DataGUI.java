package org.ecp.test.Driver_Files;

import java.util.Scanner;

import org.ecp.gui.files.GUI;
import org.ecp.navigation.OnlineMaps;
import org.ecp.people.Customer;
import org.ecp.people.User;
import org.ecp.system.Admin;

public class DataGUI {
	
	public static void main(String[] args) {
		Admin admin1 = new Admin();
		Admin admin2;
		GUI newGUI;
		
		Admin.setMaxDeliveries(5);
		Admin.setMaxLimit(100.0);
		Admin.setMaxProducts(10);
		OnlineMaps.addAddress("4581 Star St");
        OnlineMaps.addAddress("6740 Moon Ave");
        OnlineMaps.addAddress("3682 Nebula Blvd");
        OnlineMaps.addAddress("7129 Galaxy Rd");
		
		// Create a Customer
        String email = "star1@gmail.com";
        String password = "data123feather";
        String username = "Hannah";
        String accountType = "Customer";
        double accountBalance = 50.0;
        //Customer c1 = new Customer(email, password, username, accountType, accountBalance);
        //Customer c2 = new Customer("hey2@yahoo.aol", "starsign8!", "Josh", "Customer", 70.23);  
        //admin1.getUserList().add(c1);
        //admin1.getUserList().add(c2);
        
		
		newGUI = new GUI("ECP_GUI");	
		
	}
}
