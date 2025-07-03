
package Presenter;

import Model.ActionLog;
import Model.ActionLogData;
import Model.Book;
import Model.BookData;
import com.mycompany.Library_Management_Maven.ViewController.HistoryViewController;
import com.mycompany.Library_Management_Maven.ViewController.ReservationPanelController;
import java.net.URL;
import java.time.LocalDate;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class HistoryViewPresenter {
    
    private VBox container;
    
     public void DisplayData(VBox box){
        
         box.getChildren().clear();
         for(ActionLog actionlog: ActionLogData.getActionLogs()){
             AnchorPane pane = CreateData(actionlog.getBook(),actionlog.getActionTime(),actionlog.getActionDescription());
             this.container = box;
             box.getChildren().add(pane);
         }
    }
    
    public AnchorPane CreateData(Book book,LocalDate date, String actionDescription){
         try {
            URL  url = getClass().getResource("/Library_Management_Maven/HistoryViewPanel.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            AnchorPane pane = loader.load();
            
            HistoryViewController controller = loader.getController();
            controller.setBookData(book,date,actionDescription);
            
            return pane;
        } catch (Exception e) {
            e.printStackTrace();
            return new AnchorPane(); 
        }
    }
}
