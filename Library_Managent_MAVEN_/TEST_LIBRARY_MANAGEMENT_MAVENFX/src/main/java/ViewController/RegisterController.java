package com.mycompany.Library_Management_Maven.ViewController;

import Helper.TextFormatHelper;
import IViews.IRegisterViews;
import Presenter.RegisterPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;

public class RegisterController implements IRegisterViews {

    private RegisterPresenter presenter;
    private BorderPane borderpane;
    private AnchorPane anchorPane;
    private TextFormatHelper textLimit;
    private int useridMax = 6;
    private int userNamesMax = 45;
    private int passwordMax= 10;

    @FXML
    private TextField TextboxFirstName;
    @FXML
    private TextField TextboxLastName;
    @FXML
    private TextField TextboxStudentId;
    @FXML
    private TextField TextboxEmail;
    @FXML
    private PasswordField TextboxPassword;

    public void setMainComponents(BorderPane borderpane, AnchorPane anchorPane) {
        this.borderpane = borderpane;
        this.anchorPane = anchorPane;
    }

    public void initialize() {
        textLimit = new TextFormatHelper();
        presenter = new RegisterPresenter(this);
        TextboxFirstName.setTextFormatter(textLimit.createMaxLengthFormatter(userNamesMax));
        TextboxLastName.setTextFormatter(textLimit.createMaxLengthFormatter(userNamesMax));
        TextboxStudentId.setTextFormatter(textLimit.createMaxLengthFormatter(useridMax));
        TextboxEmail.setTextFormatter(textLimit.createMaxLengthFormatter(userNamesMax));
        TextboxPassword.setTextFormatter(textLimit.createMaxLengthFormatter(passwordMax));
    }

    @FXML
    private void AddNewUser() {
        presenter.AddNewUser(borderpane, anchorPane);
    }

    @FXML
    private void GotoLoginPage() {
        presenter.GotoLogin(borderpane, anchorPane);

    }

    @Override
    public String getFirstName() {
        return TextboxFirstName.getText();
    }

    @Override
    public String getLastName() {
        return TextboxLastName.getText();
    }

    @Override
    public String getStudentId() {
        return TextboxStudentId.getText();
    }

    @Override
    public void ShowMessage(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);  // No header
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public String getEmail() {
        return TextboxEmail.getText();
    }

    @Override
    public void setFirstName(String color, String setText, Boolean clearText) {
        TextboxFirstName.setStyle("-fx-text-fill:" + color + ";");

        if (clearText) {
            TextboxFirstName.clear();
        } else {
            TextboxFirstName.setText(setText);
        }
    }

    @Override
    public void setLastName(String color, String setText, Boolean clearText) {
        TextboxLastName.setStyle("-fx-text-fill:" + color + ";");
        if (clearText) {
            TextboxLastName.clear();
        } else {
            TextboxLastName.setText(setText);

        }
    }

    @Override
    public void setStudentId(String color, String setText, Boolean clearText) {
        TextboxStudentId.setStyle("-fx-text-fill:" + color + ";");

        if (clearText) {
            TextboxStudentId.clear();
        } else {
            TextboxStudentId.setText(setText);
        }
    }

    @Override
    public void setEmail(String color, String setText, Boolean clearText) {
        TextboxEmail.setStyle("-fx-text-fill:" + color + ";");

        if (clearText) {
            TextboxEmail.clear();
        } else {
            TextboxEmail.setText(setText);
        }
    }

    @Override
    public void setPromptFirstName(String color, String PromptText) {
        TextboxFirstName.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxFirstName.setPromptText(PromptText);
    }

    @Override
    public void setPromptLastName(String color, String PromptText) {
        TextboxLastName.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxLastName.setPromptText(PromptText);
    }

    @Override
    public void setPromptStudentId(String color, String PromptText) {
        TextboxStudentId.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxStudentId.setPromptText(PromptText);
    }

    @Override
    public void setPromptEmail(String color, String PromptText) {
        TextboxEmail.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxEmail.setPromptText(PromptText);
    }

    @Override
    public void setPromptPassword(String color, String PromptText) {
        TextboxPassword.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxPassword.setPromptText(PromptText);
    }

    @Override
    public void setPassword(String color, String setText, Boolean clearText) {
        TextboxPassword.setStyle("-fx-text-fill:" + color + ";");

        if (clearText) {
            TextboxPassword.clear();
        } else {
            TextboxPassword.setText(setText);
        }
    }

    @Override
    public String getPassword() {
        return TextboxPassword.getText();
    }

}
