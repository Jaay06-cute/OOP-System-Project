package com.mycompany.Library_Management_Maven.ViewController;

import IViews.ILoginView;
import Presenter.LoginPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class LoginController implements ILoginView{

    private LoginPresenter presenter;
    
    @FXML
    private Label LoginLabel;
    @FXML
    private TextField TextboxSchoolEmail;
    @FXML
    private PasswordField TextboxPassword;
    @FXML 
    private BorderPane LoginRegisterContainer;
    @FXML
    private AnchorPane LoginPane;
    
    
    public void initialize(){
        presenter = new LoginPresenter(this);
    }
    
    @FXML
    private void GotoUsersPage(){
        presenter.UsersVerification(LoginRegisterContainer);
    }
    
    @FXML
    private void GotoRegisterPage(){
        presenter.setMainComponent(LoginRegisterContainer, LoginPane);
        presenter.showRegister();
    }
    
    
    @FXML
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
          presenter.UsersVerification(LoginRegisterContainer);
        }
    }

    @Override
    public String getSchoolEmail() {
        return TextboxSchoolEmail.getText();
    }

    @Override
    public String getPassword() {
       return TextboxPassword.getText();
    }

    @Override
    public void setSchoolEmail(String color, String setText, Boolean clearText) {
      TextboxSchoolEmail.setStyle("-fx-text-fill:" + color + ";");

        if (clearText) {
            TextboxSchoolEmail.clear();
        } else {
            TextboxSchoolEmail.setText(setText);
        }
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
    public void setPromptSchoolEmail(String color, String PromptText) {
        TextboxSchoolEmail.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxSchoolEmail.setPromptText(PromptText);
    }

    @Override
    public void setPromptPassword(String color, String PromptText) {
        TextboxPassword.setStyle("-fx-prompt-text-fill:" + color + ";");
        TextboxPassword.setPromptText(PromptText);
    }
    
    
    
}
