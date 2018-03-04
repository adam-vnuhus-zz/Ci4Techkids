package Homeworks.GeoArcade.February28_18;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    BufferedImage square;
    BufferedImage backBuffered;
    Graphics graphics;

    int positionPlayerX;
    int positionPlayerY;
    int positionSquareY = 0;
    int positionSquareX = 0;
    int vectorSquareX = 5;
    int vectorSquareY = 5;

    public GameCanvas() {

        this.setSize(400, 600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void run() {

        //Bouncing square
        if (positionSquareX < 0 || positionSquareX >= this.getWidth()) {
            vectorSquareX = -vectorSquareX;
        }

        if (positionSquareY < 0 || positionSquareY >= this.getHeight()) {
            vectorSquareY = -vectorSquareY;
        }

        positionSquareX += vectorSquareX;
        positionSquareY += vectorSquareY;

    }

    public void renderAll() {

        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
        this.graphics.drawImage(this.square, positionSquareX, positionSquareY, null);
        this.repaint();
    }
}
