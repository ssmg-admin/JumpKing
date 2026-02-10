package jumpKing.entita.player;

import jumpKing.entita.Entita;

import java.awt.*;

public class Player extends Entita {

    public Player(int x, int y, int width, int height, boolean isAlive) {
        super(x, y, width, height, isAlive);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

}
