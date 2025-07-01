
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IRegisterViews;
import Presenter.RegisterPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;


public class RegisterController implements IRegisterViews{

    private RegisterPresenter presenter;
    
    private BorderPane borderpane;
    private AnchorPane anchorPane;
    
    public void setMainComponents(BorderPane borderpane, AnchorPane anchorPane){
        this.borderpane = borderpane;
        this.anchorPane = anchorPane;
    }
    
    @FXML
    private TextField TextboxFirstName;
    @FXML
    private TextField TextboxLastName;
    @FXML
    private TextField TextboxStudentId;
    @FXML
    private TextField TextboxEmail;
    
    
    public void initialize(){
        presenter = new RegisterPresenter(this);
    }
    
    @FXML
    private void GotoLoginPage(){
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
    public String getEmail() {
        return TextboxEmail.getText();
    }
    
   
    
}
