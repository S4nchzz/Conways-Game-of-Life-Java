package gameOfLife.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Generation {
    private boolean [][] gen;
    private boolean [][] nextGen;

    private final Dimension dim;
    private final Insets insets;

    private final Rules r;

    private final Graphics g;
    
    public Generation (JFrame frame) {
        dim = frame.getSize();
        insets = frame.getInsets();
        
        int w = dim.width - insets.left + 1;
        int h = dim.height - insets.bottom + insets.top;
        this.gen = new boolean[w][h];
        this.nextGen = new boolean[w][h];

        this.r = new Rules();

        g = frame.getGraphics();
    }

    public void setPixel(int mouseX, int mouseY) {
        gen[mouseX][mouseY] = true;
        gen[mouseX + 1][mouseY + 1] = true;
        gen[mouseX + 2][mouseY + 1] = true;
        gen[mouseX + 2][mouseY] = true;
        gen[mouseX + 1][mouseY - 1] = true;

        // Pintamos las células vivas
        g.setColor(Color.WHITE);
        g.drawLine(mouseX, mouseY, mouseX, mouseY);
        g.drawLine(mouseX + 1, mouseY + 1, mouseX + 1, mouseY + 1);
        g.drawLine(mouseX + 2, mouseY + 1, mouseX + 2, mouseY + 1);
        g.drawLine(mouseX + 2, mouseY, mouseX + 2, mouseY);
        g.drawLine(mouseX + 1, mouseY - 1, mouseX + 1, mouseY - 1);

        startAnimation();
    }

    private void startAnimation () {
        while (true) {
            try {
                Thread.sleep(1); // Espera 100 milisegundos entre cada generación
                generateGeneration();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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