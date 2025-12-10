public class Nail extends Item{


    public Nail(){
        super();
    }

    public Nail(String name, String description){
        super(name, description, true);
    }

    public void use(){
        System.out.println("You take a look at the nail in your hand. You think it could help you fix your boat.");
    }
    
}