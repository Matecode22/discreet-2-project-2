package com.example.cardashiangame1.views.game;

import com.example.cardashiangame1.Application;
import com.example.cardashiangame1.controller.Graph;
import com.example.cardashiangame1.controller.Kanye;
import com.example.cardashiangame1.views.MyView;
import com.example.cardashiangame1.views.home.HomeView;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GameView extends MyView {
    public static final float X_LENGTH = 1573, Y_LENGTH = 745;

    Canvas canvas = new Canvas();

    Graph graph = new Graph();

    Kanye kanye = new Kanye();

    public GameView(Stage stage) {
        super(stage);

        this.build();
    }

    @Override
    public void build() {
        AnchorPane rootLayout = new AnchorPane();

        rootLayout.getChildren().addAll(getMainAnchorPane());

        try {
            renderCanvas();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        this.scene = new Scene(rootLayout);

        this.scene.setOnKeyPressed(keyEvent -> {
            try {
                switch (keyEvent.getCode()) {
                    case UP -> {
                        int toPosition = this.kanye.posY-1;
                        if (!(toPosition < 0)) {
                            this.kanye.posY = toPosition;
                        }
                        renderCanvas();
                    }
                    case DOWN -> {
                        int toPosition = this.kanye.posY+1;
                        if (!(toPosition > 7)) {
                            this.kanye.posY = toPosition;
                        }
                        renderCanvas();
                    }
                    case LEFT -> {
                        int toPosition = this.kanye.posX-1;
                        if (!(toPosition < 0)) {
                            this.kanye.posX = toPosition;
                        }
                        renderCanvas();
                    }
                    case RIGHT -> {
                        int toPosition = this.kanye.posX+1;
                        if (!(toPosition > 14)) {
                            this.kanye.posX = toPosition;
                        }
                        renderCanvas();
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @NotNull
    private AnchorPane getMainAnchorPane() {
        AnchorPane n = new AnchorPane();
        n.setStyle("-fx-background-color: lightGray;");
        AnchorPane.setTopAnchor(n, 100.0);
        AnchorPane.setLeftAnchor(n, 0.0);
        AnchorPane.setRightAnchor(n, 0.0);
        AnchorPane.setBottomAnchor(n, 0.0);

        n.getChildren().addAll(getCanvas());

        return n;
    }

    @NotNull
    private Canvas getCanvas() {
        canvas.setWidth(2000);
        canvas.setHeight(1000);

        AnchorPane.setTopAnchor(canvas, 0.0);
        AnchorPane.setLeftAnchor(canvas, 0.0);
        AnchorPane.setRightAnchor(canvas, 0.0);
        AnchorPane.setBottomAnchor(canvas, 0.0);

        return canvas;
    }

    private void renderCanvas() throws FileNotFoundException {
        GraphicsContext gc = canvas.getGraphicsContext2D();



        Timeline timeline = new Timeline();

        Image i = new Image(new FileInputStream("src/main/resources/com/example/cardashiangame1/img/rooms.png"));
        gc.drawImage(i, -100, 0, 1900, 1000);

        Image kanyeI = new Image(new FileInputStream("src/main/resources/com/example/cardashiangame1/img/Kanye/Kanye.png"));
        gc.drawImage(kanyeI, kanye.getLocationX(), kanye.getLocationY(), 100, 100);

//        gc.fillRect(kanyePositionX, kanyePositionY, 100, 100);
//        gc.fillRect(1588, maxY, 100, 100);
    }

    @Override
    public void setToStage() {
        super.setToStage();
        this.stage.setMaximized(true);

        Alert a = new Alert(Alert.AlertType.INFORMATION, "Welcome to Kanye West Escaping the Kardashians!\nYour goal is to find the exit while avoiding being caught by the Kardashians.");
//        a.show();  todo: mostrar
    }
}
