package jumpKing.tools;

import jumpKing.entita.Entita;

public final class CollisionTools {

    private CollisionTools() {}

    public static boolean collisionRectangle(Entita entitaA, Entita entitaB) {
        return entitaA.getBounds().intersects(entitaB.getBounds());
    }

}
