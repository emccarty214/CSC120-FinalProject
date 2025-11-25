public class Coordinate {
    
    private int x;
    private int y;

    public Coordinate(int xCoord, int yCoord) {
        this.x = xCoord;
        this.y = yCoord;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    
    public boolean equals(Coordinate c){
        return c.getX() == x && c.getY() ==y;
    }

}