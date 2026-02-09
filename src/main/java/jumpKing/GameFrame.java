package jumpKing;

import javax.swing.*;
import java.awt.*;

/**
 * GameFrame je hlavní herní panel.
 * Obsahuje:
 * - herní smyčku (Timer)
 * - delta-time výpočet
 * - vstup z klávesnice
 * - vykreslování herních objektů
 */
class GameFrame extends JPanel {

    /**
     * Konstruktor GameFrame:
     * - aktivuje vstup z klávesnice
     * - spustí herní smyčku (Timer)
     */
    public GameFrame() {

        // Panel musí být fokusovatelný, aby mohl přijímat klávesy
        setFocusable(true);

        /**
         * Herní smyčka – Timer se spustí každých cca 16 ms (≈ 60 FPS)
         * Timer volá anonymní funkci (lambda) e -> { ... }
         */
        new Timer(16, e -> {


            repaint();

        }).start();
    }

    /**
     * paintComponent je metoda Swingu, která vykresluje grafiku.
     * Každý snímek se zavolá po repaint().
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
