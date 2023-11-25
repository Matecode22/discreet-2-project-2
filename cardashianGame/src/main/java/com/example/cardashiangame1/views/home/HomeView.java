package com.example.cardashiangame1.views.home;

import com.example.cardashiangame1.Application;
import com.example.cardashiangame1.views.MyView;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class HomeView extends MyView {
    private HomeEvent onPlayButtonCallback;

    public HomeView(Stage stage) throws IOException {
        super(stage);

        this.build();
    }

    @Override
    public void build() throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        int sceneSizeX = 908;
        int sceneSizeY = (sceneSizeX/16)*9-20;

        AnchorPane rootLayout = new AnchorPane();
        rootLayout.getChildren().addAll(getImageView(), getFlowPane());

        this.scene = new Scene(rootLayout, sceneSizeX, sceneSizeY);
    }

    @NotNull
    private ImageView getImageView() throws FileNotFoundException {
        ImageView imageView = new ImageView();
        imageView.setFitWidth(908);
        imageView.setFitHeight(535);
        imageView.setImage(new Image(new FileInputStream("src/main/resources/com/example/cardashiangame1/img/backgroundStartImage.jpg")));

        return imageView;
    }

    @NotNull
    private FlowPane getFlowPane() {
        FlowPane flowPane = new FlowPane();
        flowPane.setAlignment(Pos.CENTER);
        AnchorPane.setTopAnchor(flowPane, 0.0);
        AnchorPane.setLeftAnchor(flowPane, 0.0);
        AnchorPane.setRightAnchor(flowPane, 0.0);
        AnchorPane.setBottomAnchor(flowPane, 0.0);

        flowPane.getChildren().addAll(getGridPane());

        return flowPane;
    }

    @NotNull
    private GridPane getGridPane() {
        GridPane gridPane = new GridPane();
        ColumnConstraints columnConstraints1 = new ColumnConstraints(700);
        gridPane.getColumnConstraints().addAll(columnConstraints1);
        gridPane.getRowConstraints().add(new RowConstraints());
        gridPane.getRowConstraints().add(new RowConstraints(50));
        gridPane.getRowConstraints().add(new RowConstraints());

        gridPane.getChildren().addAll(getButton(), getTitleFlowPane());

        return gridPane;
    }

    @NotNull
    private FlowPane getTitleFlowPane() {
        FlowPane titleFlowPane = new FlowPane();

        titleFlowPane.setStyle("-fx-background-color: PURPLE; -fx-border-radius: 10px;");
        titleFlowPane.setAlignment(Pos.CENTER);
        titleFlowPane.setOpacity(0.63);

        titleFlowPane.getChildren().addAll(getTitleLabel());

        return titleFlowPane;
    }

    @NotNull
    private Button getButton() {
        Button button = new Button();

        button.setText("PLAY");
        button.setStyle("-fx-text-fill: white; -fx-border-radius: 0; -fx-padding: 10 40; -fx-background-color: purple;");
        button.setMinWidth(150);
        button.setTextAlignment(TextAlignment.CENTER);
        button.setCursor(Cursor.HAND);
        button.setFont(new Font(20));
        GridPane.setHalignment(button, HPos.CENTER);
        GridPane.setRowIndex(button, 2);

        button.setOnAction(actionEvent -> {
            System.out.println("Has Hecho click en Play");

            this.onPlayButtonCallback.onPlayButtonClick();
        });

        return button;
    }

    @NotNull
    private Label getTitleLabel() {
        Label label = new Label("Kanye West escapando de las Kardashian");

        label.setFont(new Font(28));
        label.setTextFill(Paint.valueOf("ffffff"));
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);

        return label;
    }

    public void setOnPlayClick(HomeEvent o) {
        this.onPlayButtonCallback = o;
    }
}

