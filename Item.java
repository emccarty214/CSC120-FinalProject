public abstract class Item{

    private String name;
    private String description;

    public Item(){
        this.name = "UNKNOWN";
        this.description = "UNKNOWN";
    }

    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void describe(){
        System.out.println(this.name + ": " + this.description);
    }

    public String getName() {
        return this.name;
    }

    public abstract void use();
}