package jumpKing.entita.platform;

import jumpKing.entita.Entita;

import java.awt.*;

public class Platform extends Entita {

    public Platform(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
