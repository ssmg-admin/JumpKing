package jumpKing.entita.player;

import jumpKing.entita.Entita;

import java.awt.*;

/**
 * Player entity rendered as a rectangle.
 * In a more complete game this could be replaced with sprites or animations.
 *
 * How it works: draw() is called from GameFrame.paintComponent(...) every frame.
 * The player renders itself based on its current position and size stored in Entita.
 */
public class Player extends Entita {

    /**
     * Creates a player at the given position and size.
     *
     * @param x left position in pixels.
     * @param y top position in pixels.
     * @param width player width in pixels.
     * @param height player height in pixels.
     * @param isAlive active state flag.
     */
    public Player(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    /**
     * Draws the player as a filled green rectangle.
     * The Graphics context draws directly onto the panel in pixel coordinates.
     *
     * @param g graphics context.
     */
    @Override
    public void draw(Graphics g){
        // Simple placeholder render so we can see the player on screen.
        g.setColor(Color.green);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

}
