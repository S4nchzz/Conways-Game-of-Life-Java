package gameOfLife.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Generation {
    private boolean [][] gen;
    private boolean [][] nextGen;

    private final Dimension dim;
    private final Insets insets;

    private final Rules r;

    private final Graphics g;
    private int w;
    private int h;

    private final Random rm;
    
    public Generation (JFrame frame) {
        dim = frame.getSize();
        insets = frame.getInsets();
        
        w = dim.width - insets.left + 1;
        h = dim.height - insets.bottom + insets.top;
        this.gen = new boolean[w][h];
        this.nextGen = new boolean[w][h];

        this.r = new Rules();

        g = frame.getGraphics();

        rm = new Random();
    }

    public void setPixel() {
        for (int x = w / 2 - 100; x < w / 2 + 100; x++) {
            for (int y = h / 2 - 100; y < h / 2 + 100; y++) {
                gen[x][y] = rm.nextBoolean();
            }
        }

        startAnimation();
    }

    private void startAnimation () {
        while (true) {
            generateGeneration();
        }
    }

    private void generateGeneration () {
        boolean isAlive = false;
        for (int x = 1; x < nextGen.length - 1; x++) {
            for (int y = 1; y < nextGen[x].length - 1; y++) {
                if (x < nextGen.length && y < nextGen[x].length) {
                    isAlive = gen[x][y] ? isAlive = r.alive(gen, x, y, true) : r.alive(gen, x, y, false);
                    if (isAlive) {
                        nextGen[x][y] = isAlive;
                        printPixel(x, y);
                    } else {
                        removePixel(x, y);
                    }
                }
            }     
        }
        gen = nextGen;
        nextGen = new boolean[gen.length][gen[0].length];
    }

    private void removePixel (int x, int y) {
        g.setColor(Color.BLACK);
        g.drawLine(x, y, x, y);
    }

    private void printPixel (int x, int y) {
        g.setColor(Color.WHITE);
        g.drawLine(x, y, x, y);
    }
}