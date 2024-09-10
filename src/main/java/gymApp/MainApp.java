package gymApp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gym Membership App");

        VBox vbox = new VBox();
        Button btn = new Button("Click Me!");

        btn.setOnAction(e -> System.out.println("Welcome to the Gym!"));
        vbox.getChildren().add(btn);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
