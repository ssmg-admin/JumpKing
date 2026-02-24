package jumpKing.entita.platform;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class ManagerPlatform {
    private ArrayList<Platform> platforms;

    public ManagerPlatform() {
        this.platforms = new ArrayList<>();
    }

    public void addPlatform() {
        Random rand = new Random();
        int x = rand.nextInt(1,999);
        int y = rand.nextInt(1,999);

        Platform platform = new Platform(x,y,60,5,true);
        this.platforms.add(platform);
    }

    public void drawPlatforms(Graphics g) {
        for (Platform platform : this.platforms) {
            platform.draw(g);
        }
    }




}
