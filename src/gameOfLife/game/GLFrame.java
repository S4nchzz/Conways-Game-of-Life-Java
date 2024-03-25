package gameOfLife.game;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GLFrame extends JFrame implements MouseListener {
    private final Generation gen;

    public GLFrame () {
        setTitle("Game Of Life");
        setVisible(true);
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(Color.BLACK);

        gen = new Generation(this);
        addMouseListener(this);

        gen.setPixel();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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