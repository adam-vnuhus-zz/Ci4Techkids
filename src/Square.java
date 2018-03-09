public class Square extends GameObject {

    public int dx;
    public int dy;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
    }

    @Override
    public void run() {
        super.run();
        if (this.x >= 400 || this.x < 0) {
            this.dx = -this.dx;
        } else if (this.y >= 600 || this.y < 0) {
            this.dy = -this.dy;
        }
        this.x += this.dx;
        this.y += this.dy;

    }
}
