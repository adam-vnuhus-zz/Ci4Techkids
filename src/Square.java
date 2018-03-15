public class Square extends GameObject {

    public Vector2D velocity;

    public Square() {
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.position.rotate(0.3);
//        this.position.addUp(this.velocity);
        this.position.substractBy(this.velocity);
        this.position.rotate(45.0);
//        this.position.substractBy(this.velocity);
        this.position.addUp(this.velocity);
//        this.position.multiply(2);
    }
}
