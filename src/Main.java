public class Main {

    GameWindow gameWindow;

    public static void main(String[] args) {
        Main main = new Main();
        main.gameWindow = new GameWindow();
        main.gameWindow.gameLoop();
    }
}
