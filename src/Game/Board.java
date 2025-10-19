package Game;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    public static final int height = 20;
    public static final int width = 11;
    private ArrayList<ArrayList<Integer>> board, boardWithBlock;

    public Board() {
        board = PointUtils.createGrid(height, width);
        boardWithBlock = PointUtils.createGrid(height, width);
    }

    public boolean hasReachedBottom(ArrayList<ArrayList<Integer>> block) {
        for (var point : block) {
            int x = point.get(0);
            int y = point.get(1);
            if (y >= height) {
                continue;
            }

            if (y < 0) {
                return true;
            }

            if (board.get(x).get(y) == 1) {
                return true;
            }
        }
        return false;
    }

    public void addBlockToBaseAfterHit() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board.get(i).set(j, boardWithBlock.get(i).get(j));
            }
        }
    }

    public void updateBoardWithBlock(ArrayList<ArrayList<Integer>> block) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                boardWithBlock.get(i).set(j, board.get(i).get(j));
            }
        }

        for (var point : block) {
            if (point.get(1) >= height) {
                continue;
            }
            boardWithBlock.get(point.get(0)).set(point.get(1), 1);
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
                if (board.get(x).get(y) == 0) {
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
            board.get(x).set(a, board.get(x).get(b));
        }
    }

    private void fillRowWithZeros(int row) {
        for (int x = 0; x < width; x++) {
            board.get(x).set(row, 0);
        }
    }

    public void paintBoard(Graphics g, int cellSize) {
        for (int x = 0; x < Board.width; x++) {
            for (int y = Board.height - 1; y >= 0; y--) {
                if (boardWithBlock.get(x).get(y) == 1) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.BLACK);
                }

                g.fillRect(x * cellSize, (height - 1 - y) * cellSize, cellSize - 1, cellSize - 1);
            }
        }
    }

    private boolean isValidPoint(ArrayList<Integer> point){
        int x = point.get(0);
        int y = point.get(1);
        if(x < 0 || x >= width) return false;
        if(y < 0 || y >= height) return false;
        return true;
    }

    private boolean isPointFilled(ArrayList<Integer> point){
        int x = point.get(0);
        int y = point.get(1);
        return board.get(x).get(y) == 1;
    }

    public boolean arePointsFree(ArrayList<ArrayList<Integer>> points){
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

    public boolean arePointsColliding(ArrayList<ArrayList<Integer>> points){
        for(var point : points){
            if(isPointColliding(point)) return true;
        }
        return false;
    }

    public boolean isPointColliding(ArrayList<Integer> point){
        if(!isValidPoint(point)) return false;
        return isPointFilled(point);
    }

}
