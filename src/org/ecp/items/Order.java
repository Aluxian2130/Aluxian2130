package org.ecp.items;

import java.util.ArrayList;

public class Order{
	
    private String customerName;
    private String customerAddress;
    private String status;
    private Integer date; //date order was placed 
    private Integer deliveryDate;
    private ArrayList<String> products;
    
    public Order() {
        customerName = "unknown";
        customerAddress = "unknown";
        status = "unknown";
        date = 0;
        deliveryDate = date + 7;
        products = new ArrayList<String>();
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    
    public String getCustomerAddress() {
        return customerAddress;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setDate(Integer date) {
        this.date = date;
    }
    
    public Integer getDate() {
        return date;
    }
    
    public void setDeliveryDate(Integer value) {
    	if (value == 0) {
    		this.deliveryDate = this.date + 7;
    	}
    	else {
    		this.deliveryDate = value;
    	}
    }
    
    public Integer getDeliveryDate() {
        return deliveryDate;
    }
    
    public void addProductNames(String name) {
    	products.add(name);
    }
    public ArrayList<String> getProducts() {
    	return this.products;
    }
}