/**
 * Simulates coordinates on the xy plane
 */
public class Coordinate {
    
    private int x; // the x coordinate
    private int y; // the y coordinate

    /**
     * A full constructor for the coordinate class
     * @param xCoord the x coordinate as an integer
     * @param yCoord the y coordinate as an integer
     */
    public Coordinate(int xCoord, int yCoord) {
        this.x = xCoord;
        this.y = yCoord;
    }


    //getters
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Checks if the given coordinate is equal to this coordinate
     * @param c coordinate we are checking against
     * @return true if they are the same, false if they are not
     */
    public boolean equals(Coordinate c){
        return c.getX() == x && c.getY() ==y;
    }

}