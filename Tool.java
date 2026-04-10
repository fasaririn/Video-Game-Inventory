class Tool extends Item {
    private int duration;
    
    public Tool(String name, int amount, int duration){
        super(name, amount);
        this.duration = duration;
    }
    
    @Override
    public void use(){
        if (duration > 0){
            duration--;
            if (duration == 0){
                System.out.println(name + " broke...");
            }else{
                System.out.println("Used " + name + ", remaining duration: " + duration);
            }
        }else{
            System.out.println(name + " is broken");
        }
    }
    
    @Override
    public void displayInfo(){
        System.out.println(
        name + " (Tool) x" + amount + ", Duration: " + duration);
    }
    
}
