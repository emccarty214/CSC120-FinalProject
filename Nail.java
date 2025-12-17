/**
 * A class that simulates a nail item.
 */
public class Nail extends Item{


    /**
     * A basic constructor for the nail class.
     */
    public Nail(){
        super();
    }

    /**
     * A full constructor for the nail class.
     * @param name the name of the nail
     * @param description a description of the nail
     */
    public Nail(String name, String description){
        super(name, description, true);
    }

    /**
     * Prints out a statement of what occures whenever someone tries to use this nail.
     */
    public void use(){
        System.out.println("You take a look at the nail in your hand. You think it could help you fix your boat.");
    }
    
}