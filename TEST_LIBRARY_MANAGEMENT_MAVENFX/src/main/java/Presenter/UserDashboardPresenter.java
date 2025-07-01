
package Presenter;

import IViews.IUserDashbooardView;
import IViews.IUserProfileView;
import com.mycompany.Library_Management_Maven.ViewController.CardLayoutController;
import com.mycompany.Library_Management_Maven.ViewController.RegisterController;
import com.mycompany.Library_Management_Maven.ViewController.SearchController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class UserDashboardPresenter {
    private IUserDashbooardView _view;
    private IUserProfileView userView;
    
    public UserDashboardPresenter(IUserDashbooardView view){
        this._view= view;
    }
     public UserDashboardPresenter(IUserProfileView view){
        this.userView= view;
    }
    
    public void GotoProfileView(BorderPane borderPane){
        try {
            
            URL fxmlPath = getClass().getResource("/Library_Management_Maven/UserProfile.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent anchorpane = loader.load();
         
            borderPane.setCenter(anchorpane);
     
        } catch (Exception e) {
           System.out.println(getClass().getResource("/Library_Management_Maven/UserProfile.fxml"));
            e.printStackTrace();
        }
    }
    
    
    public void DisplayPane(AnchorPane anchorPane, String displayFile){
          try {
              
             FXMLLoader loader = new FXMLLoader(getClass().getResource(displayFile + ".fxml"));
             AnchorPane pane = loader.load();
             
             if(displayFile.equals("/Library_Management_Maven/SearchView")){
                 SearchController controller = loader.getController();
                 controller.setContainer(anchorPane);
             }
             
             anchorPane.getChildren().setAll(pane);
            
        } catch (Exception e) {
            
           System.out.println(getClass().getResource("/com/mycompany/Library_Management_Maven/"+displayFile+".fxml"));
            e.printStackTrace();
            
        }
    }
    
   
}
    
