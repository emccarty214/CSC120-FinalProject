import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Note from Claire: When we are creating sticks, as repetitive as it may be, we should create
    //multiple stick objects instead of using the same ones. As if we use the same one, it will
    //be the same item in memory and any changes we make to it will affect all the times its referenced

    // Note from Claire: We might need to add addAdjLocation() to Location so we can intialize
    // everything properly


    //This is where our game loop will go.

    //Main things to work on here are:
        // Initializing all game elements and setting up the map
        // Creating the game loop
        // Handline user input within the game loop
        // Setting up the game structure itself
        // Testing the game


    // For setting up the game structure:
        // Once all locations are initialized and set the main goals for the player are:
            // Explore Island
            // Collect all Sticks
            // Use Sticks on Boat to escape
        // Some possible dialogue options are
            // You picked up a STICK! You have x STICKS left to collect!
            // You wake up with a start. You're lying on a beach, stranded. You stand up, wiping
                // the sand from your clothes and look around. You see that your BOAT 
                // is lying on the beach about 100 yards from you, and there is a Jungle to the South.
            // The Jungle around you is thick with vines. Only a little sunlights makes its way
                // through the dense foliage. When you look around, you see 1 STICK on the ground,
                // and a possible path in all four cardinal directions.
            // The Jungle around you is not very thick. There are some flowers scattered about, and
                // you hear the sounds of some birds squawking. When you look around, you see 2 STICKS 
                // on the ground, and a possible path to the South and East.
        // There is more that needs to be written, this is just to give us an idea of some location
            // descriptions and how we might want to format things

    public static void main(String[] args) {
        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        Stick stick1 = new Stick("A bendy stick", "This is a bendy stick, you can pick it up if you want.");
        Location beach = new Location("North beach", "TO DO : FILL IN - NORTH BEACH", new Coordinate(0,0), new ArrayList<Item>(), new ArrayList<Lcoation>());

        // This could be replaced with a more interesting opening
        System.out.println("******************");
        System.out.println("WELCOME TO THE GAME"); //Figure out how to format dialogue better
        System.out.println("You wake up with a start. You're lying on a beach, stranded. You stand up, wiping the sand from your clothes and look around. You see that your BOAT is lying on the beach about 100 yards from you, and there is a Jungle to the South.");
        System.out.println("******************");

        // Instructions are sometimes helpful
        System.out.println("Enter WIN to win, LOSE to lose, anything else to continue playing.");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("You are still playing. Follow the instructions if you want to win/lose...");
            userResponse = userInput.nextLine().toUpperCase();

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("WIN") || userResponse.equals("LOSE")) {
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (userResponse.equals("WIN")) {
            System.out.println("Win Statement: ToDo Replace");
        } else { // userResponse.equals("LOSE")
            System.out.println("Fail Statement: ToDo Replace");
        }
    }

    
}
