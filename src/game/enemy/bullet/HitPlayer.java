package game.enemy.bullet;

import base.GameObjectManager;
import game.player.Player;
import game.player.bullet.Bullet;
import game.square.Square;
import physic.BoxCollider;

public class HitPlayer {

    public void run(BulletEnemy bulletEnemy) {
        BoxCollider boxCollider = bulletEnemy.boxCollider;
        Player player = GameObjectManager.instance.checkCollisionPlayer(boxCollider);
        if (player != null) {
            player.isAlive = false;
            bulletEnemy.getHit();
        }
    }
}
