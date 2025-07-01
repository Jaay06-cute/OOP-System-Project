package com.mycompany.Library_Management_Maven.ViewController;

import IViews.ILoginView;
import Presenter.LoginPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    private TextField TextboxIdNumber;
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
    public void setLabel(String text) {
        LoginLabel.setText(text);
    }

    @Override
    public String getUserId() {
        return TextboxIdNumber.getText();
    }
    
}


