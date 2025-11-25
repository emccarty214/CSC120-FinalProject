public class Item{

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
        System.out.println("");
    }
}