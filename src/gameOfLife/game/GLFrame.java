package gameOfLife.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GLFrame extends JFrame implements MouseListener {
    public GLFrame () {
        setTitle("Game Of Life");
        setVisible(true);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.BLACK);

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        new Generation(this, e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
}