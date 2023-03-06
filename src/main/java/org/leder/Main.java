package org.leder;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Main ex = new Main();
            ex.setVisible(true);
        });
    }

    public Main () {
        initUI();
    }

    private void initUI() {
        add(new Board());

        setResizable(false);
        pack();

        setSize(1000, 750);

        setTitle("Doggo 521");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
}