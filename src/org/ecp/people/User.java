package org.ecp.people;

public abstract class User {
   protected String email = "unknown";
   protected String password = "unknown";
   protected String username;
   protected double accountBalance;

   User() {
	   email = "unknown";
	   password = "unknown";
	   username = "unknown";
       accountBalance = 0.0;
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

   public void createAccount() {
	   
   }

   protected void deleteAccount() {
	   
   }

   protected void login() {
   }

   protected void logout() {
   }
   
}

