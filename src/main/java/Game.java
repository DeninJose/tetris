package main.java;

import main.java.Graphics.Window;

public class Game {
    private GameLogic gameLogic = new GameLogic();
    private Window window = new Window(gameLogic.getBoard(), gameLogic);

    public static void main() throws InterruptedException {
        Game newGame = new Game();
    }
}
