import java.util.Vector;

public class CircleEnemy extends GameObject {

    private float circlePositionX = 3;
    private float circlePositionY = 10;
    private float R = 40;
    private double angle = 0.0;
    private int count = 0;

    private FrameCounter frameCounter;

    private Vector<Square> squares = new Vector<>();
    public Vector2D velocity = new Vector2D();

    public CircleEnemy() {
        this.frameCounter = new FrameCounter(20);
    }

    public void create() {

        for (int i = 0; i < 36; i++) {
//            if (this.frameCounter.run()) {
                Square square = new Square();
                if (angle >= 0 && angle <= 360) {

                    square.position.set(this.position.add((circlePositionX  + 4*R * (float) Math.cos(Math.PI * angle / 180)),
                            (circlePositionY  + 4*R * (float) Math.sin(Math.PI * angle / 180))));
                    angle += 10;
                }
                square.velocity.set(this.velocity);
                this.squares.add(square);
                GameObject.add(square);
//            }
        }
    }

    @Override
    public void run() {
        super.run();
        if (this.position.x <= 0) {
            if (this.count >= 10) {
                this.count = 0;
                this.velocity.set(3, 0);
            } else {
                this.velocity.set(0, 3);
                this.count += 1;
            }

        }
        if (this.position.x >= 400 - 20 * 5 - 20 * 4) {
            if (this.count >= 10) {
                this.count = 0;
                this.velocity.set(-3, 0);
            } else {
                this.velocity.set(0, 3);
                this.count += 1;
            }

        }
        this.position.addUp(this.velocity);
        this.squares.forEach(square -> square.velocity.set(velocity));
    }
}

