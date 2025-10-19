package Game.Data;

import java.util.ArrayList;

public class Points extends ArrayList<Point> {
    public Points(Point... points){
        for(var point : points){
            this.add(point);
        }
    }
}
