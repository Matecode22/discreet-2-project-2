package com.example.cardashiangame1;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ApplicationController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void playButtonOnAction(Event event) {
        System.out.println("click");
    }
}