package GeoArcade.Lessons;

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
    //    int positionSquareX;
    int positionSquareY;

    public GameCanvas() {

        this.setSize(400, 600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        //Load Images
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

//        super.paintComponent(g);      //  ham ve mac dinh khong can
//        g.setColor(Color.BLUE);
//        g.fillRect(0, 0, 30, 30);
//        g.fillRect(0, 0, 90, 90);

        // Draw Images
        g.drawImage(this.backBuffered, 0, 0, null); //Lat backBuffered len man hinh chinh
//        g.drawImage(this.background, 0, 0, null);
////        g.drawImage(this.player, 200, 300, null);
//        g.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
//        g.drawImage(this.square, 0, this.positionSquareY, null);
    }

    public void run() {
        this.positionSquareY += 5;
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
//        g.drawImage(this.player, 200, 300, null);
        this.graphics.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
        this.graphics.drawImage(this.square, 0, this.positionSquareY, null);
        this.repaint();
    }
}
