
package com.mycompany.Library_Management_Maven.ViewController;

import Enums.Status;
import Model.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;



public class CardLayoutController {
    @FXML
    private Label BookTitle, BookAuthor, BookDateofPublished, BookStatus;
    @FXML
    private ImageView BookImage, BookFavorite;
    @FXML
    public AnchorPane CardLayout;
    
    private Status status;
    
    private Book book ;
    private AnchorPane viewContainer;
    
    
    private Image favorite = new Image(getClass().getResourceAsStream("/icon/redFavorite_icon.png"));
    private Image Notfavorite = new Image(getClass().getResourceAsStream("/Icon/favorite_icon.png"));
       
    public void setBookData(Book book){
        this.book = book;
        BookTitle.setText(book.getBookTitle());
        BookAuthor.setText(book.getBookAuthor());
        BookDateofPublished.setText(book.getBookDateOfPublished());
        BookImage.setImage(book.getBookImage());
        BookFavorite.setImage(book.getIsFavorite() ? favorite : Notfavorite);
        StatusBook();
    }
    
    public void setContainer(AnchorPane anchorPane){
        this.viewContainer = anchorPane;
    }
    
    private void StatusBook(){
        if(book.getIsBorrowed()){
            BookStatus.setStyle("-fx-text-fill: green;");
        }
        BookStatus.setText(status.CheckStatus(book.getIsBorrowed()).toString());
    }
    
    @FXML
    private void GotoBookView(MouseEvent event){
         try {
             System.out.println(" i am being click");
             System.out.println(viewContainer);
             System.out.println(book.getBookTitle());
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            AnchorPane pane = loader.load();
            
            BookViewController controller = loader.getController();
            controller.setDataBook(book);
            
            viewContainer.getChildren().setAll(pane);
            
        } catch (Exception e) {
            
           System.out.println(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            e.printStackTrace();
            
        }
        
    }
    
    

    
    
    
    
}