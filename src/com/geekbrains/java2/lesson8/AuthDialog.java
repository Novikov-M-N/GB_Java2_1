package com.geekbrains.java2.lesson8;

import com.geekbrains.java2.lesson8.multiscene.ChatSceneApp;
import com.geekbrains.java2.lesson8.multiscene.SceneFlow;
import com.geekbrains.java2.lesson8.multiscene.Stageable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class AuthDialog implements Stageable {
    private Stage stage;
    public Socket socket;
    private boolean isLogin; // Флаг: залогинился или нет пользователь
    long countdown; // Обратный отсчёт: сколько миллисекунд осталось на то, чтобы залогиниться

    @FXML
    Label authInfo; // Информация о ходе авторизации и ошибках

    @FXML
    Label authCountdown; // Отображение обратного отсчёта

    @FXML
    AnchorPane rootPane;

    @FXML
    TextField userName;

    @FXML
    PasswordField userPassword;

    @FXML
    /**
     * Что происходит при создании окна: запускаем обратный отсчёт в отдельном потоке
     */
    private void initialize() {
        isLogin = false;
        long startTime = System.currentTimeMillis();
        new Thread(()->{
            final int COUNTDOWN_LIMIT = 120000; // Здесь задаём, сколько времени даётся пользователю на авторизацию
            countdown = COUNTDOWN_LIMIT;
            while (countdown > 0 && !isLogin) {
                countdown = startTime - System.currentTimeMillis() + COUNTDOWN_LIMIT;
                try {
                    Platform.runLater(()->{ authCountdown.setText("Time for login: " + countdown / 1000 + " s."); });
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!isLogin) { Platform.exit(); } // Если пользователь не авторизовался за отведённое время, закрываем приложение
        }).start();
    }

    public void submitUserPassword(ActionEvent actionEvent) {
        // Обработку авторизации делаем только если пользователь ввёл логин и пароль
        if (!userName.getText().isEmpty() || !userPassword.getText().isEmpty()) {
            try {
                socket = ChatSceneApp.getScenes().get(SceneFlow.CHAT).getSocket();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String authMessage = "/auth " + userName.getText() + " " + userPassword.getText();
                out.writeUTF(authMessage);
                while (true) {
                    if (in.available() > 0) {
                        String strFromServer = in.readUTF();
                        // Если сервер дал добро на авторизацию, получаем ник и переходим к чату
                        if (strFromServer.startsWith("/authOk")) {
                            ChatSceneApp.getScenes().get(SceneFlow.CHAT).setNick(strFromServer.split("\\s")[1]);
                            stage.setTitle("Chat as " + ChatSceneApp.getScenes().get(SceneFlow.CHAT).getNick());
                            stage.setScene(ChatSceneApp.getScenes().get(SceneFlow.CHAT).getScene());
                            isLogin = true;
                        } else { // В обратном случае выводим ответ сервера в метку-инфо и ничего не делаем
                            authInfo.setText(strFromServer);
                        }
                        break;
                    }
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
