package com.jetbrains;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas
{
    private static final long serialVersionUID = -240840600533728354L;

    public Window (int width, int height, String title, Main game)
    {
        JFrame frame  = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(game);
        frame.setLocationRelativeTo(null);

        game.start();
    }
}