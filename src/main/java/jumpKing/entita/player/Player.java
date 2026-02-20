package jumpKing.entita.player;

import jumpKing.GameFrame;
import jumpKing.entita.Entita;
import jumpKing.input.KeyInput;
import jumpKing.tools.CollisionTools;
import jumpKing.tools.PositionTools;

import java.awt.*;
import java.awt.event.KeyEvent;

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
    private GameFrame gameFrame;
    private int speed = 5;
    public Player(int x, int y, int width, int height, boolean isAlive, GameFrame gameFrame) {
        super(x, y, width, height, isAlive);
        this.gameFrame = gameFrame;

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

        double vzdalenost = PositionTools.distanceToEntita(this, gameFrame.getPlatrofm());
        g.drawString(String.valueOf(vzdalenost),50,100);

    }

    public void updatePlayer(){

        if (gameFrame.getKeyInput().isKeyPressed(KeyEvent.VK_W)){
            setY(getY() - speed);
        }

        if (gameFrame.getKeyInput().isKeyPressed(KeyEvent.VK_S)){
            Player player_temp = gameFrame.getPlayer();
            player_temp.setY(getY() + speed);

            if (!CollisionTools.collisionRectangle(gameFrame.getPlatrofm(),  player_temp)){
                setY(getY() + speed);
                System.out.println("s");
            }


        }

        if (gameFrame.getKeyInput().isKeyPressed(KeyEvent.VK_A)){
            setX(getX() - speed);
        }

        if (gameFrame.getKeyInput().isKeyPressed(KeyEvent.VK_D)){
            setX(getX() + speed);
        }




        if (gameFrame.getPlayer().getY() < 700 && !gameFrame.getKeyInput().isKeyPressed(KeyEvent.VK_W)){

            if (!CollisionTools.collisionRectangle(gameFrame.getPlayer(), gameFrame.getPlatrofm())){
                gameFrame.getPlayer().setY(getY() + speed);
            }
        }




    }
}
