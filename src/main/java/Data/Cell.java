package main.java.Data;

import main.java.Enums.Color;

public class Cell {
    private boolean isFilled;
    public Color color;

    public static Cell Default = new Cell();

    public Cell(){
        this.isFilled = false;
        this.color = Color.Black;
    }

    public Cell(boolean isFilled, Color color){
        this.isFilled = isFilled;
        this.color = color;
    }

    public boolean isFilled(){
        return isFilled;
    }

    public void fill(Color color){
        isFilled = true;
        this.color = color;
    }

    public void deepCopy(Cell other){
        this.isFilled = other.isFilled;
        this.color = other.color;
    }
}
