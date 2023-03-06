package org.leder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel {
    private Image image;
    private int imgWidth;
    private int imgHeight;
    private int x = 498;
    private int y = 540;
    private int i = 0;
    private boolean invert = false;
    private boolean writeMessage = false;
    private ArrayList<Point> line = new ArrayList<>();


    public Board() {
        initBoard();
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[][] coord = {
                        {790, 248},
                        {630, 88},
                        {498, 220},
                        {366, 88},
                        {206, 248},
                        {498, 540},
                };
                if (i == 0) {
                    moveDoggoNE();
                    if (x == coord[0][0] && y == coord[0][1]) {
                        i++;
                        invert = true;
                    }
                } else if (i == 1) {
                    moveDoggoNW();
                    if(x == coord[1][0] && y == coord[1][1]) {
                        i++;
                    }
                } else if (i == 2) {
                    moveDoggoSW();
                    if(x == coord[2][0] && y == coord[2][1]) {
                        i++;
                    }
                } else if (i == 3) {
                    moveDoggoNW();
                    if(x == coord[3][0] && y == coord[3][1]) {
                        i++;
                    }
                } else if (i == 4) {
                    moveDoggoSW();
                    if(x == coord[4][0] && y == coord[4][1]) {
                        i++;
                        invert = false;
                    }
                } else if (i == 5) {
                    moveDoggoSE();
                    if(x == coord[5][0] && y == coord[5][1]) {
                        i++;
                    }
                } else {
                    writeMessage = true;
                }
                line.add(new Point(x, y));
                repaint();
            }
        });
        timer.start();
    }

    public void setImage (Image img) {
        this.image = img;
    }
    private void initBoard() {
        DogImage doggoImg = new DogImage();
        imgWidth = doggoImg.getImgWidth();
        imgHeight = doggoImg.getImgHeight();

        doggoImg.loadImage();
        setImage(doggoImg.getDogImage());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g.setColor(Color.red);
        for (Point p : line) {
            g.drawOval(p.getX(), p.getY(), 5,5);
        }

        if (invert) {
            g.drawImage(image, x + imgWidth, y, -imgWidth, imgHeight, null);
        } else {
            g.drawImage(image, x, y, null);
        }

        if (writeMessage) {
            g.drawString("Dogs love Java!", 375, 300);
        }
        g.dispose();
    }

    private void moveDoggoNE() {
        x+=4;
        y-=4;
    }

    private void moveDoggoNW() {
        x-=4;
        y-=4;
    }
    private void moveDoggoSW() {
        x-=4;
        y+=4;
    }
    private void moveDoggoSE() {
        x+=4;
        y+=4;
    }
}
