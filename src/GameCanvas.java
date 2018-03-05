import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Background background;
    Player player;
    Square square;
    Vector<Square> squares;
    Square mediumSquare;
    Vector<Square> mediumSquares;
    Bullet mediumSquareBullet;
    Vector<Bullet> mediumSquareBullets;
    Bullet bullet;
    Vector<Bullet> bullets;
    Random random;

    int countSquare = 0;
    int countMediumSquare = 0;
    int countMediumSquareBullet = 0;
    int countBullet = 0;

    public GameCanvas() {

        this.setSize(400, 600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        background = new Background();
        background.setX(0);
        background.setY(0);
        try {

            this.background = new Background(ImageIO.read(new File("resources/background/background.png"))
                    , background.getX(), background.getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        player = new Player();
        player.setX(200);
        player.setY(200);
        try {

            this.player = new Player(ImageIO.read(new File("resources/player/straight.png"))
                    , player.getX(), player.getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.squares = new Vector<>();
        this.mediumSquares = new Vector<>();
        this.mediumSquareBullets = new Vector<>();
        this.bullets = new Vector<>();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        this.background.render(this.graphics);
        this.player.render(this.graphics);
        this.squares.forEach(square -> square.render(graphics));
        this.mediumSquares.forEach(mediumSquare -> mediumSquare.render(graphics));
        this.mediumSquareBullets.forEach(mediumSquareBullet -> mediumSquareBullet.render(graphics));
        this.bullets.forEach(bullet -> bullet.render(graphics));
        /*this.square.render(this.graphics);*/
        this.repaint();
    }

    public void createSquare() {

        square = new Square();
        random = new Random();

        int x = 2 + random.nextInt(397);
        int y = 2 + random.nextInt(197);
        int dx = 1 + random.nextInt(3);
        int dy = 1 + random.nextInt(7);

        square.setX(x);
        square.setY(y);
        square.setDx(dx);
        square.setDy(dy);

        if (this.countSquare >= 30) {

            try {

                this.square = new Square(ImageIO.read(new File("resources/square/enemy_square_small.png"))
                        , square.getX(), square.getY(), square.getDx(), square.getDy());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.squares.add(square);
            this.countSquare = 0;
        } else {
            this.countSquare += 1;
        }
    }

    public void createBullet() {

        bullet = new Bullet();
        bullet.setX(player.getX() + 10);
        bullet.setY(player.getY());
        bullet.setDy(0);

        if (countBullet >= 30) {

            try {

                bullet = new Bullet(ImageIO.read(new File("resources/player/player_bullet.png"))
                        , bullet.getX(), bullet.getY(), bullet.getDx(), bullet.getDy() - 4);
                bullets.add(bullet);
                countBullet = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            countBullet += 1;
        }
    }

    public void createMediumSquare() {

        mediumSquare = new Square();
        random = new Random();

        int x = 2 + random.nextInt(397);
        int y = 2 + random.nextInt(97);
        /*int dy = 1 + random.nextInt(7);*/

        mediumSquare.setX(x);
        mediumSquare.setY(y);
        mediumSquare.setDx(0);
        mediumSquare.setDy(0);
        /*mediumSquare.setDy(dy);*/

        if (countMediumSquare >= 30) {

            try {
                mediumSquare = new Square(ImageIO.read(new File("resources/square/enemy_square_medium.png"))
                        , mediumSquare.getX(), mediumSquare.getY(), mediumSquare.getDx(), mediumSquare.getDy() + 4);
                mediumSquares.add(mediumSquare);
                countMediumSquare = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            countMediumSquare += 1;
        }
    }

    public void createMediumSquareBullet() {

        mediumSquareBullet = new Bullet();
        mediumSquareBullet.setX(mediumSquare.getX() + 10);
        mediumSquareBullet.setY(mediumSquare.getY());
        mediumSquareBullet.setDx(0);
        mediumSquareBullet.setDy(0);

        if (countMediumSquareBullet >= 30) {

            try {

                mediumSquareBullet = new Bullet(ImageIO.read(new File("resources/square/enemy_square_bullet.png"))
                        , mediumSquareBullet.getX(), mediumSquareBullet.getY(), mediumSquareBullet.getDx(), mediumSquareBullet.getDy() + 8);
                mediumSquareBullets.add(mediumSquareBullet);
                countMediumSquareBullet = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            countMediumSquareBullet += 1;
        }
    }

    public void runSquares() {

        this.createSquare();
        this.squares.forEach(square -> square.move());
    }

    public void runMediumSquares() {

        createMediumSquare();
        mediumSquares.forEach(mediumSquare -> mediumSquare.move());
    }

    public void runMediumSquareBullets() {

        createMediumSquareBullet();
        mediumSquareBullets.forEach(mediumSquareBullet -> mediumSquareBullet.move());
    }

    public void runBullets() {

        createBullet();
        bullets.forEach(bullet -> bullet.move());
    }

    public void runAll() {

        this.runSquares();
        runMediumSquares();
        runMediumSquareBullets();
        runBullets();
    }
}
