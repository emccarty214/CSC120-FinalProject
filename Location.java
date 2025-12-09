import java.util.ArrayList;

public class Location {
    // Attributes:
    private String name; // location name
    private String description; // location description
    private Coordinate coordinate; // locatioin coordinates on map 
    private ArrayList<Item> items; // list of items in this location
    private ArrayList<Location> adjacentLocations; // list of adjacent locations
    

    /** 
     * Constructor for a location
     * @param name location name
     * @param description location description
     * @param coordinate location map coordinates
     * @param items list of items in location
     * @param adjloc list of adjacent places to location
     */
    public Location(String name, String description, Coordinate coordinate, ArrayList<Item> items, ArrayList<Location> adjloc) {
        this.name = name;
        this.description = description;
        this.coordinate = coordinate;
        this.items = items;
        this.adjacentLocations = adjloc;
    }



    /**
     * Prints out the name and description of a location
     */
    public void describe() {
        System.out.println("Welcome to the" + this.name);
        System.out.println(this.description);
    }



    /**
     * removes an item from the location
     * @param i item to be removed from the location's items
     */
    public void removeItem(Item i) {
        if (this.items.contains(i)) { // if location's items CONTAINS the item, REMOVE it
            this.items.remove(i);
        } else { // if location's items DOES NOT CONTAIN the item, THROW EXCEPTION
            throw new RuntimeException("There is no " + i.getName() + " currently in the " + this.name + ". You cannot remove an item that does not exist");
        }
     
    }



    /**
     * adds an item to the location if it is not already there
     * @param i the item you want to add to the location
     */
    public void addItem(Item i) {
        if (this.items.contains(i)) { // if items CONTAINS the item already, THROW EXCEPTION
            throw new RuntimeException(i.getName() + " is already in the " + this.name + ". You cannot add an item that is already in this location");
        } else { // if items DOES NOT CONTAIN the item, ADD it
            this.items.add(i);
        }
    }



    /**
     * adds a location to the array list of adjactent locations
     * @param l the adjacent location you want to add
     */
    public void addLocation(Location l) {
        if (!this.adjacentLocations.contains(l) && l.getCoord().getX() ) { // if adjacent locations CONTAINS the location already, THROW EXCEPTION
            throw new RuntimeException(l.getName() + " is already in the list of adjacent locations for " + this.name + ". You cannot add an item that is already in this location");
        } else { // if adjacent locations DOES NOT CONTAIN the location, ADD it
            this.adjacentLocations.add(l);
        }    
        
    }



    /**
     * removes an location from the adjacent location array list
     * @param l location to be removed from the location's adjacent locations
     */
    public void removeLocation(Location l) {
        if (this.adjacentLocations.contains(l)) { // if location's items CONTAINS the item, REMOVE it
            this.adjacentLocations.remove(l);
        } else { // if location's items DOES NOT CONTAIN the item, THROW EXCEPTION
            throw new RuntimeException("There is no " + l.getName() + " currently adjacent to " + this.name + ". You cannot remove a location that is not in the list");
        }
     
    }




    

    /**
     * prints list of all items in location 
     */
    public void printItems() {
        for (Item i : this.items) { // for each item in items, print the item name
            System.out.println(i.getName());
        } 
    }




    // Getters methods for coordinates and adjacent locations
    public Coordinate getCoord(){
        return this.coordinate;
    }

    public ArrayList<Location> getAdjLocations(){
        return this.adjacentLocations;
    }
    
    public String getName() {
        return this.name;
    }

    
}
