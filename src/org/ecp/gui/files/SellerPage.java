package org.ecp.gui.files;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import org.ecp.items.Product;
import org.ecp.people.Seller;

public class SellerPage {
    private JFrame frame = new JFrame();
    private JLabel title = new JLabel("E-Commerce Platform");
    private JLabel header = new JLabel("Welcome Seller!");
    private JButton addProductBtn = new JButton("Add Product");
    private JButton removeProductBtn = new JButton("Remove Product");
    private JButton viewProductListBtn = new JButton("View Product List");

    private List<Product> productList = new ArrayList<>();

    public SellerPage(Seller s_1) {
        title.setBounds(30, 10, 300, 30);
        title.setFont(new Font("serif", Font.BOLD, 25));
        title.setForeground(new Color(211, 84, 0));
        header.setBounds(40, 60, 200, 35);
        header.setFont(new Font("serif", Font.BOLD, 15));
        header.setForeground(new Color(225, 246, 76));

        addProductBtn.setBounds(150, 110, 200, 30);
        removeProductBtn.setBounds(150, 160, 200, 30);
        viewProductListBtn.setBounds(150, 210, 200, 30);

        addProductBtn.addActionListener(this::handleAddProduct);
        removeProductBtn.addActionListener(this::handleRemoveProduct);
        viewProductListBtn.addActionListener(this::handleViewProductList);

        frame.add(header);
        frame.add(title);
        frame.add(addProductBtn);
        frame.add(removeProductBtn);
        frame.add(viewProductListBtn);

        frame.getContentPane().setBackground(new Color(40, 55, 71));
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private void handleAddProduct(ActionEvent e) {
        JFrame addProductFrame = new JFrame("Add Product");
        addProductFrame.setSize(400, 300);

        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField quantityField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add Product",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText());
            int quantity = Integer.parseInt(quantityField.getText());

            if (!name.isEmpty() && !description.isEmpty()) {
                Product newProduct = new Product(name, price, quantity);
                newProduct.setDescription(description);
                productList.add(newProduct);
                JOptionPane.showMessageDialog(frame, "Product added successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please provide valid information!");
            }
        }
    }

    private void handleRemoveProduct(ActionEvent e) {
        String name = JOptionPane.showInputDialog(frame, "Enter Product Name to Remove:");

        for (Product product : productList) {
            if (product.getName().equalsIgnoreCase(name)) {
                productList.remove(product);
                JOptionPane.showMessageDialog(frame, "Product removed successfully!");
                return;
            }
        }
        JOptionPane.showMessageDialog(frame, "Product not found!");
    }

    private void handleViewProductList(ActionEvent e) {
        StringBuilder products = new StringBuilder("Product List:\n");
        for (Product product : productList) {
            products.append(product.getName()).append(" - $").append(product.getPrice()).append("\n");
        }
        JOptionPane.showMessageDialog(frame, products.toString());
    }
}
//    public static void main(String[] args) {
//        new SellerPage();
//    }
//}
