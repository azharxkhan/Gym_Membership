package gymApp.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class GymController {
    @FXML
    private void handleClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gym Membership");
        alert.setHeaderText("Welcome!");
        alert.setContentText("Welcome to the Gym!");
        alert.showAndWait();
    }
}
