package GeoArcade.Lessons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

/*Tao giay ve GameCanvas*/
public class GameCanvas extends JPanel {

    /*BufferedImage background;*/
    Background background;
    /*BufferedImage player;*/
    Player player;
    /*Square square;*/
    Vector<Square> squareVector;
    Vector<Bullet> bulletVector;
    BufferedImage backBuffered;
    Graphics graphics;
    Random random;

    int positionPlayerX;
    int positionPlayerY;
    int positionSquareX;
    int positionSquareY;
    int dYSquare;

    int countSquare = 0;
    int countBullet = 0;

    /*Constructor luon luon duoc goi dau tien khi khoi tao Object*/
    public GameCanvas() {

        /*this.setSize(400, 600);
        this.setVisible(true);*/
        this.setup();

       /* this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();*/
        this.setupBackBuffered();

        //Load Images
        /*try {
            this.background = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        this.setBackground();

        /*try {
            this.player = new Player(ImageIO.read(new File("resources/player/straight.png")), 200, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        this.setPlayer();

        /*try {
            this.square = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            this.square = new Square(ImageIO.read(new File("resources/square/enemy_square_small.png")),20,0,0,4);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        this.squareVector = new Vector<>();
        this.bulletVector = new Vector<>();
    }

    /*Tao but ve, ve het moi thu trong paintComponent*/
    @Override
    protected void paintComponent(Graphics g) {

        /*super.paintComponent(g);      //  ham vẽ mac dinh khong can
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 30, 30);
        g.fillRect(0, 0, 90, 90);*/

        // Draw Images
        /*g.drawImage(this.background, 0, 0, null);
        g.drawImage(this.player, 200, 300, null);
        g.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
        g.drawImage(this.square, 0, this.positionSquareY, null);*/

        /*Lat backBuffered len man hinh chinh*/
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        /* this.positionSquareY += 5;*/
        /*this.square.run();*/
        this.runSquares();

        /*Player shoot*/
        this.runBullets();
    }

    private void setup() {
        this.setSize(400, 600);
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setBackground() {
        try {
            this.background = new Background(ImageIO.read(new File("resources/background/background.png")), 0, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayer() {
        try {
            this.player = new Player(ImageIO.read(new File("resources/player/straight.png")), 200, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void runSquares() {
        this.createSquare();
        this.squareVector.forEach(square -> square.run());
    }

    private void createSquare() {
        random = new Random();
        positionSquareX = 2 + random.nextInt(398);
        positionSquareY = 2 + random.nextInt(598);
        dYSquare = 2 + random.nextInt(6);
        if (this.countSquare >= 30) {
            try {
                Square square = new Square(ImageIO.read(new File("resources/square/enemy_square_small.png")), positionSquareX, positionSquareY, 0, dYSquare);
                this.squareVector.add(square);
                this.countSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countSquare += 1;
        }
    }

    private void runBullets() {
        this.createBullet();
        this.bulletVector.forEach(bullet -> bullet.run());
    }

    public void createBullet() {
        if (this.countBullet >= 30) {
            try {
                Bullet bullet = new Bullet(ImageIO.read(new File("resources/player/player_bullet.png")), this.player.x, this.player.y, 0, -4);
                this.bulletVector.add(bullet);
                this.countBullet = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            this.countBullet += 1;
        }
    }

    public void renderAll() {
        /*this.graphics.drawImage(this.background, 0, 0, null);*/
        this.background.render(this.graphics);
        /*g.drawImage(this.player, 200, 300, null);*/
        /*this.graphics.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);*/
        this.player.render(this.graphics);
        /*this.graphics.drawImage(this.square, 0, this.positionSquareY, null);*/
        /*this.square.render(this.graphics);*/
        this.squareVector.forEach(square -> square.render(graphics));
        this.bulletVector.forEach(bullet -> bullet.render(graphics));
        this.repaint();
    }
}
