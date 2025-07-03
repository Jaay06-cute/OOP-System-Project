
package Presenter;

import Model.Book;
import Model.BookDAOImplements;
import Model.BookData;
import Model.User;
import com.mycompany.Library_Management_Maven.ViewController.CardLayoutController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SearchPresenter {
    
    private BookDAOImplements bookContext;
    public void DisplayData(VBox box, AnchorPane anchorPane, User user){
        this.bookContext = new BookDAOImplements();
       
         box.getChildren().clear();
         for(Book book: bookContext.getAllBook()){
             AnchorPane pane = CreateData(book, anchorPane, user);
             box.getChildren().add(pane);
            
         }
         bookContext.closeConnection();
         
    }
    
    public AnchorPane CreateData(Book book, AnchorPane anchorPane, User user){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/CardLayoutView.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            CardLayoutController controller = loader.getController();
            
            controller.setContainer(anchorPane,user);
            controller.setBookData(book);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
}
