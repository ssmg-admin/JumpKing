package jumpKing;

import javax.swing.*;

/**
 * Game je hlavní okno celé aplikace.
 * Vytváří JFrame, nastavuje jeho vlastnosti a přidává do něj GameFrame,
 * což je panel se skutečnou hrou (logika, animace, vykreslování).
 */
public class Game extends JFrame {

    /**
     * Konstruktor vytvoří herní okno a nastaví jeho základní parametry.
     */
    public Game() {
        // Titulek okna
        setTitle("Game Window");

        // Velikost okna (šířka x výška)
        setSize(800, 600);

        // Zavření okna ukončí celou aplikaci
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Umístí okno doprostřed obrazovky
        setLocationRelativeTo(null);

        // Vytvoříme hlavní herní panel (obsahuje smyčku, vykreslování,…)
        GameFrame gameFrame = new GameFrame();

        // Přidáme GameFrame do JFrame
        add(gameFrame);
    }

    /**
     * Hlavní metoda – start aplikace.
     * SwingUtilities.invokeLater zajistí, že GUI poběží v Java EDT vláknu.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Vytvoříme objekt Game a zobrazíme okno
            new Game().setVisible(true);
        });
    }
}
