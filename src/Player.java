public class Player {
    int x = 0;
    int y = 0;
    boolean hasKey = false;

    public Player(int x, int y, boolean hasKey) {
        this.x = x;
        this.y = y;
        this.hasKey = hasKey;
    }

    public boolean match(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchKey(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.println("You got the key.");
            hasKey = true;
            return true;
        } else {
            return false;
        }
    }
}