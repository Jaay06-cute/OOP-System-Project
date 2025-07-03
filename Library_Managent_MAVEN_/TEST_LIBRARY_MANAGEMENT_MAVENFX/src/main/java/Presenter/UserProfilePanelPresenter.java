
package Presenter;

import IViews.IUserProfilePanelVIews;
import Model.Book;
import Model.BookData;
import Model.User;
import com.mycompany.Library_Management_Maven.ViewController.BookListController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class UserProfilePanelPresenter {
    
    private IUserProfilePanelVIews views;
    private Image UserImage;
    private User user;
    
    
    public UserProfilePanelPresenter(IUserProfilePanelVIews views)
    {
        this.views = views;
    }
    
    public void setUserData(User user){
        this.user =user;
        UserImage = new Image(getClass().getResourceAsStream("/Icon/userImage_icon.jpg"));
        
        views.setUsername(user.getFirstName()+" "+user.getLastName());
        views.setUserEmail(user.getEmail());
        views.setStudentId(String.valueOf(user.getStudentId()));
        views.setImage(UserImage);
    }
    
    public void setBookDataList(VBox box, AnchorPane anchor){
        BookData bookData = new BookData();
        
        box.getChildren().clear();
        for( Book book: bookData.book()){
            AnchorPane pane = CreateData(book ,anchor);
            box.getChildren().add(pane);
        }
    }
    
    private AnchorPane CreateData(Book book, AnchorPane anchor){
          try {
            URL  url = getClass().getResource("/Library_Management_Maven/BookListView.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            BookListController controller = loader.getController();
            controller.setContainer(anchor);
            controller.setBookData(book);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
}
