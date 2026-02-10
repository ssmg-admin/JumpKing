package jumpKing.tools;

import jumpKing.entita.Entita;

/**
 * Collision helper methods for entities.
 *
 * How it works: this class uses each entity's bounding rectangle (AABB).
 * AABB collision is fast and simple, but it is approximate: it does not care
 * about the actual shape of sprites, only their rectangles.
 */
public final class CollisionTools {

    /**
     * Prevents instantiation of a static utility class.
     */
    private CollisionTools() {}

    /**
     * Checks whether two entities' bounding boxes intersect.
     * This works by getting each entity's Rectangle bounds and using
     * Rectangle.intersects, which checks overlap on both X and Y axes.
     *
     * @param entitaA first entity.
     * @param entitaB second entity.
     * @return true if the rectangles overlap; false otherwise.
     */
    public static boolean collisionRectangle(Entita entitaA, Entita entitaB) {
        // Rectangle.intersects performs a fast AABB overlap check.
        return entitaA.getBounds().intersects(entitaB.getBounds());
    }

}
