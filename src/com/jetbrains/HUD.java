package com.jetbrains;

import java.awt.*;

public class HUD {
    private int score1, score2;
    private boolean win1 = false, win2 = false;
    private Handler handler;

    public HUD(Handler handler) {this.handler = handler;}

    public void tick(){
        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Ball)
            {
                if(tempObject.getY() <= 0)
                {
                    score1++;
                    handler.removeObject(tempObject);
                    if(score1 == 10)
                        win1 = true;
                    else handler.addObject(new Ball(Main.width/2-32, Main.height/2-32, ID.Ball));
                }

                if(tempObject.getY() >= Main.height - 45)
                {
                    score2++;
                    handler.removeObject(tempObject);
                    if(score2 == 10)
                        win2 = true;
                    else handler.addObject(new Ball(Main.width/2-32, Main.height/2-32, ID.Ball));
                }
            }

            if(tempObject.getID() == ID.Player1)
            {
                if(KeyInput.counter1 == 0 || KeyInput.counter1 == 3)
                    tempObject.setVelX(0);
                if(KeyInput.counter1 == 1)
                    tempObject.setVelX(5);
                if(KeyInput.counter1 == 2)
                    tempObject.setVelX(-5);
            }

            if(tempObject.getID() == ID.Player2)
            {
                if(KeyInput.counter2 == 0 || KeyInput.counter2 == 3)
                    tempObject.setVelX(0);
                if(KeyInput.counter2 == 1)
                    tempObject.setVelX(5);
                if(KeyInput.counter2 == 2)
                    tempObject.setVelX(-5);
            }
        }
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawString("Score: " + score1 + "-" + score2, 15, 30);

        if(win1 == true)
            g.drawString("Player 1 wins!", Main.width/2 - 32,Main.height/2-32);
        if(win2 == true)
            g.drawString("Player 2 wins!", Main.width/2 - 32,Main.height/2-32);
    }

}
