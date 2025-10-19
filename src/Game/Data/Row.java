package Game.Data;

import java.util.ArrayList;

public class Row extends ArrayList<Point>{
    public Row(Point... points){
        for(var point : points){
            this.add(point);
        }
    }
}
