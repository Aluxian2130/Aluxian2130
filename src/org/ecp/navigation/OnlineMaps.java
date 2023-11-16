package org.ecp.navigation;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineMaps {
	private static ArrayList<String> addressList = new ArrayList<String>();

   public OnlineMaps() {
      addressList = new ArrayList<String>();
      for (int i = 1; i <= 5; i++) {
         addressList.add("PO Box " + i);
      }
   }

   public static void addAddress(String address) {
      OnlineMaps.addressList.add(address);
   }
   
   public static void setAddressList(ArrayList<String> addresses) {
	      OnlineMaps.addressList = addresses;
   }
   
   public void enterAddress() {
	   System.out.println("Enter address to add to OnlineMaps list: ");
       Scanner myObj = new Scanner(System.in);
       String address = myObj.nextLine();
       addAddress(address);
   }
   
   public void initAddressList() {
	   System.out.println("Enter number of addresses to add: ");
       Scanner myObj = new Scanner(System.in);
       Integer num = myObj.nextInt();
       System.out.println("Start entering addresses: ");
       for (Integer i = 0; i < num; i++) {
    	   Scanner myObj2 = new Scanner(System.in);
           String address = myObj.nextLine();
    	   OnlineMaps.addAddress(address);
       }
   }
   
   public static void removeAddress() {
	   System.out.println("Enter an address to remove: ");
	   Scanner myObj = new Scanner(System.in);
       String address = myObj.nextLine();
       if (OnlineMaps.addressList.contains(address)) {
		   OnlineMaps.addressList.remove(address);
	   }
	   else {
		   System.out.println("This address does not exist.");
	   }
	   
   }
   
   public static void printAddressList() {
	   Integer numAddr = addressList.size();
	   for (Integer i = 0; i < numAddr; i++) {
		   if (i == numAddr - 1) { System.out.println(addressList.get(i)); }
		   else {System.out.println(addressList.get(i) + ",");}
	   }
   }
   

   public ArrayList<String> getAddressList() {
      return addressList;
   }
}
