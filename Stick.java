/**
 * A class that simulates a stick item.
 */
public class Stick extends Item{


    /**
     * A general constructor for the Stick class
     */
    public Stick(){
        super();
    }

    /**
     * A full constructor for the stick class
     * @param name the name of the stick
     * @param description a description of the stick
     */
    public Stick(String name, String description){
        super(name, description, true);
    }

    /**
     * Prints out a statement of what occures whenever someone tries to use this stick.
     */
    public void use(){
        System.out.println("You take a look at the stick in your hand. You think it could help you fix your boat.");
    }
    
}
