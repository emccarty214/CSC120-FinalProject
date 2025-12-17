/**
 * A class that simulates a hammer object.
 */
public class Hammer extends Item{


    /**
     * A basic constructor for the hammer class
     */
    public Hammer(){
        super();
    }

    /**
     * A full constructor for the hammer class
     * @param name
     * @param description
     */
    public Hammer(String name, String description){
        super(name, description, true);
    }

    /**
     * Prints out a statement of what occures whenever someone tries to use this hammer.
     */
    public void use(){
        System.out.println("You swing the hammer around, it does nothing at the moment");
    }
    
}
