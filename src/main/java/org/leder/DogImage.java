package org.leder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class DogImage {
    private Image doggo;
    private final int imageHeight = 128;
    private final int imageWidth = 128;

    public int getImgWidth() {
        return imageWidth;
    }

    public int getImgHeight() {
        return imageHeight;
    }
    public Image getDogImage() {
        return doggo;
    }

    public void loadImage() {
        String imgPath = scaleImage(imageHeight, imageWidth);
        ImageIcon ii = new ImageIcon(imgPath);
        doggo = ii.getImage();
    }

    private String scaleImage(int imageHeight, int imageWidth){
        String imgPath = "";
        try {
            ImageIcon ii = new ImageIcon("src/resources/Doggo3.png");
            BufferedImage bi = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D g2d = (Graphics2D)bi.createGraphics();
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY));
            boolean b = g2d.drawImage(ii.getImage(), 0, 0, imageWidth, imageHeight, null);
            System.out.println(b);
            ImageIO.write(bi,"png", new File("src/resources/doggoScaled.png"));
            imgPath = "src/resources/doggoScaled.png";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgPath;
    }

}
