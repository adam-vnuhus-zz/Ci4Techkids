import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {

    public BufferedImage image;
    public int x;
    public int y;

    public Background(BufferedImage image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Background(){

    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}
