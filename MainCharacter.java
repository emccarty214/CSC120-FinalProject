import java.util.ArrayList;

/**
 * A class that simulates the Main Player Character.
 */
public class MainCharacter {

    Location currentLocation; // the current location that the mc is at
    ArrayList<Item> inventory; // the main character's inventory
    private int numSticks; // the number of sticks the main character currently has
    private int numNails; // the number of nails the main character currently has
    private boolean hasHammer; // whether or not the main character has a hammer

    /**
     * A full comstructor for the MainCharacter class
     * @param initialLocation the initial location the main character will be starting at
     */
    public MainCharacter(Location initialLocation) {
        this.currentLocation=initialLocation;
        this.inventory = new ArrayList<Item>();
        this.numSticks = 0;
        this.numNails = 0;
        this.hasHammer = false;
    }

    /**
     * A method that returns the number of sticks in the inventory
     * @return number sticks in inventory
     */
    public int getNumSticks(){
        return this.numSticks;
    }

    /**
     * A method that returns the number of nails in the inventory
     * @return number nails in inventory
     */
    public int getNumNails(){
        return this.numNails;
    }

    /**
     * A method that returns if there is a hammer in the inventory
     * @return true if the hammer is in the inventory, false if not
     */
    public boolean getHasHammer(){
        return this.hasHammer;
    }

    /**
     * A method that allows the player to move around the map. A direction is taken as an input,
     * and if there is another location in that direction, the player moves in that direction
     * @param direction A string representing one of four directions: north, east, south, or west
     */
    public void move(String direction) {

        Coordinate newCoord = this.newCoord(direction);

        ArrayList<Location> adjLoc = this.currentLocation.getAdjLocations();

        boolean isAdjacent = false;
        Location adjLocation = new Location("Blank", "Blank", new Coordinate(-1000,-1000), new ArrayList<Item>());

        for (Location l: adjLoc) {
            if(l.getCoord().getX() == newCoord.getX() && l.getCoord().getY() == newCoord.getY()){
                isAdjacent = true;
                adjLocation = l;
                break;
            }
        }

        if(isAdjacent) {
            this.currentLocation = adjLocation;
            this.currentLocation.describe(); // added by Claire on 12/4/2025
            this.currentLocation.found(); //****************************************- CHECK -*************************************************
        } else {
            throw new RuntimeException("You can't go this way!");
        }

    }

    /**
     * A helper method for move(). Calculates the Coordinate of the possible adjacent Location 
     * based on the direction. If the location passed in is not one of the four valid directions,
     * throws a RuntimeException.
     * @param direction A string representing one of four directions: north, east, south, or west
     * @return the new Coordinate.
     */
    private Coordinate newCoord(String direction) {
        Coordinate currentCoord = this.currentLocation.getCoord();
        if(direction.equalsIgnoreCase("north")) {
            return new Coordinate(currentCoord.getX(), currentCoord.getY() +1);
        } else if (direction.equalsIgnoreCase("east")) {
            return new Coordinate(currentCoord.getX()+1, currentCoord.getY());
        } else if (direction.equalsIgnoreCase("south")) {
            return new Coordinate(currentCoord.getX(), currentCoord.getY() -1);
        } else if (direction.equalsIgnoreCase("west")) {
            return new Coordinate(currentCoord.getX()-1, currentCoord.getY());
        } else {
            throw new RuntimeException("Not a valid direction. Valid directions are north, east, south, or west");
        }
    }

    /**
     * If the item that the player wants to use is in the inventory, allow the player to use it
     * if not, throw a RuntimeException
     * @param i the item that you are trying to use.
     */
    public void useItem(Item i) {
        if (inventory.contains(i)) { //I want to just say quickly that this may not work because contains checks if the exact object is the same, so this might be a problem point when debugging
            i.use();
        } else {
            throw new RuntimeException("You don't have " + i.getName() + " in your inventory!");
            //this could also be a print statement, but I think an exception would be more useful
        }
    }

    /**
     * Adds a new item to the inventory if the current location has that item to be collected. 
     * Throws an exception if the item is not in the inventory of the currentLocation.
     * Throws an exception if this item is already in the player's inventory
     * @param i the item that you are collecting
     */
    public void collect(Item i) {
        this.currentLocation.removeItem(i);

        if (!this.inventory.contains(i) && i.getCollectable()) {
            this.inventory.add(i);
            // update counters based on item type
            if (i instanceof Stick) {
                System.out.println("You picked up " + i.getName());
                numSticks++;
            } else if (i instanceof Nail) {
                System.out.println("You picked up " + i.getName());
                numNails++;
            } else if (i instanceof Hammer) {
                System.out.println("You picked up " + i.getName());
                hasHammer = true;
            }
        } else if (!this.inventory.contains(i) && !i.getCollectable()){
            throw new RuntimeException("You can't collect that! It's too heavy.");
        } else {
            throw new RuntimeException(i.getName() + " is alread in your inventory. You cannot add an item that is already in your inventory");
        }
        
    }

    /**
     * If the item in question is in your inventory, removes it from your inventory and adds it
     * to the inventory of the location. Throws an exception if the item is not in the inventory 
     * of the mainCharacter. Throws an exception if this item is already in the currentLocation's inventory
     * @param i the item that you are dropping.
     */
    public void drop(Item i){
        if (this.inventory.contains(i)) {
            this.inventory.remove(i);
        } else {
            throw new RuntimeException ("There is no " + i.getName() + " currently in your Inventory. You cannot remove an item that does not exist");
        }

        // update counters based on concrete item type
            if (i instanceof Stick) {
                System.out.println("You dropped " + i.getName());
                numSticks--;
            } else if (i instanceof Nail) {
                System.out.println("You dropped " + i.getName());
                numNails--;
            } else if (i instanceof Hammer) {
                System.out.println("You dropped " + i.getName());
                hasHammer = false;
            }

        this.currentLocation.addItem(i);
    }


    /**
     * Prints out all of the items currently in the inventory
     */
    public void printInventory(){
        if(this.inventory.isEmpty()){
            System.out.println("There are no items in your inventory");
        } else {
            System.out.println("-------------");
            for(Item i : this.inventory){
                System.out.println(i.getName());
            }
            System.out.println("-------------");
        }
    }
    
}
