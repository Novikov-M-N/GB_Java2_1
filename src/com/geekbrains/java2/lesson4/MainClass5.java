package com.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;

class MyWindow5 extends JFrame {
    public MyWindow5() {
        setBounds(500, 500, 400, 300);
        setTitle("FlowLayoutDemo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JButton[] jbs = new JButton[20];
        setLayout(new FlowLayout());
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton("#" + i);
            add(jbs[i]);
        }
        setVisible(true);

    }
}

public class MainClass5 {
    public static void main(String[] args) {
        new MyWindow5();
    }
}
