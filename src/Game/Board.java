package Game;

import Game.Data.Cell;
import Game.Data.Grid;
import Game.Data.Point;
import Game.Data.Points;
import Game.Enums.Color;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    public static final int height = 20;
    public static final int width = 11;
    private final Grid grid;
    private final Grid gridWithBlock;

    public Board() {
        grid = new Grid(height, width);
        gridWithBlock = new Grid(height, width);
    }

    public boolean hasHitBottom(Points block) {
        for (var point : block) {
            if (point.y >= height) {
                continue;
            }

            if (point.y < 0) {
                return true;
            }

            if (grid.isFilled(point)) {
                return true;
            }
        }
        return false;
    }

    public void addBlockToBaseAfterHit() {
        grid.deepCopy(gridWithBlock);
    }

    public void updateBoardWithBlock(Points block, Color color) {
        gridWithBlock.deepCopy(grid);

        for (var point : block) {
            if (point.y >= height) {
                continue;
            }
            gridWithBlock.fill(point, color);
        }
    }


    public void clearCompletedRows() {
        ArrayList<Integer> unfilledRows = getIncompleteRows();

        int rowToFill = 0;
        while (rowToFill < unfilledRows.size()) {
            int rowToFillWith = unfilledRows.get(rowToFill);
            fillRowAWithRowB(rowToFill, rowToFillWith);

            rowToFill++;
        }
        while (rowToFill < height) {
            fillRowWithZeros(rowToFill);

            rowToFill++;
        }

    }

    private ArrayList<Integer> getIncompleteRows() {
        ArrayList<Integer> unfilledRows = new ArrayList<Integer>();
        for (int y = 0; y < height; y++) {
            boolean isComplete = true;
            for (int x = 0; x < width; x++) {
                if (!grid.isFilled(x, y)) {
                    isComplete = false;
                    break;
                }
            }
            if (!isComplete) {
                unfilledRows.add(y);
            }
        }
        return unfilledRows;
    }

    private void fillRowAWithRowB(int a, int b) {
        for (int x = 0; x < width; x++) {
            grid.deepCopy(x, a, grid.get(x, b));
        }
    }

    private void fillRowWithZeros(int row) {
        for (int x = 0; x < width; x++) {
            grid.deepCopy(x, row, Cell.Default);
        }
    }

    public void paintBoard(Graphics g, int cellSize) {
        for (int x = 0; x < Board.width; x++) {
            for (int y = Board.height - 1; y >= 0; y--) {
                g.setColor(gridWithBlock.get(x, y).color.color);
                g.fillRect(x * cellSize, (height - 1 - y) * cellSize, cellSize - 1, cellSize - 1);
            }
        }
    }

    private boolean isValidPoint(Point point){
        if(point.x < 0 || point.x >= width) return false;
        if(point.y < 0 || point.y >= height) return false;
        return true;
    }

    private boolean isPointFilled(Point point){
        return grid.isFilled(point.x, point.y);
    }

    public boolean arePointsFree(Points points){
        for(var point : points){
            if(
                    !isValidPoint(point) ||
                    isPointFilled(point)
            ){
                return false;
            }
        }
        return true;
    }

    public boolean arePointsColliding(Points points){
        for(var point : points){
            if(isPointColliding(point)) return true;
        }
        return false;
    }

    public boolean isPointColliding(Point point){
        if(!isValidPoint(point)) return false;
        return isPointFilled(point);
    }
}
