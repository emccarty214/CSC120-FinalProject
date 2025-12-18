import java.util.ArrayList;
/**
 * A class that simulates a 2D map
 */
public class Map extends Item{

    //Attributes
    private ArrayList<Location> locations;
    private String[][] map = new String[5][6];

    /**
     * A full constructor for the map class
     * @param coordinates a list of coordinates (not bigger that 30 elements) to be mapped out.
     */
    public Map(ArrayList<Location> locations){
        this.locations = locations;

        for (int r = 0; r < 5; r++){
            for (int c = 0; c < 6; c++){
                map[r][c] = "-";
            }
        }

    }
    
    /**
     * Uses the map and prints the map
     * Updates and reveals more of the map as the game is played
     */
    @Override
    public void use(){
 
        System.out.println("----MAP----");
        for (int r = 0; r < 5; r++){
            for (int c = 0; c < 6; c++){
                map[r][c] = "-";
            }
        }

        int minX = 0;
        int maxY = 4; 

        for (Location location : locations){
            int x = location.getCoord().getX();
            int y = location.getCoord().getY();

            int col = x - minX;           
            int row = maxY - y;          

            if (row >= 0 && row < 5 && col >= 0 && col < 6) {
                if (location.getIsFound()){
                    map[row][col] = "X";
                }
            }
        }

        // prints top to bottom
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 6; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");
    }
}
