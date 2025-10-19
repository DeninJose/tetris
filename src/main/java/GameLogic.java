package main.java;

public class GameLogic {
    private Board board = new Board();
    private FallingBlock currentBlock = new FallingBlock();

    public void updateGameState() {
        // Check if currentBlock has hit bottom
        var newBlock = currentBlock.getOffsetPoints(0, -1);
        if(!board.hasHitBottom(newBlock)){
            // Add block to board
            currentBlock.offsetBlock(0, -1);
            board.updateBoardWithBlock(currentBlock.getCurrentPosition(), currentBlock.getColor());
            return;
        }
        // Merge block with board
        board.addBlockToBaseAfterHit();
        // Clear filled rows
        board.clearCompletedRows();
        // Create new Block
        createNewBlock();
    }

    private void createNewBlock(){
        var newFallingBlock = new FallingBlock();
        var newBlock = newFallingBlock.getCurrentPosition();
        // If new block is colliding, then return
        if(board.arePointsColliding(newBlock)){
            return;
        }
        currentBlock = newFallingBlock;
        board.updateBoardWithBlock(newBlock, currentBlock.getColor());
    }

    public void moveBlockLeft(){
        moveBlock(-1, 0);
    }

    public void moveBlockRight(){
        moveBlock(1, 0);
    }

    public void moveBlockDown(){
        moveBlock(0, -1);
    }

    private void moveBlock(int x, int y) {
        var shiftedBlock = currentBlock.getOffsetPoints(x, y);
        var canBeShifted = board.arePointsFree(shiftedBlock);
        if(!canBeShifted){
            return;
        }
        currentBlock.offsetBlock(x, y);
        board.updateBoardWithBlock(currentBlock.getCurrentPosition(), currentBlock.getColor());
    }

    public void rotateBlock(){
        var shiftedBlock = currentBlock.getRotatedPoints();
        var canBeShifted = board.arePointsFree(shiftedBlock);
        if(!canBeShifted){
            return;
        }
        currentBlock.setPoints(shiftedBlock);
        board.updateBoardWithBlock(currentBlock.getCurrentPosition(), currentBlock.getColor());
    }

    public Board getBoard() {
        return board;
    }
}
