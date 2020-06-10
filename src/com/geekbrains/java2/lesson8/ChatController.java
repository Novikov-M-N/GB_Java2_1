package com.geekbrains.java2.lesson8;

import com.geekbrains.java2.lesson8.multiscene.Stageable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ChatController implements Stageable {
    private Stage stage;

    @FXML
    TextArea messageArea;

    @FXML
    TextField newMessage;

    @FXML
    Button sendButton;

    @FXML
    ListView nickList;

    public void initialize(){
        ObservableList<String> nickListItems = FXCollections.observableArrayList();
        nickListItems.add("All");
        nickList.setItems(nickListItems);
        nickList.getSelectionModel().select(0);
    }

    public void sendMessageTypeAction(ActionEvent actionEvent) {
        String messageText = newMessage.getText().trim();
        if(!messageText.isEmpty()) {
            messageArea.appendText(messageText+System.lineSeparator());
            newMessage.clear();
        }
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
