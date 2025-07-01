
package com.mycompany.Library_Management_Maven.ViewController;

import Model.Book;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ReservationPanelController {
    @FXML
    private Label BookTitle, BookAuthor, BookDateofPublished;
    @FXML
    private ImageView BookImage;
    @FXML
    public AnchorPane ReservationLayout;
    private Book book;
    
    
    public void setBookData(Book book){
        this.book = book;
        BookTitle.setText(book.getBookTitle());
        BookAuthor.setText(book.getBookAuthor());
        BookDateofPublished.setText(book.getBookDateOfPublished());
        BookImage.setImage(book.getBookImage());
    }
          
   
}
