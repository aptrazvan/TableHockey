package com.jetbrains;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Ball extends GameObject {
    public Ball(int x, int y, ID id) {
        super(x, y, id);
    }

    public void tick() {
        int r = ThreadLocalRandom.current().nextInt(-7, 7 + 1);
        int p = ThreadLocalRandom.current().nextInt(-7, 7 + 1);

        x+= velX;
        y+= velY;

        if(x<=0 || x>= Main.width-23)
            velX = -velX;

        if(Math.abs(velX) < 3) velX = r;
        if(Math.abs(velY) < 3) velY = p;
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
}
