package jumpKing.tools;

import jumpKing.entita.Entita;
import java.awt.*;

/**
 * Position and distance helpers for entities.
 *
 * How it works: each method first derives Rectangles from entities using getBounds().
 * Then it performs simple comparisons or math on those rectangles.
 */
public final class PositionTools {

    /**
     * Prevents instantiation of a static utility class.
     */
    private PositionTools() {}

    /**
     * Checks whether entity A is completely above entity B.
     * It calculates both bounding rectangles, then compares the bottom edge of A
     * (y + height) to the top edge of B (y).
     *
     * @param a first entity.
     * @param b second entity.
     * @return true if A is above B without vertical overlap.
     */
    public static boolean isAbove(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();
        // A is above B when its bottom edge is at or above B's top edge.
        return ra.y + ra.height <= rb.y;
    }

    /**
     * Checks whether entity A is completely below entity B.
     * It calculates both bounding rectangles, then compares the top edge of A (y)
     * to the bottom edge of B (y + height).
     *
     * @param a first entity.
     * @param b second entity.
     * @return true if A is below B without vertical overlap.
     */
    public static boolean isBelow(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();
        // A is below B when its top edge is at or below B's bottom edge.
        return ra.y >= rb.y + rb.height;
    }

    /**
     * Computes the Euclidean distance between centers of two entities.
     * It finds the center of each rectangle and then applies the Pythagorean
     * theorem (sqrt(dx^2 + dy^2)).
     *
     * @param a first entity.
     * @param b second entity.
     * @return distance between centers in pixels.
     */
    public static double distanceToEntita(Entita a, Entita b) {
        Rectangle ra = a.getBounds();
        Rectangle rb = b.getBounds();

        // Find center points for each rectangle.
        double centerAx = ra.x + ra.width / 2.0;
        double centerAy = ra.y + ra.height / 2.0;

        double centerBx = rb.x + rb.width / 2.0;
        double centerBy = rb.y + rb.height / 2.0;

        double dx = centerAx - centerBx;
        double dy = centerAy - centerBy;

        // Euclidean distance between the two center points.
        return Math.sqrt(dx * dx + dy * dy);
    }
}
