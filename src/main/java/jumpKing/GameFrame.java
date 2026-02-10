package jumpKing;

import jumpKing.entita.Entita;
import jumpKing.entita.platform.Platform;
import jumpKing.entita.player.Player;
import jumpKing.input.KeyInput;
import jumpKing.input.MouseInput;

import javax.swing.*;
import java.awt.*;

class GameFrame extends JPanel {

    private static final int TIMER_DELAY_MS = 16;

    private final MouseInput mouseInput = new MouseInput();
    private final KeyInput keyInput = new KeyInput();

    private Timer timer;
    private Player player = new Player(400, 400, 64, 64,true);
    private Platform platrofm = new Platform(0, 200, 300, 20,true);


    public GameFrame() {
        addMouseListener(mouseInput);
        addKeyListener(keyInput);

        timer = new Timer(TIMER_DELAY_MS, e -> {
            updateGame();
            repaint();
        });
    }

    public void startGame() {
        timer.start();
    }

    public void updateGame(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        player.draw(g);
        platrofm.draw(g);
    }
}
