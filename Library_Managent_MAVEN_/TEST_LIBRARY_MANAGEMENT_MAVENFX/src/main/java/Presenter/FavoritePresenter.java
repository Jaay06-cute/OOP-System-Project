
package Presenter;

import IViews.IFavoritesView;
import Model.Book;
import Model.BookData;
import com.mycompany.Library_Management_Maven.ViewController.FavoritePanelController;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FavoritePresenter {
    private  IFavoritesView view;
   
    
    public FavoritePresenter(IFavoritesView view){
    this.view = view;
    }
    public FavoritePresenter(){
    }
    private VBox BoxContainer;
    
    
    
    
    public void ShowFavoriteBook(VBox box){
         BookData bookData = new BookData();
        
         box.getChildren().clear();
         for(Book book: bookData.book()){
             if(book.getIsFavorite()==true){
                 AnchorPane pane = CreateData(book);
                 box.getChildren().add(pane);
                 this.BoxContainer = box;
                 System.out.println(BoxContainer);
             }
         }
    }
    
     public AnchorPane CreateData(Book book){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/FavoritePanel.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            FavoritePanelController controller = loader.getController();
            
            controller.setBookData(book);
            controller.setPresenter(this);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
     
     
     public void RemoveBookFromFavorite( AnchorPane pane){
            BoxContainer.getChildren().remove(pane);
            System.out.println(BoxContainer);
     }
}
