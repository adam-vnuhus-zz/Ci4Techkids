import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;

    private long lastTime = System.nanoTime();

    public GameWindow() {

        this.setSize(400, 600);
        this.gameCanvas = new GameCanvas();
        this.add(gameCanvas);
        this.setVisible(true);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.player.x = e.getX();
                gameCanvas.player.y = e.getY();
            }
        });
    }

    public void gameLoop() {

        while (true) {

            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {

                this.gameCanvas.renderAll();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
