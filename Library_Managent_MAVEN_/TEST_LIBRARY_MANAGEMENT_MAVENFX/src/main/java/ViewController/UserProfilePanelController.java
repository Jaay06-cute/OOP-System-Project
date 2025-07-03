
package com.mycompany.Library_Management_Maven.ViewController;

import IViews.IUserProfilePanelVIews;
import Model.User;
import Presenter.UserProfilePanelPresenter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class UserProfilePanelController implements IUserProfilePanelVIews {
    
    @FXML
    private Label UserName,UserEmail,UserIdNumber;
    @FXML
    private ImageView UserImage;
    @FXML
    private ListView<String> BookListView;
    
    private User user;
    
    @FXML
    private VBox BookListContainer;
    
    private AnchorPane container;
    
    private UserProfilePanelPresenter presenter;

   
    public void initialize(){
        presenter = new UserProfilePanelPresenter(this);
       
    }
    
     public void setCurrentUser(User user){
        
        this.user = user;
        System.out.println("Welcome to the ProfileViewPanel "+ user.getFirstName());
    }
    
    
    public void setContainer(AnchorPane pane, User user){
        this.container = pane;
        this.user = user;
        setUserData(user);
    }
    
    public void setUserData(User user){
        presenter.setUserData(user);
        presenter.setBookDataList(BookListContainer, container);
    }

    @Override
    public void setUsername(String UserName) {
        this.UserName.setText(UserName);
    }

    @Override
    public void setUserEmail(String UserEmail) {
       this.UserEmail.setText(UserEmail);
    }

    @Override
    public void setStudentId(String StudentId) {
        this.UserIdNumber.setText(StudentId);
    }

    @Override
    public void setImage(Image image) {
        UserImage.setImage(image);
    }

    @Override
    public void setBookList(ObservableList<String> bookDataListBorrowed) {
       
        BookListView.setItems(bookDataListBorrowed);
    }

   

}
