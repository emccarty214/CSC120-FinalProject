import java.util.ArrayList;
/**
 * A class that simulates a 2D map
 */
public class Map extends Item{

    private ArrayList<Coordinate> coordinates;
    private String[][] map = new String[5][6];

    /**
     * A full constructor for the map class
     * @param coordinates a list of coordinates (not bigger that 36 elements) to be mapped out.
     */
    public Map(ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;

        for (int r = 0; r < 5; r++){
            for (int c = 0; c < 6; c++){
                map[r][c] = "-";
            }
        }
        
        for (Coordinate coord : coordinates){
            int x = 6 - coord.getX();
            int y = 5 - coord.getY();
            map[x][y] = "X";
        }
    }

    @Override
    public void use(){
        System.out.println("-------MAP-------");

        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 6; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
