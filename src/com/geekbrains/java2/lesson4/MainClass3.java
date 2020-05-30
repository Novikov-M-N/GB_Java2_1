package com.geekbrains.java2.lesson4;

import javax.swing.*;
import java.awt.*;

class MyWindow3 extends JFrame {
    public MyWindow3() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        JButton button = new JButton("Button 1 (PAGE_START)");
        add(button, BorderLayout.PAGE_START);
        button = new JButton("Button 2 (CENTER)");
        button.setPreferredSize(new Dimension(200, 100));
        add(button, BorderLayout.CENTER);
        button = new JButton("Button 3 (LINE_START)");
        add(button, BorderLayout.LINE_START);
        button = new JButton("Long-Named Button 4 (PAGE_END)");
        add(button, BorderLayout.PAGE_END);
        button = new JButton("5 (LINE_END)");
        button.setPreferredSize(new Dimension(200, 100));
        add(button, BorderLayout.LINE_END);
        setVisible(true);
    }
}

public class MainClass3 {
    public static void main(String[] args) {
        new MyWindow3();
    }
}
