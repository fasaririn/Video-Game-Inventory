class Potion extends Item {
    private String specialAbility;

    public Potion(String name, int amount, String specialAbility) {
        super(name, amount);
        this.specialAbility = specialAbility;
    }

    @Override
    public void use() {
        if (amount > 0) {
            amount--;
            System.out.println("Used " + name + ", special ability activated: " + specialAbility);
            
        } else {
            System.out.println("No " + name + " potions left to use.");
        }
       
    }

    @Override
    public void displayInfo() {
        System.out.println(
                name + " (Potion) x" + amount + ", Ability: " + specialAbility);
    }
}
