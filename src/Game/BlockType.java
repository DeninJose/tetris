package Game;

import java.util.ArrayList;

public enum BlockType {
    l(BlockType.generatePoints(new int[][]{
            new int[]{0, 0},
            new int[]{1, 0},
            new int[]{1, 1},
            new int[]{1, 2}
    }), generatePivot(new int[]{1, 1})),
    t(BlockType.generatePoints(new int[][]{
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{1, 1},
            new int[]{1, 2}
    }), generatePivot(new int[]{1, 1})),
    i(BlockType.generatePoints(new int[][]{
            new int[]{0, 0},
            new int[]{0, 1},
            new int[]{0, 2},
            new int[]{0, 3}
    }), generatePivot(new int[]{0, 1})),
    box(BlockType.generatePoints(new int[][]{
            new int[]{0, 0},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{1, 1},
    }), generatePivot(new int[]{0, 1})),
    thunder(BlockType.generatePoints(new int[][]{
            new int[]{0, 0},
            new int[]{0, 1},
            new int[]{1, 1},
            new int[]{1, 2}
    }), generatePivot(new int[]{1, 1}));

    private ArrayList<ArrayList<Integer>> points;
    private ArrayList<Integer> pivot;

    BlockType(ArrayList<ArrayList<Integer>> blockPoints, ArrayList<Integer> blockPivot) {
        points = blockPoints;
        pivot = blockPivot;
    }

    public ArrayList<ArrayList<Integer>> getPoints() {
        return points;
    }

    public ArrayList<Integer> getPivot(){
        return pivot;
    }

    private static ArrayList<ArrayList<Integer>> generatePoints(int[][] points) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int[] point : points) {
            ArrayList<Integer> coords = new ArrayList<>();
            coords.add(point[0]);
            coords.add(point[1]);
            list.add(coords);
        }
        return list;
    }

    private static ArrayList<Integer> generatePivot(int[] point) {
        ArrayList<Integer> pivot = new ArrayList<Integer>();
        pivot.add(point[0]);
        pivot.add(point[1]);
        return pivot;
    }
}
