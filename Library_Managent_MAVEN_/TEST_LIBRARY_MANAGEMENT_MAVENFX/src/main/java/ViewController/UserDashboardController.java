
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IUserDashbooardView;
import Model.User;
import Presenter.UserDashboardPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;


public class UserDashboardController implements IUserDashbooardView{
    
    private UserDashboardPresenter presenter;
    private User user;
    
    @FXML
    private Label WelcomeText;
    
    @FXML
    private BorderPane UserMainContainer;
   
    public void setCurrentUser(User user){
        
        this.user = user;
        setWelcomeName();
        System.out.println("Welcome to the UserDashBoard "+ user.getFirstName());
    }
        
    public void initialize(){
        presenter = new UserDashboardPresenter(this);
        
    }
    
    private void setWelcomeName(){
        WelcomeText.setText("Hi "+ user.getFirstName()+", Welcome to Library Portal");
    }
    
    
    
   
    @FXML
    private void GotoProfileView(MouseEvent event){
        presenter.GotoProfileView(UserMainContainer, user);
    }
    
  
}
