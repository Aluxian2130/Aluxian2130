package org.ecp.navigation;

import java.util.ArrayList;

public class OnlineMaps {
   private ArrayList<String> addressList;

   public OnlineMaps() {
      addressList = new ArrayList<String>();
      for (int i = 1; i <= 5; i++) {
         addressList.add("PO Box " + i);
      }
   }

   public void setAddressList(String address) {
      this.addressList.add(address);
   }

   public ArrayList<String> getAddressList() {
      return addressList;
   }
}
