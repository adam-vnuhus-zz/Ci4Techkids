import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class SquareSpawner extends GameObject {

    private int count = 0;
    private Random random = new Random();


    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 40) {
            Square square = new Square();
            square.x = 1;
            square.y = 1;
            square.dx = 3;
            square.dy = 2;
            GameObject.add(square);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }
}
