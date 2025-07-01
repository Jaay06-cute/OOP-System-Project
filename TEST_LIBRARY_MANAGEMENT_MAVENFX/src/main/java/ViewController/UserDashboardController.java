
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IUserDashbooardView;
import Presenter.UserDashboardPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class UserDashboardController implements IUserDashbooardView{
    
    private UserDashboardPresenter presenter;
    
    @FXML
    private BorderPane UserMainContainer;
   
    
        
    public void initialize(){
        presenter = new UserDashboardPresenter(this);
        
    }
   
    @FXML
    private void GotoProfileView(MouseEvent event){
        presenter.GotoProfileView(UserMainContainer);
    }
    
  
}
