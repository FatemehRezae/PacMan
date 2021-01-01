package ir;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        final Scene scene = new Scene(group, 600, 200, Color.BLACK);
        Handler handler = new Handler();
        handler.setOver(group,primaryStage,"     Start",scene);
        primaryStage.setTitle("PacMan");
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
