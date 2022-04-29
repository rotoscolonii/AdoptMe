package org.loose.fis.sre.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.loose.fis.sre.exceptions.InvalidCredentials;
import org.loose.fis.sre.exceptions.NameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

public class LoginController {

    @FXML
    private Text LoginMessage;
    @FXML
    private Text registrationMessage;
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
    public void handleRegisterAction() {
        try {
            UserService.addUser(NameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        } catch (NameAlreadyExistsException e) {
            registrationMessage.setText(e.getMessage());
        }
    }
}
