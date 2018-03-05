import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;
    Background background;
    Player player;

    public GameCanvas() {

        this.setSize(400, 600);
        this.setVisible(true);
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

        background = new Background();
        background.setX(0);
        background.setY(0);
        try {

            this.background = new Background(ImageIO.read(new File("resources/background/background.png")), background.getX(), background.getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
        player = new Player();
        player.setX(200);
        player.setY(200);
        try {
            this.player = new Player(ImageIO.read(new File("resources/player/straight.png")), player.getX(), player.getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {

        this.background.render(this.graphics);
        this.player.render(this.graphics);
        this.repaint();
    }
}
