public abstract class Item{

    private String name;
    private String description;
    protected boolean isCollectable;

    public Item(){
        this.name = "UNKNOWN";
        this.description = "UNKNOWN";
        this.isCollectable = true;
    }

    public Item(String name, String description, boolean isCollectable){
        this.name = name;
        this.description = description;
        this.isCollectable = isCollectable;
    }

    public void describe(){
        System.out.println(this.name + ": " + this.description);
    }

    public String getName() {
        return this.name;
    }

    public abstract void use();

}