package Game.Graphics;

import Game.Board;
import Game.GameLogic;

import javax.swing.*;

public class Window extends JFrame {
    private Panel panel;
    public Window(Board board, GameLogic logic){
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panel = new Panel(board, logic);
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
