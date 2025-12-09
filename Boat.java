public class Boat extends Item{

    private Boolean isCompleted;
    public Boat(){
        super("UNKNOWN", "UNKNOWN", false);
        this.isCompleted = false;
    }

    public Boat(String name, String description){
        super(name, description, false);
        this.isCompleted = false;
    }

    public void use(){

    }

    /* Some code */


}
