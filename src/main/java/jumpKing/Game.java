package jumpKing;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window that hosts all screens.
 * It uses CardLayout to switch between the menu and the game panel.
 *
 * How the application flow works:
 * - main(String[]) schedules GUI creation on the Swing EDT.
 * - The Game() constructor creates the window and shows the menu card.
 * - MenuPanel runs the provided callback when the Start button is clicked.
 * - startGame() creates GameFrame, shows it, requests focus, and starts the loop.
 */
public class Game extends JFrame {

    private static final String CARD_MENU = "menu";
    private static final String CARD_GAME = "game";

    // CardLayout allows simple switching between different screens.
    private CardLayout layout;
    // Container holds each screen as a separate "card".
    private JPanel container;

    /**
     * Builds the main window and shows the menu screen first.
     * CardLayout stores panels under string keys and switches the visible one
     * using layout.show(container, key).
     */
    public Game() {
        setTitle("Game Window");
        setSize(1280, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize the card container used for screen switching.
        layout = new CardLayout();
        container = new JPanel(layout);

        // The menu panel triggers startGame() when the Start button is clicked.
        // ActionListener callbacks run on the EDT, so switching cards is safe here.
        MenuPanel menuPanel = new MenuPanel(() -> {
            startGame();
        });

        container.add(menuPanel, CARD_MENU);
        add(container);
        // Show the menu as the default screen.
        layout.show(container, CARD_MENU);
    }

    /**
     * Creates the game panel, switches to it, and starts the game loop.
     * We add a new GameFrame as a card, then show it and request focus so
     * keyboard events go to the game panel.
     */
    private void startGame() {
        // Create a new game panel and show it.
        GameFrame gameFrame = new GameFrame();

        container.add(gameFrame, CARD_GAME);
        layout.show(container, CARD_GAME);

        // Request focus so key input goes to the game panel, then start the loop.
        gameFrame.requestFocusInWindow();
        gameFrame.startGame();
    }

    /**
     * Application entry point. Starts the UI on the Swing EDT.
     *
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Everything Swing-related should be created on the EDT to avoid race conditions.
            new Game().setVisible(true);
        });
    }
}
