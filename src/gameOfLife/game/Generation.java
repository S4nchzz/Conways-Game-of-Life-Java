package gameOfLife.game;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;

public class Generation {
    private final JFrame frame;
    private final int mouseX;
    private final int mouseY;

    private final boolean [][] gen;
    private boolean [][] nextGen;

    private final Dimension dim;
    private final Insets insets;
    
    public Generation (JFrame frame, int mouseX, int mouseY) {
        this.frame = frame;

        this.mouseX = mouseX;
        this.mouseY = mouseY;

        dim = frame.getSize();
        insets = frame.getInsets();
        this.gen = new boolean[dim.width - insets.left - insets.right][dim.height - insets.bottom - insets.top];
    }
}