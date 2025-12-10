public class Boat extends Item{

    private int sticksForSuccess;
    private int nailsForSuccess;
    private int hammersForSuccess;
    //private Boolean isCompleted;
    public Boat(){
        super("UNKNOWN", "UNKNOWN", false);
        //this.isCompleted = false;
        this.sticksForSuccess = 0;
    }

    public Boat(String name, String description, int sticksForSuccess, int nailsForSuccess, int hammersForSuccess){
        super(name, description, false);
        //this.isCompleted = false;
        this.sticksForSuccess = sticksForSuccess;
        this.nailsForSuccess = nailsForSuccess;
        this.hammersForSuccess = hammersForSuccess;
    }

    public void use(){
       System.out.println("You take a good look at the " +this.getName()+ ". You think you need in total " + sticksForSuccess + " sticks, " + nailsForSuccess + " nails, and " + hammersForSuccess + " hammers to fix it.");
    }

    /* Some code */


}
