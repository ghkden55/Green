package controller;

import javax.swing.*;
import java.awt.*;

public class ImageDisplayController extends JFrame {
    public ImageDisplayController(String imagePath, int desiredWidth, int desiredHeight) {
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        getContentPane().add(imageLabel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int windowWidth = getWidth();
        int windowHeight = getHeight();
        int xPosition = screenWidth - windowWidth;
        setLocation(xPosition, (screenHeight - windowHeight) / 2);
        setAlwaysOnTop(true);
    }
}

