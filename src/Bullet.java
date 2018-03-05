import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {
    public BufferedImage image;
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Bullet() {

    }

    public Bullet(BufferedImage image, int x, int y, int dx, int dy) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDx() {
        return dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getDy() {
        return dy;
    }

    public void move() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, null);
    }
}
