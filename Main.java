import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        do {
            System.out.println("====== Video Game Inventory System ======");
            System.out.println("[1] View Inventory");
            System.out.println("[2] Add Item");
            System.out.println("[3] Delete Item");
            System.out.println("[4] Use Item");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;

                case 2:
                    inventory.createAndAddItem(scanner);
                    break;

                case 3:
                    System.out.println("Enter Item Index to Delete: ");
                    inventory.viewInventory();
                    System.out.print("Item Index: ");
                    int delIndex = scanner.nextInt();
                    inventory.deleteItem(delIndex); 
                    break;

                case 4:
                    System.out.println("Enter Item Index to Use: ");
                    inventory.viewInventory();
                    System.out.print("Item Index: ");
                    int useIndex = scanner.nextInt();
                    inventory.useItem(useIndex);
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (true);
    }
}



