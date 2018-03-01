package GeoArcade.Lessons;

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
        this.add(this.gameCanvas);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
//                super.mouseMoved(e);
//                System.out.println(e.getX() + ", " + e.getY());
                gameCanvas.positionPlayerX = e.getX();      //Keo toa do player tu gameCanvas sang gameWindow
                gameCanvas.positionPlayerY = e.getY();
//                gameCanvas.repaint();
            }
        });
//        System.exit(1);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                System.exit(1);
            }
        });
        this.setVisible(true);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                this.gameCanvas.run();
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }

}
