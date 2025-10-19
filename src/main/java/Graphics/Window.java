package main.java.Graphics;

import main.java.Board;
import main.java.GameLogic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
        setIcon();
        setVisible(true);
    }

    private void setIcon(){
        Image icon = null;
        try {
            icon = ImageIO.read(getClass().getResource("/main/resources/assets/tetris.png"));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        setIconImage(icon);
        if(Taskbar.isTaskbarSupported()){
            Taskbar.getTaskbar().setIconImage(icon);
        }
    }
}
