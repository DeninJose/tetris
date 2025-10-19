package Game.Enums;

import Game.Data.Point;
import Game.Data.Points;

public enum BlockType {
    reverseL(new Points(
            new Point(0, 0),
            new Point(1, 0),
            new Point(1, 1),
            new Point(1, 2)
    ), new Point(1, 1)),
    l(new Points(
            new Point(0, 0),
            new Point(0, 1),
            new Point(0, 2),
            new Point(1, 0)
    ), new Point(0, 1)),
    t(new Points(
            new Point(0, 1),
            new Point(1, 0),
            new Point(1, 1),
            new Point(1, 2)
    ), new Point(1, 1)),
    i(new Points(
            new Point(0, 0),
            new Point(0, 1),
            new Point(0, 2),
            new Point(0, 3)
    ), new Point(0, 1)),
    box(new Points(
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 0),
            new Point(1, 1)
    ), new Point(0, 1)),
    reverseThunder(new Points(
            new Point(0, 1),
            new Point(0, 2),
            new Point(1, 1),
            new Point(1, 0)
    ), new Point(1, 1)),
    thunder(new Points(
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 2)
    ), new Point(1, 1));

    private Points points;
    private Point pivot;

    BlockType(Points blockPoints, Point blockPivot) {
        points = blockPoints;
        pivot = blockPivot;
    }

    public Points getPoints() {
        return points;
    }

    public Point getPivot(){
        return pivot;
    }
}
