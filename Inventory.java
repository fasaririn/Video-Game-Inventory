import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Inventory {
    private ArrayList<Item> items;
    private String filename = "inventory.txt";

    public Inventory() {
        items = new ArrayList<>();
    }

    public void viewInventory() {
        if (items.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (int i = 0; i < items.size(); i++) {
                System.out.print("[" + i + "]");
                items.get(i).displayInfo();
            }
        }
    }

     public void createAndAddItem(Scanner scanner) {
        System.out.print("Enter Item Type (Potion/Tool/Food): ");
        String type = scanner.nextLine();
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Item Amount: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // clear newline after nextInt()

        if (type.equalsIgnoreCase("Potion")) {
            System.out.print("Enter Special Ability: ");
            String specialAbility = scanner.nextLine();
            Item potion = new Potion(name, amount, specialAbility);
            addItem(potion);

        } else if (type.equalsIgnoreCase("Tool")) {
            System.out.print("Enter Tool Durability: ");
            int durability = scanner.nextInt();
            scanner.nextLine();
            Item tool = new Tool(name, amount, durability);
            addItem(tool);

        } else if (type.equalsIgnoreCase("Food")) {
            System.out.print("Enter Health Restoration Value: ");
            int health = scanner.nextInt();
            scanner.nextLine();
            Item food = new Food(name, amount, health);
            addItem(food);

        } else {
            System.out.println("Invalid Item Type.");
            return;
        }

        System.out.println("Item added successfully!");
    }

    
    public void addItem(Item item) {
        items.add(item);
        saveToFile();
    }

    public void deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            deleteFromFile(index);
            //saveToFile();
        } else {
            System.out.println("Invalid index.");
        }
    }
    
    public void useItem(int index) {
        if (index >= 0 && index < items.size()) {
            Item item = items.get(index);

            item.use();

            if (item.getAmount() <= 0) {
                System.out.println(item.getName() + " has been used up and removed from the inventory.");
                items.remove(index);
            }

            saveToFile();
        } else {
            System.out.println("Invalid index.");
        }
}


    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Item item : items) {
                writer.write(item.getName() + "," + item.getAmount());
                writer.newLine();
            }
            System.out.println("Inventory saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    public void deleteFromFile(int index) {
        try {
            File inputFile = new File(filename);
            if (!inputFile.exists()) {
                System.out.println("Inventory file does not exist.");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            if (index < 0 || index >= lines.size()) {
                System.out.println("Invalid index. Cannot delete item from file.");
                return;
            }

            lines.remove(index);

            BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            System.out.println("Item deleted from file successfully.");

        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}



