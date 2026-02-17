package jumpKing.entita;

import java.awt.*;

/**
 * Base entity with position, size, and alive state.
 * Subclasses can override draw() to render different visuals.
 *
 * Coordinate system:
 * - Swing uses a pixel coordinate system.
 * - x increases to the right.
 * - y increases downward.
 * So "moving up" means decreasing y.
 */
public class Entita {

    // Position and size of the entity in pixels. These values are the single source of truth
    // for where the entity is and how big it is.
    private int x, y, width, height;
    // Simple active flag (e.g., used to remove or disable an entity).
    private boolean isAlive;

    /**
     * Creates a new entity.
     *
     * @param x left position in pixels.
     * @param y top position in pixels.
     * @param width width in pixels.
     * @param height height in pixels.
     * @param isAlive active state flag.
     */
    public Entita(int x, int y, int width, int height, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = isAlive;
    }

    /**
     * Draws the entity. Subclasses should override to provide visuals.
     *
     * @param g graphics context.
     */
    public void draw(Graphics g){}

    /**
     * Returns the bounding rectangle for collision checks.
     * It builds a new Rectangle each call using the current x/y/width/height.
     * This avoids storing a stale rectangle if the entity moves.
     *
     * @return rectangle representing the entity bounds.
     */
    public Rectangle getBounds() {return new Rectangle(x, y, width, height);}
    /**
     * @return left position in pixels.
     */
    public int getX() {return x;}
    /**
     * @param x new left position in pixels.
     */
    public void setX(int x) {this.x = x;}
    /**
     * @return top position in pixels.
     */
    public int getY() {return y;}
    /**
     * @param y new top position in pixels.
     */
    public void setY(int y) {this.y = y;}
    /**
     * @return width in pixels.
     */
    public int getWidth() {return width;}
    /**
     * @param width new width in pixels.
     */
    public void setWidth(int width) {this.width = width;}
    /**
     * @return height in pixels.
     */
    public int getHeight() {return height;}
    /**
     * @param height new height in pixels.
     */
    public void setHeight(int height) {this.height = height;}
    /**
     * @return true if the entity is active.
     */
    public boolean isAlive() {return isAlive;}
    /**
     * @param alive new active state flag.
     */
    public void setAlive(boolean alive) {isAlive = alive;}
}
