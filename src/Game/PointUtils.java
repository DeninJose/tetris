package Game;

import java.util.ArrayList;

public class PointUtils {
    public static ArrayList<ArrayList<Integer>> createGrid(int height, int width) {
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < height; j++) {
                row.add(0);
            }
            grid.add(row);
        }
        return grid;
    }
}
