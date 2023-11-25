package com.example.cardashiangame1;

import com.example.cardashiangame1.views.game.GameView;
import com.example.cardashiangame1.views.home.HomeEvent;
import com.example.cardashiangame1.views.home.HomeView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        HomeView homeViewScene = new HomeView(stage);
        GameView gameView = new GameView(stage);

        HomeEvent lambda = gameView::setToStage;

        homeViewScene.setOnPlayClick(lambda);

        homeViewScene.setToStage();




        /*scene.setOnKeyPressed(keyEvent -> {
            if (Objects.requireNonNull(keyEvent.getCode()) == KeyCode.F11) {
                stage.setFullScreen(!stage.isFullScreen());
            }
        });*/

//        scene.getStylesheets()
//                .addAll(Objects.requireNonNull(this.getClass()
//                        .getResource("com/example/cardashiangame1/img/backgroundStartImage.jpg")).toExternalForm());

        stage.setTitle("Kanye West scaping the Kardashians!");
//        stage.setFullScreen(true);
//        stage.setForceIntegerRenderScale(true);
        stage.setFullScreenExitHint("Press ESC or F11 to exit full screen mode");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}