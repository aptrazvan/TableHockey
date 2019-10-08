package com.jetbrains;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class Main extends Canvas implements Runnable
{

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int width = 640, height = width /12*9;
    Random r;
    private Thread thread;
    private boolean running = false;
    Handler handler;
    HUD hud;
    
    public Main()
    {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        hud = new HUD(handler);
        r = new Random();

        new Window(width, height, "TableHockey", this);

        handler.addObject(new Player(width/2 - 32,height-64,ID.Player1,handler));
        handler.addObject(new Player(width/2 - 32,32,ID.Player2,handler));
        handler.addObject(new Ball(width/2-32, height/2-32, ID.Ball));
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs==null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0, width, height);

        handler.render(g);
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String args[])
    {
        new Main();
    }
}
