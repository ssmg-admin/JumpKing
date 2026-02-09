package jumpKing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * GameFrame je hlavní herní panel.
 * Obsahuje:
 * - herní smyčku (Timer)
 * - delta-time výpočet
 * - vstup z klávesnice
 * - vykreslování herních objektů
 */
class GameFrame extends JPanel implements MouseListener {

    Rectangle player = new Rectangle(400,400,64,64);
    Rectangle platrofma =  new Rectangle(0,200,300,20);

    /**
     * Konstruktor GameFrame:
     * - aktivuje vstup z klávesnice
     * - spustí herní smyčku (Timer)
     */
    public GameFrame() {

        addMouseListener(this);
        // Panel musí být fokusovatelný, aby mohl přijímat klávesy
        setFocusable(true);

        /**
         * Herní smyčka – Timer se spustí každých cca 16 ms (≈ 60 FPS)
         * Timer volá anonymní funkci (lambda) e -> { ... }
         */
        new Timer(16, e -> {

            if (player.y < 500){
                player.y = player.y+5;
            }


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
        g.setColor(Color.RED);
        g.fillRect(platrofma.x, platrofma.y, platrofma.width, platrofma.height);
        g.setColor(Color.GREEN);
        g.fillRect(player.x, player.y, player.width, player.height);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        player.y = player.y - 100;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
