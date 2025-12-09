public class Boat extends Item{

    private int sticksForSuccess;
    private Boolean isCompleted;
    public Boat(){
        super("UNKNOWN", "UNKNOWN", false);
        this.isCompleted = false;
        this.sticksForSuccess = 0;
    }

    public Boat(String name, String description, int sticksForSuccess){
        super(name, description, false);
        this.isCompleted = false;
        this.sticksForSuccess = sticksForSuccess;
    }

    public void use(){
       System.out.println("You take a good look at the " +this.getName()+ ". You think you need " + sticksForSuccess + " sticks to fix it.");
    }

    /* Some code */


}
