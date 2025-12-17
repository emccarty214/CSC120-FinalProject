/**
 * A Class that simulates a broken boat.
 */
public class Boat extends Item{

    private int sticksForSuccess; //the number of sticks required to fix the boat
    private int nailsForSuccess; // the number of nails required to fix the boat
    private int hammersForSuccess; // the number of hammers required to fix the boat
    
    /**
     * A basic constructor for the boat class.
     */
    public Boat(){
        super("UNKNOWN", "UNKNOWN", false);
        
        this.sticksForSuccess = 0;
        this.nailsForSuccess = 0;
        this.hammersForSuccess =0;
    }

    /**
     * A full constructor for the boat class.
     * @param name the name of the boat
     * @param description a description of the boat
     * @param sticksForSuccess how many sticks are needed to fix the boat
     * @param nailsForSuccess how many nails are needed to fix the boat
     * @param hammersForSuccess how many hammers are needed to fix the boat
     */
    public Boat(String name, String description, int sticksForSuccess, int nailsForSuccess, int hammersForSuccess){
        super(name, description, false);
        
        this.sticksForSuccess = sticksForSuccess;
        this.nailsForSuccess = nailsForSuccess;
        this.hammersForSuccess = hammersForSuccess;
    }

    /**
     * Prints out a statement of what the boat needs in total to be fixed.
     */
    public void use(){
       System.out.println("You take a good look at the " +this.getName()+ ". You think you need in total " + sticksForSuccess + " sticks, " + nailsForSuccess + " nails, and " + hammersForSuccess + " hammers to fix it.");
    }

    


}
