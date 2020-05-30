package com.geekbrains.java2.lesson4Homework;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    public TextArea mainTextArea;
    @FXML
    public TextField messageTextField;

    public void sendMessage(ActionEvent actionEvent) {
        mainTextArea.appendText(messageTextField.getText() + "\n");
        messageTextField.clear();
    }
}
