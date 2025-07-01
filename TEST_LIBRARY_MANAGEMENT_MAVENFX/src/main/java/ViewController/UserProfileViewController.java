
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IUserProfileView;
import Presenter.AnimationPresenter;
import Presenter.UserDashboardPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class UserProfileViewController implements IUserProfileView{
    
    private AnimationPresenter presenter; 
    private UserDashboardPresenter userPresenter;
    
    @FXML
    private AnchorPane ViewContainer;
    @FXML
    private HBox ProfileButton, ReservationButton, BooksButton ,HistoryButton, NotificationButton, SignOutButton;
    @FXML
    private ImageView black_profile,black_reservation,black_books,black_history,black_notification,black_signout;
    @FXML
    private Label ProfileLabel,ReservationLabel,BooksLabel,HistoryLabel,NotificationLabel,SignoutLabel;
    @FXML
    private TextField TextBoxSearch;
    
    public void initialize(){
        
        this.presenter = new AnimationPresenter();
        this.userPresenter= new UserDashboardPresenter(this);
        ProfileViewLoad();
        
        System.out.println("ReservationButton is null? " + (ReservationButton == null));
        animate(ProfileButton, black_profile, ProfileLabel);
        animate(ReservationButton, black_reservation, ReservationLabel);
        animate(BooksButton, black_books, BooksLabel);
        animate(HistoryButton, black_history, HistoryLabel);
        animate(NotificationButton, black_notification, NotificationLabel);
        animate(SignOutButton, black_signout, SignoutLabel);
    }
    
    private void animate(HBox box, ImageView image, Label label){
        box.setOnMouseEntered(event ->{
            presenter.Hover(box,image,label);
        });
         box.setOnMouseExited(event ->{
            presenter.Default(box,image,label);
        });
    }
    
    private void ProfileViewLoad(){
         userPresenter.DisplayPane(ViewContainer,"/Library_Management_Maven/UserProfilePanel");
    }
    
    @FXML
    private void ProfileViewSelect(){
        ProfileViewLoad();
    }
    
    
      @FXML
    private void GotoSearch(){
        userPresenter.DisplayPane(ViewContainer,"/Library_Management_Maven/SearchView");
        
    }

    @Override
    public String SearchInput() {
        return TextBoxSearch.getText();
    }
    
    @FXML
    private void GotoReservation(){
        userPresenter.DisplayPane(ViewContainer,"/Library_Management_Maven/Reservation");
    }
    

}
