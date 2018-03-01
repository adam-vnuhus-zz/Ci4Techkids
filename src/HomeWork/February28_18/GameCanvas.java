package HomeWork.February28_18;

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

    int positionPlayerX;
    int positionPlayerY;
    int positionSquareY;

    public GameCanvas() {

        this.setSize(400, 600);
        this.setVisible(true);
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

        g.drawImage(this.background, 0, 0, null);
        g.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
        g.drawImage(this.square, 100, this.positionSquareY, null);
    }

    public void run() {
        this.positionSquareY += 5;
    }
}
