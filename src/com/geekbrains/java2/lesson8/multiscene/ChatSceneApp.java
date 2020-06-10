package com.geekbrains.java2.lesson8.multiscene;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class ChatSceneApp extends Application {
    private static final String LOGIN_FXML = "../AuthDialog.fxml";
    private static final String CHAT_FXML = "../ChatClient.fxml";

    private static Map<SceneFlow, FxmlInfo> scenes = new HashMap<>();

    public static void main(String[] args) {
        launch(args);
    }

    public static void updateScene(SceneFlow sceneFlow, FxmlInfo info) {
        scenes.put(sceneFlow, info);
    }

    public static Map<SceneFlow, FxmlInfo> getScenes() {
        return scenes;
    }

    @Override
    public void start(Stage primaryStage) {
        scenes.put(SceneFlow.LOGIN, new FxmlInfo(LOGIN_FXML, SceneFlow.LOGIN, primaryStage));
        scenes.put(SceneFlow.CHAT, new FxmlInfo(CHAT_FXML, SceneFlow.CHAT, primaryStage));
        primaryStage.setScene(scenes.get(SceneFlow.LOGIN).getScene());
        primaryStage.setTitle("Login");
        primaryStage.show();
    }
}
