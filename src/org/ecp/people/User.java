package org.ecp.people;

import java.util.Scanner;

//import org.ecp.items.Product;
import org.ecp.system.Admin;

public abstract class User {
   protected String email = "unknown";
   protected String password = "unknown";
   protected String username;
   protected String accountType;
   protected double accountBalance;
   private Admin a1 = new Admin();

   public User() {
	   email = "unknown";
	   password = "unknown";
	   username = "unknown";
	   accountType = "unknown";
       accountBalance = 0.0;
       //this.createAccount();
   }
   public User(String email, String password, String username, double accountBalance) {
	   this.email = email;
	   this.password = password;
	   this.username = username;
	   this.accountBalance = accountBalance;
   }
   
   public User(String email, String password, String username, String accountType, double accountBalance) {
	   this.email = email;
	   this.password = password;
	   this.username = username;
	   this.accountType = accountType;
	   this.accountBalance = accountBalance;
   }

   
   public void setEmail(String email) {
      this.email = email;
   }

   public String getEmail() {
      return email;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getPassword() {
      return password;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getUsername() {
      return username;
   }
   
   public void setAccountType(String accountType) {
	  this.accountType = accountType;
   }

   public String getAccountType() {
	  return accountType;
   }

   public void setAccountBalance(double accountBalance) {
      this.accountBalance = accountBalance;
   }

   public double getAccountBalance() {
      return accountBalance;
   }

   public void removeFunds(Double amount) {
      if (this.accountBalance - amount >= 0.0) {
         this.accountBalance -= amount;
      }

   }
   
   public void createAccount() {
	   System.out.println("Enter email: ");
	   Scanner myObj = new Scanner(System.in);
	   this.email = myObj.nextLine();
	   
	   System.out.println("Enter username: ");
	   this.username = myObj.nextLine();
	   
	   System.out.println("Enter password: ");
	   this.password = myObj.nextLine();
	   
	   System.out.println("Enter account type");
	   this.accountType = myObj.nextLine();
	   //System.out.println("ADDED");
	   //if(this.emailMismatch(this) != false) {
	   if(Admin.detectSignupConflict(email, username, password, accountType) == false) {
		   Admin.getUserList().add(this);
	   }
	   else {
		   this.email = "unknown";
		   this.password = "unknown";
		   this.accountType = "unknown";
		   this.username = "unknown";
	   }
	   //System.out.println("meh: " + a1.getUserList().get(0).getUsername());
   }

   public void deleteAccount() {
	   if(a1.getUserList().contains(this)) {
		   a1.getUserList().remove(this);
		   email = "unknown";
		   password = "unknown";
		   username = "unknown";
		   accountType = "unknown";
	       accountBalance = 0.0;
	   }
	   else {
		   System.out.println("User does not exist");
	   }
   }

   protected void login() {
   }

   protected void logout() {
   }
}

