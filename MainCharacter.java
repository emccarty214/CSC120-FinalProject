import java.util.ArrayList;

public class MainCharacter {

    Location currentLocation;
    ArrayList<Item> inventory;

    public MainCharacter(Location initialLocation){
        currentLocation=initialLocation;
        inventory = new ArrayList<Item>();
    }

    public void move(String direction) {

        Coordinate newCoord = this.newCoord(direction);

        ArrayList<Location> adjLoc = this.currentLocation.getAdjLocations();

        boolean isAdjacent = false;
        Location adjLocation = new Location();

        for (Location l: adjLoc){
            if(l.getCoord().equals(newCoord)){
                isAdjacent = true;
                adjLocation = l;
                break;
            }
        }

        if(isAdjacent){
            this.currentLocation = adjLocation;
        } else{
            System.out.println("You can't go this way!");
        }

    }

    private Coordinate newCoord(String direction){
        Coordinate currentCoord = this.currentLocation.getCoord();
        if(direction.equalsIgnoreCase("north")){
            return new Coordinate(currentCoord.getX(), currentCoord.getY() +1);
        } else if (direction.equalsIgnoreCase("east")) {
            return new Coordinate(currentCoord.getX()+1, currentCoord.getY());
        } else if (direction.equalsIgnoreCase("south")){
            return new Coordinate(currentCoord.getX(), currentCoord.getY() -1);
        } else if (direction.equalsIgnoreCase("west")){
            return new Coordinate(currentCoord.getX()-1, currentCoord.getY());
        } else{
            throw new RuntimeException("Not a valid direction. Valid directions are north, east, south, or west");
        }
    }

    
}
