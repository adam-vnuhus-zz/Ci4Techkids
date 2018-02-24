import java.util.ArrayList;
import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {

        Map m = new Map(5, 4);

        Player P = new Player(2, 1, 20, false);

        Key K = new Key(2, 3);

        Exit E = new Exit(4, 3);

        Vector V = new Vector(0, 0);

        Monster M = new Monster(3, 2, 20, false);

        ArrayList<Wall> walls = new ArrayList<>();
//        Wall w1 = new Wall(2, 3);
//        Wall w2 = new Wall(1, 2);
        walls.add(new Wall(4, 1));
        walls.add(new Wall(1, 0));
        walls.add(new Wall(1, 1));


        while (true) {
            for (int y = 0; y < m.width; y++) {
                for (int x = 0; x < m.length; x++) {
                    boolean noWall = false;
                    for (Wall wall : walls) {
                        if (wall.match(x, y)) {
                            System.out.print("W ");
                            noWall = true;
                        }
                    }
                    if (!noWall) {
                        if (P.match(x, y)) {
                            System.out.print("P ");
                        } else if (K.match(x, y) && !P.hasKey) {
                            System.out.print("K ");
                        } else if (E.match(x, y)) {
                            System.out.print("E ");
                        } else if (M.match(x, y) && !M.died) {
                            System.out.print("M ");
                        } else {
                            System.out.print("- ");
                        }
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
            if (P.y >= m.width) P.y = m.width - 1;
            if (P.x < 0) P.x = 0;
            if (P.x >= m.length) P.x = m.length - 1;

            for (Wall wall : walls) {
                if (wall.match(P.x, P.y)) {
                    P.x -= V.x;
                    P.y -= V.y;
                }
            }

            if (P.x == M.x && P.y == M.y) {
                System.out.println("1.Fight!!!");
                System.out.println("2.Running.");
                do {
                    System.out.print("Your choice: ");
                    int choice = keyboardScanner.nextInt();
                    if (choice == 1) {
                        M.hp = P.attack - M.hp;
                        System.out.println("M.hp: " + M.hp);
                    } else if (choice == 2) {
                        break;
                    }
                } while (M.hp > 0);
            }

            if (M.hp == 0) {
                M.died = true;
            }

            P.matchKey(K.x, K.y);

            if (P.match(E.x, E.y)) {
                if (P.hasKey) {
                    System.out.println("You won!!!!!!");
                    break;
                } else {
                    System.out.println("Get the key, dude!!!!");
                }
            }
        }
    }
}

