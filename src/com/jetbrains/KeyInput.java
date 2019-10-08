package com.jetbrains;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private Handler handler;
    public static int counter1 = 0, counter2;

    public KeyInput(Handler handler) {this.handler = handler;}

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Player1)
            {
                if(key == KeyEvent.VK_D && tempObject.getX()<Main.width-37)
                {
                    if(counter1 == 0) counter1 = 1;
                    else if(counter1 == 2) counter1 = 3;
                }

                if(key == KeyEvent.VK_A && tempObject.getX()>0)
                {
                    if(counter1 == 0) counter1 = 2;
                    else if(counter1 == 1) counter1 = 3;
                }
            }

            if(tempObject.getID() == ID.Player2)
            {
                if(key == KeyEvent.VK_RIGHT && tempObject.getX()<Main.width-37)
                {
                    if(counter2 == 0) counter2 = 1;
                    else if(counter2 == 2) counter2 = 3;
                }
                if(key == KeyEvent.VK_LEFT && tempObject.getX()>0)
                {
                    if(counter2 == 0) counter2 = 2;
                    else if(counter2 == 1) counter2 = 3;
                }
            }
        }


    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        for(int i=0; i<handler.object.size(); i++)
        {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Player1)
            {
                if(key == KeyEvent.VK_D)
                {
                    if(counter1 == 1) counter1 = 0;
                    else if(counter1 == 3) counter1 = 2;
                }
                if(key == KeyEvent.VK_A)
                {
                    if(counter1 == 2) counter1 = 0;
                    else if(counter1 == 3) counter1 = 1;
                }
            }

            if(tempObject.getID() == ID.Player2)
            {
                if(key == KeyEvent.VK_RIGHT)
                {
                    if(counter2 == 1) counter2 = 0;
                    else if(counter2 == 3) counter2 = 2;
                }
                if(key == KeyEvent.VK_LEFT)
                {
                    if(counter2 == 2) counter2 = 0;
                    else if(counter2 == 3) counter2 = 1;
                }
            }
        }

        if(key == KeyEvent.VK_ESCAPE) System.exit(1);
    }
}
