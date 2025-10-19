package main.java.Data;

public class Point {
    public int x = 0;
    public int y = 0;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point getDeepCopy(){
        return new Point(x, y);
    }

    public void addOffset(int x, int y){
        this.x += x;
        this.y += y;
    }
}
