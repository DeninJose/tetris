package Game.Data;

import java.util.ArrayList;

public class Grid extends ArrayList<Row> {
    public Grid(Row... rows){
        for(var row : rows){
            this.add(row);
        }
    }
}
