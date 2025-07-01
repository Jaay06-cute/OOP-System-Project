
package Presenter;

import IViews.ILoginView;
import com.mycompany.Library_Management_Maven.ViewController.RegisterController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class LoginPresenter {
    private ILoginView _view;
    private BorderPane borderPane;
    private AnchorPane anchorPane;
    
    public LoginPresenter(ILoginView view){
        this._view = view;
    }
    
    public void UsersVerification(BorderPane borderpane){
        try {
            URL fxmlPath = getClass().getResource("/Library_Management_Maven/UserDashboard.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlPath);

            Parent root = loader.load();
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            
            newStage.show();
            
            Stage currentStage =(Stage)borderpane.getScene().getWindow();
            currentStage.close();
            
        } catch (Exception e) {
           System.out.println(getClass().getResource("/com/mycompany/Library_Management_Maven/UserDashboard.fxml"));
            e.printStackTrace();
        }
    }
    
    
    public void setMainComponent(BorderPane borderpane, AnchorPane anchorPane){
        this.borderPane= borderpane;
        this.anchorPane = anchorPane;
    }
    
    
    
    
            
    public void showRegister(){
        try {
            
            URL fxmlPath = getClass().getResource("/Library_Management_Maven/RegisterView.fxml");
//            System.out.println("FXML Path: " + fxmlPath); // <- null means "not found" for debugging purposess only.
            
            //Navigate to Register and have access of controllers.
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent anchorpane = loader.load();
            RegisterController  controller = loader.getController();
            controller.setMainComponents(borderPane, anchorPane);
            
//            RegisterController controller = new RegisterController(borderpane,anchorPane);
//            loader.setController(controller);s
            
            borderPane.setRight(anchorpane);
     
        } catch (Exception e) {
           System.out.println(getClass().getResource("/com/mycompany/Library_Management_Maven/register.fxml"));
            e.printStackTrace();
        }
    }
    
    
}
