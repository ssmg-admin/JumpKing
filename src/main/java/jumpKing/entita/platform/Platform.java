package jumpKing.entita.platform;

import jumpKing.entita.Entita;

import java.awt.*;

/**
 * Static platform entity that can be rendered as a rectangle.
 * Platforms are typically used as solid ground the player can stand on.
 *
 * How it works: like Player, Platform.draw() is called during painting and uses
 * the platform's current bounds for rendering.
 */
public class Platform extends Entita {

    /**
     * Creates a platform at the given position and size.
     *
     * @param x left position in pixels.
     * @param y top position in pixels.
     * @param width platform width in pixels.
     * @param height platform height in pixels.
     * @param isAlive active state flag.
     */
    public Platform(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    /**
     * Draws the platform as a filled red rectangle.
     * The rectangle uses the platform's current position and size.
     *
     * @param g graphics context.
     */
    @Override
    public void draw(Graphics g){
        // Simple placeholder render so platforms are visible.
        g.setColor(Color.red);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
