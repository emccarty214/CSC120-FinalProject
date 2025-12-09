import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Note from Claire: When we are creating sticks, as repetitive as it may be, we should create
    //multiple stick objects instead of using the same ones. As if we use the same one, it will
    //be the same item in memory and any changes we make to it will affect all the times its referenced

    // Note from Claire: We might need to add addAdjLocation() to Location so we can intialize
    // everything properly
    // take ArrayList<Location> adjacentLocations out of constructer and add some add and remove methods for it instead

    // For Location Class add a printAdjLocations method


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

        //Make sure this number is less than or equal to the total number of sticks on the map
        int sticksForSuccess = 2;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        //Beach items
        Stick stick1 = new Stick("BENDY STICK", "This is a bendy stick, you can pick it up if you want.");
        Boat boat = new Boat("OLD BOAT", "A rickety old boat. You see that there is a hole \nin its side. Maybe you can fix it?");

        //Jungle1 Items
        Stick stick2 = new Stick("BIG STICK", "This is a big stick, you can pick it up if you want");
        Stick stick3 = new Stick("GREEN STICK", "This is a green stick, you can pick it up if you want");
        
        // Jungle 2 Items
        Stick stick4 = new Stick("COOL STICK", "This is a really cool stick, you can pick it up if you want");

        // Jungle 3 Items
        // nothing

        // Jungle 4 Items
        Stick stick5 = new Stick("RED STICK", "This is a red stick, you can pick it up if you want");
        Stick stick6 = new Stick("FRAGILE STICK", "This is a fragile stick, you can pick it up if you want. Don't break it!");

        // Jungle 5 Items
        Stick stick7 = new Stick("RAINBOW STICK", "This is a rainbow stick, you can pick it up if you want");

        // Villiage Items
        Hammer hammer = new Hammer("THE HAMMER", "This is the hammer. You might need it.");
        Nail nail1 = new Nail("RUSTY NAIL", "This is a rusty nail. Do you have your tetanus shot!? You can pick it up (at your own risk)");
        Nail nail2 = new Nail("FANCY NAIL", "This is a fancy nail. You can pick it up if you want");

        // Sount Beach Items
        Nail nail3 = new Nail("LONG NAIL", "This is a long nail. You can pick it up if you want");


        //Creating map
        Location northBeach = new Location("North Beach", "You are standing on a nice sandy Beach, there is a lighthouse in the distance", new Coordinate(0,0), new ArrayList<Item>());
        Location jungle1 = new Location("Jungle", "You are standing in a thick Jungle, there are paths in all directions", new Coordinate(0,-1), new ArrayList<Item>());

        northBeach.addItem(stick1);
        northBeach.addItem(boat);

        jungle1.addItem(stick2);

        northBeach.addLocation(jungle1);
        jungle1.addLocation(northBeach);


        MainCharacter mc= new MainCharacter(northBeach);

        // This could be replaced with a more interesting opening
        System.out.println("******************");
        System.out.println("WELCOME TO THE GAME"); //Figure out how to format dialogue better
        System.out.println("You wake up with a start. You're lying on a beach, stranded. \nYou stand up, wiping the sand from your clothes and look around. \nYou see that your BOAT is lying on the beach about 100 yards from you, \nand there is a Jungle to the South.");
        System.out.println("******************");

        // Instructions are sometimes helpful
        System.out.println("Feel free to WALK around, LOOK AT, or PICK UP things.");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("What would you like to do?");
            try {
                userResponse = parseInput(userInput.nextLine().toUpperCase());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue; // has them try again
            }
            

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("north") || userResponse.equals("south") || userResponse.equals("east") || userResponse.equals("west")) {
                try {
                    mc.move(userResponse);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (userResponse.equals("look around")){
                mc.currentLocation.describe();
            } else if (userResponse.equals("look at")){
                System.out.println("What would you like to look at? Your options are: \n Inventory:");
                mc.printInventory();
                System.out.println(" Or in your surroundings: ");
                mc.currentLocation.printItems();
                try {
                    userResponse = userInput.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue; // has them try again
                }
                boolean itemDescribed = false;
                for (Item i : mc.inventory){
                    if (userResponse.contains(i.getName())){
                        i.describe();
                        itemDescribed = true;
                        break; //exits this for loop
                    }
                }
                for (Item i : mc.currentLocation.getItems()){
                    if (userResponse.contains(i.getName())){
                        i.describe();
                        itemDescribed = true;
                        break; //exits this for loop
                    }
                }
                if (itemDescribed == false){
                    System.out.println("Sorry, I don't understand.");
                }
            } else if (userResponse.equals("pick up")){
                System.out.println("What would you like to pick up? Around you there are: ");
                mc.currentLocation.printItems();
                try {
                    userResponse = userInput.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue; // has them try again
                }
                boolean itemSearched = false;
                
                for (Item i : mc.currentLocation.getItems()){
                    if (userResponse.contains(i.getName())){
                        try {
                            mc.collect(i);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        itemSearched = true;
                        break; //exits this for loop
                    }
                }
                if (itemSearched == false){
                    System.out.println("Sorry, I don't understand.");
                }
            } else if (userResponse.equals("drop")){
                System.out.println("What would you like to look at? Your options are: \n Inventory:");
                mc.printInventory();
                try {
                    userResponse = userInput.nextLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue; // has them try again
                }
                boolean itemDropped = false;
                for (Item i : mc.inventory){
                    if (userResponse.contains(i.getName())){
                        mc.drop(i);
                        itemDropped = true;
                        break; //exits this for loop
                    }
                }
                if (itemDropped == false){
                    System.out.println("Sorry, I don't understand.");
                }
            }

            if(mc.numSticks >=sticksForSuccess){
                stillPlaying = false;
            }
        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (mc.numSticks >=2) {
            System.out.println("You won! You collected enough sticks to escape the island");
        } else { // userResponse.equals("LOSE")
            System.out.println("Fail Statement: ToDo Replace");
        }


    }

    private static String parseInput(String str){
        String input = " " + str + " ";
        if(input.contains(" MOVE ") || input.contains(" WALK ") || input.contains(" RUN ") || input.contains(" GO ")) {
            if(input.contains("NORTH")) {
                return "north";
            } else if (input.contains("SOUTH")){
                return "south";
            } else if (input.contains("EAST")){
                return "east";
            } else if (input.contains("WEST")){
                return "west";
            } else {
                throw new RuntimeException("Not a valid direction, please try again.");
            }
        } else if (input.contains(" LOOK AROUND ")){
            return "look around";
        } else if (input.contains(" LOOK AT ")){
            return "look at";
        } else if (input.contains(" PICK UP ")){
            return "pick up";
        } else if (input.contains(" DROP ")){
            return "drop";
        } else {
            throw new RuntimeException("I don't understand what you are trying to do. Please try again.");
        }
    }

    
}
