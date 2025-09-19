import java.util.Scanner;

public class MainMenuApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Order order = new Order(50); // store up to 50 items
        int choice;

        // Add some Flipkart test data
        order.addItem(new Item(101, "iPhone 16 Pro", 139999));
        order.addItem(new Item(102, "MacBook Air M4", 99999));
        order.addItem(new Item(103, "Samsung Galaxy S25", 79999));
        order.addItem(new Item(104, "Nike Shoes", 5999));
        order.addItem(new Item(105, "Levi's Jeans", 2999));

        do {
            IO.println("\n==== Flipkart Order Management ====");
            IO.println("1. Add Product");
            IO.println("2. View All Products");
            IO.println("3. Update Product");
            IO.println("4. Delete Product");
            IO.println("5. Search Product by Name");
            IO.println("6. Sort Products by Name");
            IO.println("7. Sort Products by Price");
            IO.println("0. Exit");
            IO.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    IO.print("Enter Product ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    IO.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    IO.print("Enter Price: ");
                    double price = sc.nextDouble();
                    order.addItem(new Item(id, name, price));
                    IO.println("Product added successfully.");
                    break;
                case 2:
                    IO.println("--- All Products ---");
                    order.viewItems();
                    break;
                case 3:
                    IO.print("Enter Product ID to update: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    IO.print("Enter new Name: ");
                    String newName = sc.nextLine();
                    IO.print("Enter new Price: ");
                    double newPrice = sc.nextDouble();
                    order.updateItem(uid, newName, newPrice);
                    IO.println("Product updated.");
                    break;
                case 4:
                    IO.print("Enter Product ID to delete: ");
                    int did = sc.nextInt();
                    order.deleteItem(did);
                    IO.println("Product deleted.");
                    break;
                case 5:
                    IO.print("Enter Product Name to search: ");
                    String sname = sc.nextLine();
                    Item found = order.searchItem(sname);
                    if (found != null) {
                        IO.println("Found: " + found);
                    } else {
                        IO.println("Product not found.");
                    }
                    break;
                case 6:
                    IO.println("--- Products Sorted by Name ---");
                    Item[] listName = order.getAllItems();
                    SortByName.sort(listName);
                    for (Item it : listName) IO.println(it.toString());
                    break;
                case 7:
                    IO.println("--- Products Sorted by Price ---");
                    Item[] listPrice = order.getAllItems();
                    SortByPrice.sort(listPrice);
                    for (Item it : listPrice) IO.println(it.toString());
                    break;
                case 0:
                    IO.println("Exiting...");
                    break;
                default:
                    IO.println("Invalid choice!");
            }
        } while(choice != 0);

        sc.close();
    }
}
