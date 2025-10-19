package Game;

import java.util.ArrayList;
import java.util.Random;

public class FallingBlock {
    private static final int numBlockTypes = BlockType.values().length;
    private static final Random random = new Random();

    private BlockType blockType;
    private int timesRotated;

    private ArrayList<ArrayList<Integer>> points;
    private ArrayList<Integer> pivot;

    public FallingBlock() {
        blockType = BlockType.values()[random.nextInt(numBlockTypes)];
        timesRotated = random.nextInt(4);

        points = PointUtils.getPointsDeepCopy(blockType.getPoints());
        pivot = PointUtils.getPointDeepCopy(blockType.getPivot());

        PointUtils.addOffsetToPoints(points, Board.width / 2, Board.height);
        PointUtils.addOffsetToPoint(pivot, Board.width / 2, Board.height);
        // Maybe optimise if slow, maybe dont
        for (int i = 0; i < timesRotated; i++) {
            points = PointUtils.getRotatedPoints(points, pivot);
        }
    }

    public void offsetBlock(int x, int y){
        PointUtils.addOffsetToPoint(pivot, x, y);
        PointUtils.addOffsetToPoints(points, x, y);

    }

    public void setPoints(ArrayList<ArrayList<Integer>> newPoints){
        points = newPoints;
    }

    public ArrayList<ArrayList<Integer>> getCurrentPosition(){
        return points;
    }

    public ArrayList<ArrayList<Integer>> getOffsetPoints(int x, int y){
        var newPoints = PointUtils.getPointsDeepCopy(points);
        PointUtils.addOffsetToPoints(newPoints, x, y);
        return newPoints;
    }

    public ArrayList<ArrayList<Integer>> getRotatedPoints(){
        return PointUtils.getRotatedPoints(points, pivot);
    }

}
