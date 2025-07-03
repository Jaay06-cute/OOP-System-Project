
package Presenter;

import IViews.ILoginView;
import Model.User;
import Model.UserDAOImplements;
import com.mycompany.Library_Management_Maven.ViewController.RegisterController;
import com.mycompany.Library_Management_Maven.ViewController.UserDashboardController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class LoginPresenter {
    private ILoginView view;
    private BorderPane borderPane;
    private AnchorPane anchorPane;
    private UserDAOImplements userContext;
    private BorderPane borderpaneContainer;
    
    public LoginPresenter(ILoginView view){
        this.view = view;
    }
    
    public void UsersVerification(BorderPane borderpane){
        String SchoolEmail = view.getSchoolEmail();
        String Password = view.getPassword();
        this.userContext = new UserDAOImplements();
        this.borderpaneContainer = borderpane;
        
        boolean IsValid = true;
        
        boolean IsEmailExist = userContext.IsStudentEmail(SchoolEmail);
        boolean IsPasswordExist = userContext.IsPasswordExist(Password, SchoolEmail);
        
        if(SchoolEmail.isEmpty()||Password.isEmpty()){
            ReturnInvalidInfo();
            IsValid= false;
        }
        
        if(!IsEmailExist){
            view.setSchoolEmail("red", "", true);
             view.setPassword("red", "", true);
            view.setPromptSchoolEmail("red", "Incorrect Email*");
            view.setPromptPassword("red", "Incorrect Password*");
            IsValid = false;
        }
        if(!IsPasswordExist){
             view.setPassword("red", "", true);
             view.setPromptPassword("red", "Incorrect Password*");
             IsValid = false;
        }
        if(!IsValid){
            return;
        }
        User currentUser = userContext.getUserbySchoolEmail(SchoolEmail);
        userContext.closeConnection();
        loginSuccess(currentUser);
       
    }
    
    
    private void loginSuccess(User user){
          try {
            URL fxmlPath = getClass().getResource("/Library_Management_Maven/UserDashboard.fxml");
            FXMLLoader loader = new FXMLLoader(fxmlPath);

            Parent root = loader.load();
            UserDashboardController controller = loader.getController();
            controller.setCurrentUser(user);
            
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            
            newStage.show();
            
            Stage currentStage =(Stage)borderpaneContainer.getScene().getWindow();
            currentStage.close();
            
        } catch (Exception e) {
           System.out.println(getClass().getResource("/com/mycompany/Library_Management_Maven/UserDashboard.fxml"));
            e.printStackTrace();
        }
    }
    
    private void ReturnInvalidInfo(){
        view.setPromptSchoolEmail("red", " School Email*");
        view.setPromptPassword("red", " Password*");
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
