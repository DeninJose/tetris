package Game;

import Game.Data.Point;
import Game.Data.Points;
import Game.Enums.BlockType;
import Game.Enums.Color;

import java.util.Random;

public class FallingBlock {
    private static final Random random = new Random();

    private BlockType blockType;
    private int timesRotated;
    private Color color;

    private Points points;
    private Point pivot;

    public FallingBlock() {
        blockType = BlockType.values()[random.nextInt(BlockType.values().length)];
        timesRotated = random.nextInt(4);
        color = Color.getRandom(random);

        points = blockType.getPoints().getDeepCopy();
        pivot = blockType.getPivot().getDeepCopy();

        points.addOffset(Board.width / 2, Board.height);
        pivot.addOffset(Board.width / 2, Board.height);
        // Maybe optimise if slow, maybe dont
        for (int i = 0; i < timesRotated; i++) {
            points = points.getRotatedDeepCopy(pivot);
        }
    }

    public void offsetBlock(int x, int y){
        pivot.addOffset(x, y);
        points.addOffset(x, y);

    }

    public void setPoints(Points newPoints){
        points = newPoints;
    }

    public Points getCurrentPosition(){
        return points;
    }

    public Color getColor(){
        return color;
    }

    public Points getOffsetPoints(int x, int y){
        var newPoints = points.getDeepCopy();
        newPoints.addOffset(x, y);
        return newPoints;
    }

    public Points getRotatedPoints(){
        return points.getRotatedDeepCopy(pivot);
    }

}
