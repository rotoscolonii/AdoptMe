package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.InvalidCredentials;
import org.loose.fis.sre.exceptions.NameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.io.IOException;

public class LoginController {

    @FXML
    private Text LoginMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField NameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Client", "Owner");
    }

    @FXML
    public void handleLoginAction() {
        try {
            UserService.validateUser(NameField.getText(), passwordField.getText(), (String) role.getValue());
            LoginMessage.setText("Logged in successfully!");
        } catch (InvalidCredentials e) {
            LoginMessage.setText(e.getMessage());
        }
    }
    @FXML
    private Hyperlink registerPressed;

    @FXML
    public void handleRegisterMenu(javafx.event.ActionEvent event) throws IOException {
        Stage stage = (Stage) registerPressed.getScene().getWindow();
        stage.close();

        Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        Scene scene = new Scene(login);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.show();
    }

}