import java.util.ArrayList;
import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {

        Map M = new Map(5, 4);

        Player P = new Player(2, 1);

        Key K = new Key(2, 3);

        Exit E = new Exit(4, 3);

        Vector V = new Vector(0, 0);

        ArrayList<Wall> walls = new ArrayList<>();
//        Wall w1 = new Wall(2, 3);
//        Wall w2 = new Wall(1, 2);
        walls.add(new Wall(3, 1));
        walls.add(new Wall(1, 0));
        walls.add(new Wall(1, 1));


        while (true) {
            for (int y = 0; y < M.width; y++) {
                for (int x = 0; x < M.length; x++) {
                    for (Wall wall : walls) {
                        if (wall.match(x, y)) {
                            System.out.print("W ");
                            x++;
                        }
                    }
                    if (P.match(x, y)) {
                        System.out.print("P ");
                    } else if (K.match(x, y) && !P.hasKey()) {
                        System.out.print("K ");
                    } else if (E.match(x, y)) {
                        System.out.print("E ");
                    } else {
                        System.out.print("- ");
                    }
                }
                System.out.println();
            }

            Scanner keyboardScanner = new Scanner(System.in);
            System.out.print("Your move (w,a,s,d): ");
            String command = keyboardScanner.nextLine();

            V.x = 0;
            V.y = 0;

            if (command.equalsIgnoreCase("W")) {
                V.y = -1;
            } else if (command.equalsIgnoreCase("S")) {
                V.y = 1;
            } else if (command.equalsIgnoreCase("A")) {
                V.x = -1;
            } else if (command.equalsIgnoreCase("D")) {
                V.x = 1;
            }

            P.y += V.y;
            P.x += V.x;

            if (P.y < 0) P.y = 0;
            if (P.y >= M.width) P.y = M.width - 1;
            if (P.x < 0) P.x = 0;
            if (P.x >= M.length) P.x = M.length - 1;

            if (P.match(K.x, K.y)) {

            }
        }
    }
}

