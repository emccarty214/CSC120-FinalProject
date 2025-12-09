
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {
    
    @Test
    public void testItemConstructor1(){
        Stick stick = new Stick();
        assertEquals("UNKNOWN", stick.getName());
    }

    @Test
    public void testItemConstructor2(){
        Stick stick = new Stick("STICK", "Its a stick");
        assertEquals("STICK", stick.getName());
    }

    @Test
    public void testLocationConstructorAndGetCoord(){
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>(), new ArrayList<Location>());
        assertEquals("X: 0 Y: 0","X: "+ l.getCoord().getX() + " Y: " + l.getCoord().getY());
    }

    @Test
    public void testLocationGetAdjLocation(){
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>(), new ArrayList<Location>());
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(l);
        Location jungle = new Location("Jungle", "You are in the Jungle", new Coordinate(0,1), new ArrayList<Item>(), locations);
        assertEquals(locations, jungle.getAdjLocations());
    }

    

    

    public static void main(String[] args) {
        //test Item Describe Method
        Stick stick = new Stick("STICK", "Its a stick");
        stick.describe();

        //testing add item, remove item, and print items

        Stick stick2 = new Stick("STICK2", "Its a stick");
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>(), new ArrayList<Location>());
        
        //no error
        try {
            l.addItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //yes error
        try {
            l.addItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //no error
        try {
            l.addItem(stick2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        l.printItems();

        //no error
        try {
            l.removeItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //yes error
        try {
            l.removeItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Location adj = new Location("Adjacent", "blah blah", new Coordinate(2, 3), new ArrayList<Item>() , new ArrayList<Location>());
        //no error
        try {
            l.addItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        


    }

}
