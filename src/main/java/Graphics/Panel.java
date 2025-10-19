package main.java.Graphics;

import main.java.Board;
import main.java.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Panel extends JPanel implements ActionListener, KeyListener {
    private final int CELL_SIZE = 30;
    private final GameLogic gameLogic;
    private Board board;

    private Timer timer, gravTimer;

    public Panel(Board tetrisBoard, GameLogic tetrisLogic){
        board = tetrisBoard;
        gameLogic = tetrisLogic;

        setPreferredSize(new Dimension(Board.width * CELL_SIZE, Board.height * CELL_SIZE));
        setBackground(Color.BLACK);

        timer = new Timer(300, this);
        timer.start();
        gravTimer = new Timer(1, e -> repaint());
        gravTimer.start();

        addKeyListener(this);
        setFocusable(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameLogic.updateGameState();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        board.paintBoard(g, CELL_SIZE);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT -> gameLogic.moveBlockLeft();
            case KeyEvent.VK_RIGHT -> gameLogic.moveBlockRight();
            case KeyEvent.VK_UP -> gameLogic.rotateBlock();
            case KeyEvent.VK_DOWN -> gameLogic.moveBlockDown();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
