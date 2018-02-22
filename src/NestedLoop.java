import java.util.Scanner;

/**
 * Created by huynq on 2/3/18.
 */
public class NestedLoop {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        int n = 5;
        int m = 4;

        int Px = 3;
        int Py = 1;

        int Ex = 4;
        int Ey = 3;

        int Kx = 2;
        int Ky = 3;

        int Wx = 2;
        int Wy = 1;

        boolean hasKey = false;
        boolean hasWall = false;

        while (true) {
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (x == Px && y == Py) {
                        System.out.print("P ");
                    }
                    else if (x == Ex && y == Ey) {
                        System.out.print("E ");
                    }
                    else if (x == Kx && y == Ky && !hasKey) {
                        System.out.print("K ");
                    }
                    else if (x == Wx && y == Wy) {
                        System.out.print("W ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }

            // 1. Ask user which direction?
            System.out.print("Your move (W, A, S, D)?: ");
            // QuaN dep TRai => QUAN DEP TRAI
            // QuaN dep TRai => quan dep trai
            String direction = keyboardScanner.nextLine();

            if (Px == Wx && Py == Wy) {
                hasWall = true;
            }

            // 2. Direction => update x, y
            if (direction.equalsIgnoreCase("W")) {
               Py--;
               if (Py == Wy && Px == Wx) {
                   Py++;
               }
            }
            else if(direction.equalsIgnoreCase("S")) {
                Py++;
                if (Py == Wy && Px == Wx) {
                    System.out.println("Can't go throughout the wall");
                    Py--;
                }
            }
            else if(direction.equalsIgnoreCase("A")) {
                Px--;
                if (Py == Wy && Px == Wx) {
                    Px++;
                }
            }
            else if(direction.equalsIgnoreCase("D")) {
                Px++;
                if (Py == Wy && Px == Wx) {
                    Px--;
                }
            }

            // Clamp
            if (Py < 0) Py = 0;
            if (Py >= m) Py = m - 1;

            if (Px < 0) Px = 0;
            if (Px >= n) Px = n - 1;

            if (Px == Kx && Py == Ky) {
                hasKey = true;
                System.out.println("You picked up a key");
            }


            if (Px == Ex && Py == Ey) {
                if (hasKey) {
                    System.out.println("You won!!!");
                    break;
                }
                else {
                    System.out.println("Get the key, dude!");
                }
            }
            // 3. Re-print map
        }
    }
}