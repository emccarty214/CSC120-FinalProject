/**
 * An abstract class that simulates the properties of a general item.
 */
public abstract class Item{

    private String name; //name of the item
    private String description; //description of the item
    private boolean isCollectable; //whether or not the item is collectable

    /**
     * A basic constructor for the item class
     */
    public Item(){
        this.name = "UNKNOWN";
        this.description = "UNKNOWN";
        this.isCollectable = true;
    }

    /**
     * A full constructor for the item class
     * @param name the name of the item
     * @param description a description of the item
     * @param isCollectable whether or not the item is collectable
     */
    public Item(String name, String description, boolean isCollectable){
        this.name = name;
        this.description = description;
        this.isCollectable = isCollectable;
    }

    /**
     * Prints out the description of this item
     */
    public void describe(){
        System.out.println(this.name + ": " + this.description);
    }

    /**
     * gets the name of this item
     * @return the name of this item as a String
     */
    public String getName() {
        return this.name;
    }

    /**
     * gets whether this item is collectable or not
     * @return a boolean of if this item is collectable
     */
    public boolean getCollectable() {
        return this.isCollectable;
    } 

    /**
     * Prints out a message
     */
    public abstract void use();

}