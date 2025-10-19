package main.java.Data;

import java.util.ArrayList;

public class Points extends ArrayList<Point> {
    public Points(Point... points){
        for(var point : points){
            this.add(point);
        }
    }

    public Points getDeepCopy(){
        Points newPoints = new Points();
        for(Point point : this){
            newPoints.add(point.getDeepCopy());
        }
        return newPoints;
    }

    public void addOffset(int x, int y){
        for(Point point : this){
            point.addOffset(x, y);
        }
    }

    public Points getRotatedDeepCopy(Point pivot){
        Points rotatedPoints = new Points();
        for(var point : this){
            int x = point.y + pivot.x - pivot.y;
            int y = -point.x + pivot.x + pivot.y;
            Point rotatedPoint = new Point(x, y);
            rotatedPoints.add(rotatedPoint);
        }
        return rotatedPoints;
    }
}
