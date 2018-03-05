import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
                if (e.getX() > 40 && e.getX() < 409 && e.getY() > 44 && e.getY() < 600) {
                    gameCanvas.player.x = e.getX() - 48;
                    gameCanvas.player.y = e.getY() - 42;

                }

                /*if (e.getY() > 0 && e.getY() < 590)*/
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {

        while (true) {

            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.renderAll();
                this.gameCanvas.runAll();
                this.repaint();
                lastTime = currentTime;
            }
        }
    }
}
