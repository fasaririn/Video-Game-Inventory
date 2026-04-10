class Food extends Item {
    private int health;

    public Food(String name, int amount, int health) {
        super(name, amount);
        this.health = health;
    }

    @Override
    public void use() {
        if (amount > 0) {
            amount--;
            System.out.println("Used " + name + ", restored " + health + " health.");
        } else {
            System.out.println("No " + name + " left to use.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " (Food) x" + amount + ", Health: +" + health);
    }
}
