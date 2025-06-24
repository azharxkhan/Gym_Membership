package gymApp.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class DashboardHomeController {

    @FXML
    private BorderPane mainPane;

    public void showMembers() throws IOException {
        loadView("/templates/MemberManagementView.fxml");
    }

    public void showSubscriptions() throws IOException {
        loadView("/templates/SubscriptionManagementView.fxml");
    }

    public void showPayments() throws IOException {
        loadView("/templates/PaymentView.fxml");
    }

    private void loadView(String fxml) throws IOException {
        Parent view = FXMLLoader.load(getClass().getResource(fxml));
        mainPane.setCenter(view);
    }
} 
