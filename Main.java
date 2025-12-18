import java.util.ArrayList;
import java.util.Scanner;

/**
 * The playable class. Contains the Game Loop. Press the play button to play our game!
 */
public class Main {

    

    public static void main(String[] args) {
        // This is a "flag" to let us know when the loop should end
        boolean stillPlaying = true;

        //Make sure this number is less than or equal to the total number of sticks on the map
        int sticksForSuccess = 6;
        //Make sure this number is less than or equal to the total number of nails on the map
        int nailsForSuccess = 3;
        //Make sure this number is less than or equal to the total number of hammers on the map
        int hammersForSuccess = 1;

        // We'll use this to get input from the user.
        Scanner userInput = new Scanner(System.in);

        // Storage for user's responses
        String userResponse = "";

        //current timer and timer max, this will count how many turns they have taken. If they take too many they lose
        int currentTime = 0;
        int timerMax= 40;

        boolean winOrLose = true;

        //Beach items
        Stick stick1 = new Stick("BENDY STICK", "This is a bendy stick, you can pick it up if you want.");
        Boat boat = new Boat("OLD BOAT", "A rickety old boat. You see that there is a hole \nin its side. Maybe you can fix it?", sticksForSuccess, nailsForSuccess,hammersForSuccess);

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

        // South Beach Items
        Nail nail3 = new Nail("LONG NAIL", "This is a long nail. You can pick it up if you want");


        //Creating map
        Location northBeach = new Location("North Beach", "You are standing on a nice sandy Beach, there is a lighthouse in the distance. There is a path to the South.", new Coordinate(3,4), new ArrayList<Item>());
        Location jungle1 = new Location("Jungle", "You are standing in a thick Jungle, there are paths in all directions", new Coordinate(3,3), new ArrayList<Item>());
        Location jungle2 = new Location("Jungle", "You are standing in a sparse Jungle, there are paths to the East and South", new Coordinate(2,3), new ArrayList<Item>());
        //Jungle 3 is adjacent to the village, but intentionally does not connect to it.
        Location jungle3 = new Location("Jungle", "You are standing in a thick Jungle, there is a path to the West", new Coordinate(4,3), new ArrayList<Item>());
        Location jungle4 = new Location("Jungle", "You are standing in a thick Jungle, there are paths to the East and North", new Coordinate(2,2), new ArrayList<Item>());
        Location jungle5 = new Location("Jungle", "You are standing in a thick Jungle, there are paths in all directions", new Coordinate(3,2), new ArrayList<Item>());
        
        Location village = new Location("Deserted Village", "You see a deserted village in front of you. There are a few decrepid houses, but no recent signs of life", new Coordinate(4,2), new ArrayList<Item>());
        Location southBeach =  new Location("South Beach", "You are standing on a very rocky Beach and you see the vast expanse of the ocean in front of you. There is a path to the North.", new Coordinate(3,1), new ArrayList<Item>());

        //Creating 2-D map
        ArrayList<Location> coordinateList = new ArrayList<Location>();
        coordinateList.add(northBeach);
        coordinateList.add(jungle1);
        coordinateList.add(jungle2);
        coordinateList.add(jungle3);
        coordinateList.add(jungle4);
        coordinateList.add(jungle5);
        coordinateList.add(village);
        coordinateList.add(southBeach);

        //Initiating 2-D map
        Map map = new Map(coordinateList);

        //Adding items to locations
        northBeach.addItem(stick1);
        northBeach.addItem(boat);

        jungle1.addItem(stick2);
        jungle1.addItem(stick3);

        jungle2.addItem(stick4);

        jungle4.addItem(stick5);
        jungle4.addItem(stick6);

        jungle5.addItem(stick7);

        village.addItem(hammer);
        village.addItem(nail1);
        village.addItem(nail2);

        southBeach.addItem(nail3);

        //Forming map, linking locations together
        northBeach.addLocation(jungle1);
        jungle1.addLocation(northBeach);

        jungle1.addLocation(jungle2);
        jungle2.addLocation(jungle1);

        jungle1.addLocation(jungle3);
        jungle3.addLocation(jungle1);

        jungle1.addLocation(jungle5);
        jungle5.addLocation(jungle1);

        jungle2.addLocation(jungle4);
        jungle4.addLocation(jungle2);

        jungle4.addLocation(jungle5);
        jungle5.addLocation(jungle4);

        jungle5.addLocation(village);
        village.addLocation(jungle5);

        jungle5.addLocation(southBeach);
        southBeach.addLocation(jungle5);


        MainCharacter mc= new MainCharacter(northBeach);

        // This could be replaced with a more interesting opening
        System.out.println("     *******************");
        System.out.println("\tWELCOME TO THE GAME"); 
        System.out.println("\tYou wake up with a start. You're lying on a beach, stranded. \n\tYou stand up, wiping the sand from your clothes and look around. \n\tYou see that your broken BOAT is lying on the beach about 100 yards from you, \n\tand there is a Jungle to the South.");
        System.out.println("\tThe sun is high in the sky... for now");
        System.out.println("     ******************");

        // Instructions are sometimes helpful
        System.out.println("\tFeel free to WALK around, LOOK AT, or PICK UP things. Type HELP if you need help.");

        // The do...while structure means we execute the body of the loop once before checking the stopping condition
        do {
            // ************************************************
            // The stuff that happens in your game will go here
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            System.out.println("\n\tWhat would you like to do?\n");
            try {
                userResponse = parseInput(userInput.nextLine().toUpperCase());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue; // has them try again, for all continue statements it does not increase your move counter
            }
            

            // ***********************************************************************
            // And as the player interacts, you'll check to see if the game should end
            //  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓  ↓
            if (userResponse.equals("north") || userResponse.equals("south") || userResponse.equals("east") || userResponse.equals("west")) {
                try {
                    mc.move(userResponse);
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            // Parsing input and deciding actions based on inputs
            } else if (userResponse.equals("look around")) {
                mc.currentLocation.describe();
            } else if (userResponse.equals("look at")) {
                System.out.println("What would you like to look at? Your options are: \n Inventory:");
                mc.printInventory();
                System.out.println(" Or in your surroundings: ");
                mc.currentLocation.printItems();
                try {
                    userResponse = " " + userInput.nextLine().toUpperCase() + " ";
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
            } else if (userResponse.equals("pick up")) { //Code for picking up items
                System.out.println("What would you like to pick up? Around you there are: ");
                mc.currentLocation.printItems();
                try {
                    userResponse = " " + userInput.nextLine().toUpperCase() + " ";
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
                            mc.currentLocation.addItem(i); //added so item remains in location
                            System.out.println(e.getMessage());
                        }
                        itemSearched = true;
                        break; //exits this for loop
                    }
                }
                if (itemSearched == false){
                    System.out.println("Sorry, I don't understand.");
                }
            } else if (userResponse.equals("drop")) { // Code for dropping items
                System.out.println("What would you like to look at? Your options are: \n Inventory:");
                mc.printInventory();
                try {
                    userResponse = " " + userInput.nextLine().toUpperCase() + " ";
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
            } else if (userResponse.equals("use")) { // Code for using an item
                System.out.println("What would you like to use/interact with? Your options are: \n Inventory:");
                mc.printInventory();
                System.out.println(" Or in your surroundings: ");
                mc.currentLocation.printItems();
                try {
                    userResponse = " " + userInput.nextLine().toUpperCase() + " ";
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue; // has them try again
                }
                boolean itemUsed = false;
                for (Item i : mc.inventory){
                    if (userResponse.contains(i.getName())){
                        i.use();
                        itemUsed = true;
                        break; //exits this for loop
                    }
                }
                for (Item i : mc.currentLocation.getItems()){
                    if (userResponse.contains(i.getName())){
                        i.use();
                        itemUsed = true;
                        break; //exits this for loop
                    }
                }
                if (itemUsed == false){
                    System.out.println("Sorry, I don't understand.");
                }
            } else if(userResponse.equals("inventory")) { // Code to print inventory
                mc.printInventory();
            } else if (userResponse.equals("help")){ // Code to show help message
                System.out.println("---------------------");
                System.out.println("Commands you can run:");
                System.out.println(" HELP: Displays this message");
                System.out.println(" MOVE + a direction: Walk in a direction");
                System.out.println("    - example: MOVE NORTH");
                System.out.println("    - example: MOVE SOUTH");
                System.out.println(" LOOK AROUND: Shows what's around you");
                System.out.println(" LOOK AT: Displays what items are in your inventory and around you");
                System.out.println(" PICK UP: Picks up an item");
                System.out.println(" DROP: Drops an item");
                System.out.println(" USE/INTERACT/FIX: Interact with or use an item");
                System.out.println("    - example:  USE BOAT");
                System.out.println("    - example:  USE STICK");
                System.out.println(" INVENTORY: View your current inventory.");
                System.out.println(" MAP: View an updating map.");
                System.out.println("---------------------");
            } else if (userResponse.equals("fix boat")){ //Code to fix the boat
                if(mc.currentLocation.getItems().contains(boat)){
                    boat.use();
                } else{
                    System.out.println("You're too far away from the BOAT here! Try heading bach to North Beach.");
                }
            } else if (userResponse.equals("map")){ // Code for map to be used
                map.use();
            }


            // Checking win/lose conditions
            if (currentTime>= timerMax){
                stillPlaying = false;
                winOrLose =false;
            } else if (mc.getNumSticks() >=sticksForSuccess && mc.getNumNails() >=nailsForSuccess && mc.getHasHammer() && mc.currentLocation.equals(northBeach)){
                stillPlaying = false;
                
            }
            
            if(stillPlaying){
                currentTime++;
            }

        } while (stillPlaying);

        // Tidy up
        userInput.close();

        // Once you exit the loop, you may need to deal with various possible stopping conditions
        if (mc.getNumSticks() >=2 && winOrLose) {
            System.out.println("You won!");
            System.out.println("Back on the beach where it all began, having collected enough materials to fix your boat, you escape the island!");
            
            
        } else { // userResponse.equals("LOSE")
            System.out.println("You took too long searching and it got dark. While you were hopelessly wandering, a Tiger came and ate you. You lose.");
        }
    }

    //Code to parse inputs and turn them into standardized outputs
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
        } else if (input.contains(" HELP ")){
            return "help";
        } else if(input.contains(" INTERACT ") || input.contains(" USE ")){
            return "use";
        } else if(input.contains(" INVENTORY ")){
            return "inventory";
        } else if(input.contains(" FIX BOAT ")){
            return "fix boat";
        } else if (input.contains("MAP")){
            return "map";
        } else {
            throw new RuntimeException("I don't understand what you are trying to do. Please try again.");
        }
    }

    
}
