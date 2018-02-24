public class Player {
    int x = 0;
    int y = 0;
    int attack = 0;
    boolean hasKey = false;

    public Player(int x, int y, int atk, boolean hasKey) {
        this.x = x;
        this.y = y;
        this.attack = atk;
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