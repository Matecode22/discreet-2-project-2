package com.example.cardashiangame1.views;

import com.example.cardashiangame1.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MyView {
    protected final Stage stage;
    protected Scene scene;

    public MyView(Stage stage) {
        this.stage = stage;
    }

    public void build() throws IOException {}

    public void setToStage() {
        this.stage.setScene(this.scene);
    }
}
