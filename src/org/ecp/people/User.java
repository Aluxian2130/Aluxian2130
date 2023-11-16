package org.ecp.people;

import java.util.Scanner;

import org.ecp.items.Product;
import org.ecp.system.Admin;

public abstract class User {
   protected String email = "unknown";
   protected String password = "unknown";
   protected String username;
   protected double accountBalance;
   private Admin a1 = new Admin();

   public User() {
	   email = "unknown";
	   password = "unknown";
	   username = "unknown";
       accountBalance = 0.0;
       this.createAccount();
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
   
   public Boolean emailMismatch(User u1) {
	   for(User x: a1.getUserList()) {
		   if(x.getEmail().equals(u1.getEmail()) || x.getUsername().equals(u1.getUsername())) {
			   System.out.println("Email or username already exists.");
			   return true;
		   }
	   }
	   return false;
   }
   
   public void createAccount() {
	   
	   System.out.println("Enter email: ");
	   Scanner myObj = new Scanner(System.in);
	   this.email = myObj.nextLine();
	   
	   System.out.println("Enter username: ");
	   this.username = myObj.nextLine();
	   
	   System.out.println("Enter password: ");
	   this.password = myObj.nextLine();
	   
	   //System.out.println("ADDED");
	   //if(this.emailMismatch(this) != false) {
	   if(a1.detectSignupConflict(email, username, password) == false) {
		   a1.getUserList().add(this);
	   }
	   else {
		   this.email = "unknown";
		   this.password = "unknown";
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

