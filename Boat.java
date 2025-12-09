public class Boat extends Item{

    private Boolean isCompleted;
    public Boat(){
        super();
        this.isCompleted = false;
        super.isCollectable = false;
    }

    public Boat(String name, String description){
        super(name, description, false);
        this.isCompleted = false;
    }

    public void use(){

    }

    /* Some code */


}
