package main.java.Data;

import main.java.Enums.Color;

import java.util.ArrayList;

public class Grid extends ArrayList<Cell> {
    int height = 0;
    int width = 0;
    public Grid(int height, int width){
        this.height = height;
        this.width = width;
        int totalCells = height * width;
        for (int i = 0; i < totalCells; i++) {
            this.add(new Cell());
        }
    }

    public Cell get(int x, int y){
        return this.get(getIndex(x, y));
    }

    public void fill(int x, int y, Color color){
        this.get(getIndex(x, y)).fill(color);
    }

    public void fill(Point point, Color color){
        fill(point.x, point.y, color);
    }

    public boolean isFilled(int x, int y){
        return this.get(getIndex(x, y)).isFilled();
    }

    public boolean isFilled(Point point){
        return isFilled(point.x, point.y);
    }

    public void deepCopy(Grid other){
        int size = getSize();
        for(int i = 0; i < size; i++){
            this.get(i).deepCopy(other.get(i));
        }
    }

    public void deepCopy(int x, int y, Cell cell){
        this.get(getIndex(x, y)).deepCopy(cell);
    }

    private int getIndex(int x, int y){
        return y * width + x;
    }

    private int getSize(){
        return this.height * this.width;
    }
}
