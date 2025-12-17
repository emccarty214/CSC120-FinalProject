import java.util.ArrayList;
/**
 * A class that simulates a 2D map
 */
public class Map extends Item{

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

    @Override
    public void use(){
        System.out.println("----MAP----");

        for (Location location : locations){
            int x = 6 - location.getCoord().getX();
            int y = 5 - location.getCoord().getY();
            if (location.getIsFound()){
                map[x][y] = "X";
            }
        }
        
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 6; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");
    }
}
