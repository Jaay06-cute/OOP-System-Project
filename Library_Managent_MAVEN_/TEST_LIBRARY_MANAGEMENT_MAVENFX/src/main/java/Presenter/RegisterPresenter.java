package Presenter;

import Helper.TextFormatHelper;
import IViews.ILoginView;
import IViews.IRegisterViews;
import Model.User;
import Model.UserDAOImplements;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import Presenter.LoginPresenter;


public class RegisterPresenter {

    private IRegisterViews views;
    private TextFormatHelper format;
    private UserDAOImplements userContext;
    private BorderPane borderpane;
    private AnchorPane anchorPane;
    private User user;
    


    public RegisterPresenter(IRegisterViews views) {
        this.views = views;
    }

    public void GotoLogin(BorderPane borderpane, AnchorPane anchorPane) {
        try {
            borderpane.setRight(anchorPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AddNewUser(BorderPane borderpane, AnchorPane anchorPane) {
        user = new User();
        userContext = new UserDAOImplements();
        format = new TextFormatHelper();
        String firstName = views.getFirstName().trim();
        String lastName = views.getLastName().trim();
        String StudentId = views.getStudentId().trim();
        String StudentEmail = views.getEmail().trim();
        String Password = views.getPassword();

        boolean isValid = true;
        
        if (firstName.isEmpty() || lastName.isEmpty() || StudentId.isEmpty() || StudentEmail.isEmpty()) {
            ReturnInvalidInfo(); // set prompt messages for each field
            isValid = false;
        }

        // 2. Check if StudentId is numeric
        if (!StudentId.matches("\\d+" )||!format.IsIdNumber(StudentId)) {
            views.setStudentId("red", "", true);
            views.setPromptStudentId("red", "Please use the correct 6 numeric Student ID");
            isValid = false;
        }
           //check the email
        if (!StudentEmail.endsWith("@umindanao.edu.ph")) {
            views.setEmail("red", "", true);
            views.setPromptEmail("red", "Please use address @umindanao.edu.ph *");
            isValid = false;
        }
        if(!format.IsIdNumber(Password)){
            views.setPassword("red", "", true);
            views.setPromptPassword("red", "Please Input atleast 6 characters *");
            isValid = false;
        }

        if (!isValid) {
            return;
        }
            //check the existing data in database
        boolean idExists = userContext.IsIdNumberExist(Integer.parseInt(StudentId));
        boolean emailExists = userContext.IsStudentEmail(StudentEmail);

        if (idExists || emailExists) {
            if (idExists) {
                views.setStudentId("red", "", false);
                views.setPromptStudentId("red", " This Student ID Already Exists*");
                return;
            }
            if (emailExists) {
                views.setEmail("red", "", true);
                views.setPromptEmail("red", " This School Email Already Exists*");
                return;
                
            }
            return;
        }

        // Success path
        views.setStudentId("black", StudentId, false);
        views.setEmail("black", StudentEmail, false);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setStudentId(Integer.parseInt(StudentId));
        user.setEmail(StudentEmail);
        user.setPassword(Password);

        userContext.addUser(user);
        userContext.closeConnection();
        clear();
        views.ShowMessage("User Added Successfully!");
        
        GotoLogin(borderpane, anchorPane);
        
        
    }
       

    private void clear() {
        views.setFirstName("black", "", false);
        views.setLastName("black", "", false);
        views.setStudentId("black", "", false);
        views.setEmail("black", "", false);
        views.setPassword("black", "", false);
    }

    private void ReturnInvalidInfo() {
        views.setPromptFirstName("red", " First Name*");
        views.setPromptLastName("red", " Last Name*");
        views.setPromptStudentId("red", " Student Id*");
        views.setPromptEmail("red", " JuandelaCruz.123456@umindanao.edu.ph*");
        views.setPromptPassword("red", " Password*");
    }

}
