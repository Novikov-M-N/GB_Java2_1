package com.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;

class MyWindow6 extends JFrame {
    public MyWindow6() {
        setBounds(500, 500, 400, 300);
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[10];
        setLayout(null);//new GridLayout(4, 3));
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            add(jbs[i]);
        }
        setVisible(true);

    }
}

public class MainClass6 {
    public static void main(String[] args) {
        new MyWindow6();
    }
}
