
package com.mycompany.Library_Management_Maven.ViewController;

import Helper.DateTimeFormat;
import Model.Book;
import Model.User;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BookListController {
     @FXML
    private Label BookTitle,BookDueDate;
    @FXML
    private ImageView BookImage;
    @FXML
    private AnchorPane BookListContainer;
    
    private Book book;
    private AnchorPane viewContainer;
    private DateTimeFormat format;
    private User user;
    
    public void setBookData(Book book){
        format = new DateTimeFormat();
        this.book = book;
        BookImage.setImage(book.getBookImage());
        BookTitle.setText(book.getBookTitle());
        IsDueDate(book.getBookDateAvailability());
    }
    
    public void setContainer(AnchorPane anchorPane){
        this.viewContainer = anchorPane;
        this.format = new DateTimeFormat();
    }
    
    private void IsDueDate(LocalDate date){
    LocalDate today = LocalDate.now();

        if (today.isEqual(date)) {
            BookDueDate.setStyle("-fx-text-date.toString()fill: red;"); 
            BookDueDate.setText("Due date: "+format.MonthFormat(date));

        } else if (today.isAfter(date)) {
            BookDueDate.setStyle("-fx-text-fill: red;");
            BookDueDate.setText("Late Return (" + format.MonthFormat(date) + ")");

        } else {
            BookDueDate.setText("Due date: "+ format.MonthFormat(date));
        }
    }
    
    
    @FXML
    private void GotoBookView(){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            AnchorPane pane = loader.load();
            BookViewController controller = loader.getController();
            
            controller.setDataBook(book, user);
            controller.ViewBookFromProfile(1,"Due Date: "+ format.MonthFormat(book.getBookDateAvailability()) + "  please return the book on time.");
            
            viewContainer.getChildren().setAll(pane);
            
        } catch (Exception e) {
            
           System.out.println(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            e.printStackTrace();
            
        }
    }
    
}
