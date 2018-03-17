package game.enemy.bullet;

import base.GameObject;
import base.Vector2D;
import game.player.bullet.HitSquare;
import physic.BoxCollider;
import utils.Utils;

public class BulletEnemy extends GameObject {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    private HitPlayer hitPlayer;

    public BulletEnemy() {
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10, 10);
        this.hitPlayer  = new HitPlayer();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitPlayer.run(this);
    }

    public void getHit() {
        this.isAlive = false;
        System.out.println("hit player");
    }
}
