
package com.mycompany.Library_Management_Maven.ViewController;

import Helper.DateTimeFormat;
import Model.ActionLogData;
import Model.Book;
import Presenter.HistoryViewPresenter;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


public class HistoryViewController {
    
   @FXML
    private Label BookTitle,BookAuthor,BookDateofPublished,UserHistoryDate,UserActionHistory;
   @FXML
   private ImageView BookImage;
    @FXML
    private AnchorPane HistoryPanelLayout; 
    private Book book;
    private DateTimeFormat format;
    private ActionLogData actionData;
    private HistoryViewPresenter presenter;
    
   
    
    public void setBookData(Book book, LocalDate ActionDate, String ActionDescription){
        this.format = new DateTimeFormat();
         this.book = book;
         BookTitle.setText(book.getBookTitle());
         BookAuthor.setText(book.getBookAuthor());
         BookDateofPublished.setText(format.MonthFormat(book.getBookDateOfPublished()));
         BookImage.setImage(book.getBookImage());
         UserHistoryDate.setText(format.MonthFormat(ActionDate));
         UserActionHistory.setText(ActionDescription);
    }
    
}
