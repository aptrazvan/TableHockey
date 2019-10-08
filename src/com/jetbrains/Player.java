package com.jetbrains;

import java.awt.*;

public class Player extends GameObject {

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        if((x>= Main.width-74 && velX > 0) || (x<=0 && velX < 0))
            velX = 0;


        x+= velX;



        collision();
    }

    private void collision(){
        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Ball){
                if(getBounds().intersects(tempObject.getBounds())){
                   tempObject.setVelY(-tempObject.getVelY());
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y,64,9);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 64, 9);
    }
}
