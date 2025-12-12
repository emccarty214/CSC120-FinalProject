import java.util.ArrayList;
public class Map extends Item{

    private ArrayList<Coordinate> coordinates;
    private String[][] map = new String[6][6];

    public Map(ArrayList<Coordinate> coordinates){
        this.coordinates = coordinates;

        for (int r = 0; r < 6; r++){
            for (int c = 0; c < 6; c++){
                map[r][c] = "-";
            }
        }
        for (Coordinate coord : coordinates){
            int x = coord.getX();
            int y = coord.getY();
            map[x][y] = "X";
        }
    }

    @Override
    public void use(){
        System.out.println("-------MAP-------");

        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}
