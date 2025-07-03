
package Presenter;

import Model.ActionLog;
import Model.ActionLogData;
import Model.Book;
import Model.BookData;
import com.mycompany.Library_Management_Maven.ViewController.ReservationPanelController;
import java.net.URL;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class ReservationPresenter {
    private VBox container;
    private ActionLog actionLog;
    
    
    public void DisplayData(VBox box){
        BookData bookData = new BookData();
       
         box.getChildren().clear();
         for(Book book: bookData.book()){
             AnchorPane pane = CreateData(book);
             this.container = box;
             box.getChildren().add(pane);
         }
    }
    
    public AnchorPane CreateData(Book book){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/ReservationPanel.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            ReservationPanelController controller = loader.getController();
            controller.setPresenter(this);
            controller.setBookData(book);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
    
    public void CancelBookReservation(AnchorPane pane, Book book){
          actionLog = new ActionLog(book, LocalDate.now(), "Cancelled");
          ActionLogData.addLog(actionLog);
          System.out.println("Im in cancle"+ actionLog);
          
          container.getChildren().remove(pane);
    }
}
