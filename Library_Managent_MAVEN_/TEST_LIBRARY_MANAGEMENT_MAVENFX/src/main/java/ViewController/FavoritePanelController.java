
package com.mycompany.Library_Management_Maven.ViewController;

import Helper.DateTimeFormat;
import Model.ActionLogData;
import Model.Book;
import Presenter.FavoritePresenter;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class FavoritePanelController {
    @FXML
    private Label BookTitle, BookAuthor, BookDateofPublished, BookStatus, AvailableDate, BookBorrow ;
    @FXML
    private ImageView BookImage;
    @FXML
    public AnchorPane FavoriteLayout;
    private Book book;
    private DateTimeFormat format;
    
    private FavoritePresenter presenter;
    
    public void setBookData(Book book){
        this.book = book;
        BookTitle.setText(book.getBookTitle());
        BookAuthor.setText(book.getBookAuthor());
        BookDateofPublished.setText(book.getBookDateOfPublished().toString());
        BookImage.setImage(book.getBookImage());
        IsBorrowed(book.getBookDateAvailability());
        
    }
    
    public void setPresenter(FavoritePresenter presenter)
    {
        this.presenter = presenter;
    }    
    private void IsBorrowed(LocalDate date){
        this.format = new DateTimeFormat();
        LocalDate today = LocalDate.now();
        if(today.isEqual(date)){
            BookStatus.setText("AVAILABLE NOW");
            BookBorrow.setText("BORROW");
        }
        else if (today.isAfter(date)){
            BookStatus.setText("AVAILABLE NOW");
            BookBorrow.setText("BORROW");
        }
        else{
            BookStatus.setText("AVAILABLE UNTIL");
            AvailableDate.setText(format.MonthFormat(date));
            BookBorrow.setText("RESERVE");
        }
    }
    
    
    @FXML
    private void RemoveBookFavorite(){
        System.out.println(ActionLogData.getActionLogs());
        presenter.RemoveBookFromFavorite( FavoriteLayout);
    }
}
