package org.ecp.navigation;

import java.util.ArrayList;

public class OnlineMaps {
   private ArrayList<String> addressList;

   OnlineMaps() {
	   addressList = new ArrayList<String>();
   }

   public void setAddressList(String address) {
      this.addressList.add(address);
   }

   public ArrayList<String> getAddressList() {
      return addressList;
   }
}