
package Presenter;

import Model.Book;
import Model.BookData;
import com.mycompany.Library_Management_Maven.ViewController.CardLayoutController;
import java.net.URL;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class SearchPresenter {
    
    public void DisplayData(VBox box, AnchorPane anchorPane){
        BookData bookData = new BookData();
       
         System.out.println(bookData);
         for(Book book: bookData.book()){
             AnchorPane pane = CreateData(book, anchorPane);
             box.getChildren().add(pane);
            
         }
         
    }
    
    public AnchorPane CreateData(Book book, AnchorPane anchorPane){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/CardLayoutView.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            CardLayoutController controller = loader.getController();
            
            controller.setContainer(anchorPane);
            controller.setBookData(book);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
}
