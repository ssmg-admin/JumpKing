package jumpKing;

import jumpKing.entita.Entita;
import jumpKing.entita.platform.Platform;
import jumpKing.entita.player.Player;
import jumpKing.input.KeyInput;
import jumpKing.input.MouseInput;
import jumpKing.tools.CollisionTools;
import jumpKing.tools.PositionTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Main in-game panel that hosts gameplay objects and the update/render loop.
 * It wires input listeners once and uses a Swing Timer to repeatedly call
 * update logic and repaint on the Swing EDT (Event Dispatch Thread).
 *
 * How it works (high level):
 * - startGame() starts a Swing Timer.
 * - Every TIMER_DELAY_MS ms the timer calls updateGame().
 * - After updating, we call repaint() to request a redraw.
 * - Swing later calls paintComponent(Graphics) where we draw entities.
 *
 * Important: Timer events and painting both happen on the Swing EDT, so you must
 * keep updateGame() fast (do not sleep, do not do heavy blocking work),
 * otherwise the UI will freeze.
 */
public class GameFrame extends JPanel {

    // Timer interval in milliseconds; 16 ms targets roughly 60 FPS.
    private static final int TIMER_DELAY_MS = 16;

    // Input listeners are attached to this panel to capture user controls.
    private final MouseInput mouseInput = new MouseInput();
    private final KeyInput keyInput = new KeyInput();

    // Swing Timer drives the game loop on the EDT to keep rendering thread-safe.
    private Timer timer;
    // Game entities that will be updated and rendered each frame.
    private Player player = new Player(400, 400, 64, 64,true, this);
    private Platform platrofm = new Platform(0, 200, 300, 50,true);


    /**
     * Creates the game panel, attaches input listeners, and prepares the loop.
     * This works by registering MouseInput/KeyInput on this JPanel and
     * creating a Swing Timer that fires every TIMER_DELAY_MS to call
     * updateGame() followed by repaint(), both on the EDT.
     */
    public GameFrame() {
        // A component must be focusable to receive KeyListener events.
        // We request focus when the game starts (see Game.startGame()).
        setFocusable(true);
        // Prevents Swing from using TAB/Shift+TAB for focus traversal, which can
        // otherwise "steal" key events in games.
        setFocusTraversalKeysEnabled(false);


        addMouseListener(mouseInput);
        addKeyListener(keyInput);

        // Game loop: update state first, then request a repaint.
        timer = new Timer(TIMER_DELAY_MS, e -> {
            updateGame();
            repaint();
        });
    }

    /**
     * Starts the Swing Timer so the game begins updating and rendering.
     * Internally, Timer schedules an ActionEvent at fixed intervals on the EDT.
     */
    public void startGame() {
        timer.start();
    }

    /**
     * Updates the game state for a single frame.
     * This method should update positions, handle input, and resolve collisions.
     * Because the Swing Timer calls it on the EDT, it stays in sync with rendering.
     */
    private void updateGame(){
        player.updatePlayer();
    }

    /**
     * Renders the current game state.
     * repaint() queues a paint request; Swing then calls paintComponent on the EDT.
     * Always call super.paintComponent to clear the background before drawing.
     *
     * @param g Graphics context provided by Swing for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw entities in the correct order so they appear on screen.
        player.draw(g);
        platrofm.draw(g);
    }

    public Platform getPlatrofm() {
        return platrofm;
    }

    public KeyInput getKeyInput() {
        return keyInput;
    }

    public MouseInput getMouseInput() {
        return mouseInput;
    }

    public Player getPlayer() {
        return player;
    }
}
