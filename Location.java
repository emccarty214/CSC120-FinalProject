import java.util.ArrayList;

public class Location {
    // Attributes:
    String name; // location name
    String description; // location description
    Coordinate xy; // locatioin coordinates on map 
    ArrayList<Item> items; // list of items in this location
    ArrayList<Location> adjacentLocations; // list of adjacent locations

    //Added by Claire
    private Coordinate coordinate;
    



    public Location() {
        // Constructor
    }

    public void describe() {
        // print location name, description, etc.
    }

    public void removeItem(Item i) {
        //
    }


    public Coordinate getCoord(){
        return this.coordinate;
    }

    public ArrayList<Location> getAdjLocations(){
        return this.adjacentLocations;
    }
    
}
