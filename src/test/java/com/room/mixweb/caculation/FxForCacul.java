package com.room.mixweb.caculation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.security.core.parameters.P;

public class FxForCacul extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane pane=new BorderPane();
        Scene scene=new Scene(pane,400,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Pane");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
