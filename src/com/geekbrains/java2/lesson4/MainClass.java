package com.geekbrains.java2.lesson4;

import javax.swing.*;

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Test Window");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setVisible(true);
    }
}

public class MainClass {
    public static void main(String[] args) {
        new MyWindow();
    }
}
