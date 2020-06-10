package com.geekbrains.java2.lesson8.multiscene;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxmlInfo {
    private String resource;
    private SceneFlow sceneFlow;
    private Stage stage;
    private Scene scene;

    public FxmlInfo(String resource, SceneFlow sceneFlow, Stage stage) {
        this.resource = resource;
        this.sceneFlow = sceneFlow;
        this.stage = stage;
    }

    public Scene getScene() {
        if(scene == null) {
            scene =new FxmlLoad().load(this);
        }
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public String getResource() {
        return resource;
    }

    public SceneFlow getSceneFlow() {
        return sceneFlow;
    }

    public Stage getStage() {
        return stage;
    }

    public boolean hasScene() {
        return scene != null;
    }
}
