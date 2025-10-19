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

    public static ArrayList getPointDeepCopy(ArrayList<Integer> point){
        var newPoint = new ArrayList<>();
        for(int n : point){
            newPoint.add(n);
        }
        return newPoint;
    }

    public static ArrayList getPointsDeepCopy(ArrayList<ArrayList<Integer>> points){
        var newPoints = new ArrayList<ArrayList<Integer>>();
        for(var point : points){
            newPoints.add(getPointDeepCopy(point));
        }
        return newPoints;
    }

    public static void addOffsetToPoints(ArrayList<ArrayList<Integer>> points, int x, int y){
        for(var point : points){
            addOffsetToPoint(point, x, y);
        }
    }

    public static void addOffsetToPoint(ArrayList<Integer> point, int x, int y){
        point.set(0, point.get(0) + x);
        point.set(1, point.get(1) + y);
    }

    public static ArrayList<ArrayList<Integer>> getRotatedPoints(ArrayList<ArrayList<Integer>> block, ArrayList<Integer> pivot){
        ArrayList<ArrayList<Integer>> rotatedPoints = new ArrayList<>();
        for(var point : block){
            ArrayList<Integer> rotatedPoint = new ArrayList<Integer>();
            rotatedPoint.add(point.get(1) + pivot.get(0) - pivot.get(1));
            rotatedPoint.add(-point.get(0) + pivot.get(0) + pivot.get(1));
            rotatedPoints.add(rotatedPoint);
        }
        return rotatedPoints;
    }

}
