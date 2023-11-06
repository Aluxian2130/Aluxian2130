package org.ecp.items;

public class Order{
	
    private String customerName;
    private String customerAddress;
    private String status;
    private Integer date;
    
    Order() {
        customerName = "unknown";
        customerAddress = "unknown";
        status = "unknown";
        date = 0;
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
}