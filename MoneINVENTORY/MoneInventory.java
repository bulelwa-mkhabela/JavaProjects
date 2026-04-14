import javax.swing.JOptionPane;
/**
 * The MoneInventory class represents a single product in the inventory system=]\\
 * It provides functionality to add/remove stock and display product information.
 */
public class MoneInventory {
    //Private instance variables
    private String productName;
    private int productID;
    private int stockQuantity;

    // Constructer that initialises values when product is creataed
    public MoneInventory(String productName, int productID, int stockQuantity) {
        this.productName = productName;
        this.productID = productID;
        this.stockQuantity = stockQuantity;
    }

    // Add stock
    public void addStock(int quantity) {
        if (quantity > 0) {
            stockQuantity += quantity;
            JOptionPane.showMessageDialog(null, "Stock added successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid quantity. Must be positive.");
        }
    }

    // Remove stock
    public void removeStock(int quantity) {
        if (quantity > 0 && quantity <= stockQuantity) {
            stockQuantity -= quantity;
            JOptionPane.showMessageDialog(null, "Stock removed successfully!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid quantity. Not enough stock or negative input.");
        }
    }

    // Display product information
    public void displayInfo() {
        JOptionPane.showMessageDialog(null,
                "Product Name: " + productName +
                "\nProduct ID: " + productID +
                "\nStock Quantity: " + stockQuantity);
    }

    // Main method
    public static void main(String[] args) {
        MoneInventory[] products = {
            new MoneInventory("Protein Powder", 101, 50),
            new MoneInventory("Stationary Bike", 102, 30),
            new MoneInventory("Treadmill", 103, 20)
        };

        while (true) {
            String[] options = {"Add Stock", "Remove Stock", "Display Info", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an action:", "Inventory Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 3 || choice == JOptionPane.CLOSED_OPTION) {
                break; // Exit
            }

            // Select product
            StringBuilder productList = new StringBuilder("Select a product:\n");
            for (int i = 0; i < products.length; i++) {
                productList.append(i).append(": ").append(products[i].productName).append("\n");
            }

            int productIndex;
            try {
                productIndex = Integer.parseInt(JOptionPane.showInputDialog(productList.toString()));
                if (productIndex < 0 || productIndex >= products.length) {
                    JOptionPane.showMessageDialog(null, "Invalid product selection.");
                    continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input.");
                continue;
            }

            MoneInventory selectedProduct = products[productIndex];

            switch (choice) {
                case 0: // Add Stock
                    try {
                        int qtyToAdd = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to add:"));
                        selectedProduct.addStock(qtyToAdd);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }
                    break;

                case 1: // Remove Stock
                    try {
                        int qtyToRemove = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity to remove:"));
                        selectedProduct.removeStock(qtyToRemove);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input.");
                    }
                    break;

                case 2: // Display Info
                    selectedProduct.displayInfo();
                    break;
            }
        }
    }
}
