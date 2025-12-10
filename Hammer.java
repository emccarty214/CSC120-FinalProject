public class Hammer extends Item{


    public Hammer(){
        super();
    }

    public Hammer(String name, String description){
        super(name, description, true);
    }

    public void use(){
        System.out.println("You swing the hammer around, it does nothing at the moment");
    }
    
}
