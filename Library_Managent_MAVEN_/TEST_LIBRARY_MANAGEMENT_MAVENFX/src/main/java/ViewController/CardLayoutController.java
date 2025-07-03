
package com.mycompany.Library_Management_Maven.ViewController;

import Enums.Status;
import Helper.DateTimeFormat;
import Model.Book;
import Model.User;
import Model.UserBookDAOImplements;
import java.time.LocalDate;
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
    private ImageView BookImage, BookFavorite, AddBookFavorite;
    @FXML
    public AnchorPane CardLayout;
    
    private User user;
    
    private Status status;
    
    private Book book ;
    private AnchorPane viewContainer;
    private UserBookDAOImplements userbookContext;
    private DateTimeFormat format;
    
    private Image favorite = new Image(getClass().getResourceAsStream("/icon/redFavorite_icon.png"));
    private Image Notfavorite = new Image(getClass().getResourceAsStream("/Icon/favorite_icon.png"));
       
    public void setBookData(Book book){
        this.book = book;
        this.userbookContext = new UserBookDAOImplements();
        this.format = new DateTimeFormat();
        
        BookTitle.setText(book.getBookTitle());
        BookAuthor.setText(book.getBookAuthor());
        BookDateofPublished.setText(format.MonthFormat(book.getBookDateOfPublished()));
        BookImage.setImage(book.getBookImage());
        BookFavorite.setImage(userbookContext.isBookFavorite(book.getBookId(), user.getUserId()) ? favorite : Notfavorite);
        StatusBook();
        userbookContext.closeConnection();

        
    }
    
    public void setContainer(AnchorPane anchorPane, User user){
        this.viewContainer = anchorPane;
        this.user = user;
        System.out.println("IM in cardViewLayout " + user.getFirstName());
    }
    
    private void StatusBook(){
        
        boolean checkbook = userbookContext.isBookBorrowed(book.getBookId());
        if(!checkbook){
            System.out.println("check");
            System.out.println(checkbook);
            BookStatus.setStyle("-fx-text-fill: green;");
        }
        BookStatus.setText(status.CheckStatus(checkbook));
    }
    
    @FXML
    private void GotoBookView(MouseEvent event){
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            AnchorPane pane = loader.load();
            BookViewController controller = loader.getController();
            
            controller.setDataBook(book,user);
            controller.ViewBookFromSearch();
            
            viewContainer.getChildren().setAll(pane);
            
        } catch (Exception e) {
            
           System.out.println(getClass().getResource("/Library_Management_Maven/BookView.fxml"));
            e.printStackTrace();
            
        }
    }
    
    @FXML
    private void AddBookFavorite(){
        UserBookDAOImplements context = new UserBookDAOImplements();
        
        boolean checkFavorite = context.isBookFavorite(book.getBookId(), user.getUserId());
        if(checkFavorite){
            BookFavorite.setImage(Notfavorite);
            context.markAsFavorite(book.getBookId(), user.getUserId(), false);
        }else{
            BookFavorite.setImage(favorite);
            context.markAsFavorite(book.getBookId(), user.getUserId(), true);
        }
        context.closeConnection();
    }
    

    
    
    
    
}