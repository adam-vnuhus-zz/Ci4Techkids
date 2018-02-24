public class Monster {
    int x = 0;
    int y = 0;
    int hp = 0;
    boolean died = false;

    public Monster(int x, int y, int hp, boolean died) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.died = died;
    }

    public boolean match(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        } else {
            return false;
        }
    }
}
