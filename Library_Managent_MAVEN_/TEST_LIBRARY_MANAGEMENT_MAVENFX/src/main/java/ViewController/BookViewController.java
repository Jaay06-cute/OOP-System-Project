
package com.mycompany.Library_Management_Maven.ViewController;

import Enums.Status;
import IViews.IBookView;
import Model.Book;
import Model.User;
import Presenter.BookViewPresenter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BookViewController implements IBookView {
    private BookViewPresenter Presenter;
    private String bookDateOfPublished;
    private Book book;
   
    
    @FXML
    private Label BookTitle,BookAuthor,BookDateofPublished,BookStatus, BookNote;
    @FXML
    private Button StatusButton;
    @FXML
    private ImageView BookImage;
    @FXML
    private AnchorPane BookCardContainer;
    private User user;
    
    public void initialize(){
        this.Presenter = new BookViewPresenter(this);
    }
    
    public void setDataBook(Book book, User user){
       this.book = book;
       this.user = user;
      
    }

    private void LoadBook(){
        Presenter.loadBook(book,user);
    }
    
    public void ViewBookFromSearch(){
         LoadBook();
    }
    
    
    
    
    public void ViewBookFromProfile(int opacity,String note){
        setBookNote(opacity, note);
        Presenter.loadBookFromProfile(book);
    }
    
    
    
    @Override
    public void setBookTitle(String bookTitle) {
        BookTitle.setText(bookTitle);
    }

    @Override
    public void setBookAuhtor(String bookAuthor) {
        BookAuthor.setText(bookAuthor);
    }

    @Override
    public void setBookDateofPublished(String bookDate) {
        BookDateofPublished.setText(bookDate);
    }

    @Override
    public void setStatus(String bookStatus, String color) {
        BookStatus.setStyle("-fx-text-fill:"+color+";");
        BookStatus.setText(bookStatus);
    }

    @Override
    public void checkStatus(String checkStatus, Boolean check) {
        if(check){
            StatusButton.setText(checkStatus);
        }else{
            StatusButton.setDisable(true);
            StatusButton.setText(checkStatus);
        }
        
    }

    @Override
    public void setImage(Image image) {
        BookImage.setImage(image);
    }

    @Override
    public void setBookNote(int visible,String note) {
        BookNote.setOpacity(visible);
        BookNote.setText(note);
    }
    
    

   
    
}
