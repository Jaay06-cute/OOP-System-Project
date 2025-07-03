
package Presenter;

import IViews.IUserDashbooardView;
import IViews.IUserProfileView;
import Model.User;

import com.mycompany.Library_Management_Maven.ViewController.ReservationController;
import com.mycompany.Library_Management_Maven.ViewController.SearchController;
import com.mycompany.Library_Management_Maven.ViewController.UserProfilePanelController;
import com.mycompany.Library_Management_Maven.ViewController.UserProfileViewController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class UserDashboardPresenter {
    private IUserDashbooardView _view;
    private IUserProfileView userView;
    
    public UserDashboardPresenter(IUserDashbooardView view){
        this._view= view;
    }
     public UserDashboardPresenter(IUserProfileView view){
        this.userView= view;
    }
    
    public void GotoProfileView(BorderPane borderPane, User user){
        try {
            URL fxmlPath = getClass().getResource("/Library_Management_Maven/UserProfile.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent anchorpane = loader.load();
            UserProfileViewController controller = loader.getController();
            controller.setCurrentUser(user);
         
            borderPane.setCenter(anchorpane);
     
        } catch (Exception e) {
           System.out.println(getClass().getResource("/Library_Management_Maven/UserProfile.fxml"));
            e.printStackTrace();
        }
    }
    
    
    public void DisplayPane(AnchorPane anchorPane, String displayFile, String NavigationName, User user){
          try {
              
             FXMLLoader loader = new FXMLLoader(getClass().getResource(displayFile + ".fxml"));
             AnchorPane pane = loader.load();
             if(displayFile.equals("/Library_Management_Maven/UserProfilePanel")){
                 UserProfilePanelController controller = loader.getController();
                 controller.setContainer(anchorPane, user);
             }
              if(NavigationName.equals("History")){
                 ReservationController controller = loader.getController();
                 controller.loadHistoryData("HISTORY");
             }
             
             if(displayFile.equals("/Library_Management_Maven/SearchView")){
                 SearchController controller = loader.getController();
                 controller.setContainer(anchorPane,user);
             }
             if(NavigationName.equals("Favorite")){
                 ReservationController controller = loader.getController();
                 controller.FavoriteContainer("FAVORITES");
             }
             if(NavigationName.equals("Reservation")){
                 ReservationController controller = loader.getController();
                 controller.loadData("RESERVATION / BORROWED BOOKS");
             }
             
             anchorPane.getChildren().setAll(pane);
            
        } catch (Exception e) {
            
           System.out.println(getClass().getResource("/com/mycompany/Library_Management_Maven/"+displayFile+".fxml"));
            e.printStackTrace();
            
        }
    }
    
   
}
    
