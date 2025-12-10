public class Stick extends Item{


    public Stick(){
        super();
    }

    public Stick(String name, String description){
        super(name, description, true);
    }

    public void use(){
        System.out.println("You take a look at the stick in your hand. You think it could help you fix your boat.");
    }
    
}
