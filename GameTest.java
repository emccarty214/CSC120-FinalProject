/**
 * Class that allowed us to test basic functionality of the game
 */

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
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>());
        assertEquals("X: 0 Y: 0","X: "+ l.getCoord().getX() + " Y: " + l.getCoord().getY());
    }

    @Test
    public void testLocationGetAdjLocation(){
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>());
        ArrayList<Location> locations = new ArrayList<>();
        locations.add(l);
        Location jungle = new Location("Jungle", "You are in the Jungle", new Coordinate(0,1), new ArrayList<Item>());
        jungle.addLocation(l); // add location works
        assertEquals(locations, jungle.getAdjLocations());
    }

    

    

    public static void main(String[] args) {

        Location l2 = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>());
        MainCharacter abby = new MainCharacter(l2);

        //test Item Describe Method
        Stick stick = new Stick("STICK", "Its a stick");
        stick.describe();
        l2.addItem(stick);

        //testing add item, remove item, and print items

        Stick stick2 = new Stick("STICK2", "Its a stick");
        Location l = new Location("Beach", "You are at North Beach", new Coordinate(0,0), new ArrayList<Item>());
        
        abby.collect(stick);
        abby.printInventory();
        
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

        //no error
        try {
            l.addItem(stick);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
    }

}
