import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {

    BufferedImage background;
    BufferedImage player;
    Square square;
    BufferedImage backBuffered;
    Graphics graphics;
    int positionPlayerX;
    int positionPlayerY;
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
            this.square = new Square(ImageIO.read(new File("resources/square/enemy_square_small.png")), 20, 0, 0, 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        //Draw image
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void runAll() {
        this.square.run();
    }

    public void renderAll() {
        this.graphics.drawImage(this.background, 0, 0, null);
        this.graphics.drawImage(this.player, this.positionPlayerX, this.positionPlayerY, null);
        this.square.render(this.graphics);
        this.repaint();
    }
}
