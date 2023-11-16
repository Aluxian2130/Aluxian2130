package org.ecp.test.Driver_Files;

import org.ecp.items.Product;
import org.ecp.people.Customer;
import org.ecp.people.Seller;
import org.ecp.system.Admin;

public class TestAll {

    public static void main(String[] args) {

        // TestCustomer
        Customer customer = new Customer();
        Admin.setMaxLimit(100.0);
        customer.setAccountBalance(80.0);
        System.out.println("Adding Funds.......");
        customer.addFunds(5.0);
        customer.addFunds(50.0);
        Product product1 = new Product("Product A", 10.0, 1);
        Product product2 = new Product("Product B", 15.0, 1);
        Product product3 = new Product("Product C", 20.0, 1);
        customer.addProduct(product1);
        customer.addProduct(product2);
        customer.addProduct(product3);
        customer.removeProduct(product2);
        customer.setAddress("2402 Water St");
        System.out.println("Customer Information:");
        System.out.println("Username: " + customer.getUsername());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Account Balance: $" + customer.getAccountBalance());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("\nShopping Cart:");
        for (Product product : customer.getShoppingCart()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - Quantity: " + product.getQuantity());
        }

        // TestSeller
        Seller s1 = new Seller();
        Product p1 = new Product();
        s1.addProduct();
        s1.addProduct();
        System.out.println("Detect error if seller attempts to add more products than defined maximum product amount.");
        s1.addProduct();
        s1.printProductList();
        s1.beginRemoveProduct();
        s1.printProductList();
        s1.beginUpdateProduct();
        s1.printProductList();


        // TestUser
        System.out.println("Creating sellers: ");
        Seller s2 = new Seller();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();
        System.out.println("Sellers present in system: ");
        Admin.printSellers();
        System.out.println("Customers present in system: ");
        Admin.printCustomers();
        System.out.println("Users present in system: ");
        Admin.printUsers();
        System.out.println("Deleting customer account");
        c2.deleteAccount();
        System.out.println("Deleting seller account");
        s2.deleteAccount();
        System.out.println("Print user list: ");
        Admin.printUsers();
    }
}
