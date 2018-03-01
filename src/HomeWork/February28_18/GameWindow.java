package HomeWork.February28_18;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;

    public GameWindow() {

        this.setSize(400, 600);
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {

                gameCanvas.positionPlayerX = e.getX();
                gameCanvas.positionPlayerY = e.getY();
                gameCanvas.repaint();
            }
        });
        this.setVisible(true);
    }

    public void gameLoop() {
        while (true) {
            this.gameCanvas.run();
        }
    }
}
