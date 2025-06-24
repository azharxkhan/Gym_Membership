package gymApp.controller;

import java.util.List;

import gymApp.dao.UserDAOImpl;
import gymApp.model.User;
import gymApp.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberController {

    @FXML
    private TableView<User> memberTable;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, String> emailCol;

    private UserService userService = new UserService(new UserDAOImpl());

    @FXML
    public void initialize() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        List<User> users = userService.getAllUsers();
        memberTable.getItems().addAll(users);
    }
}