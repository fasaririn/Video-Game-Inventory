public abstract class Item {

    // attributes
    protected String name;
    protected int amount;

    // constructor
    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    // getter
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    // setter
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public abstract void use();

    public void displayInfo() {
        System.out.print("Name: " + name + " | Amount: " + amount);
    }

}

