
package Presenter;

import IViews.IFavoritesView;
import Model.Book;
import Model.BookData;
import com.mycompany.Library_Management_Maven.ViewController.ReservationPanelController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FavoritePresenter {
    private  IFavoritesView view;
    
    public FavoritePresenter(IFavoritesView view){
    this.view = view;
    }
    
    public void ShowFavoriteBook(VBox box){
         BookData bookData = new BookData();
       
         System.out.println(bookData);
         for(Book book: bookData.book()){
             if(book.getIsFavorite()==true){
                 AnchorPane pane = CreateData(book);
                 box.getChildren().add(pane);
             }
         }
    }
    
     public AnchorPane CreateData(Book book){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/ReservationPanel.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            ReservationPanelController controller = loader.getController();
            
            controller.setBookData(book);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
}
