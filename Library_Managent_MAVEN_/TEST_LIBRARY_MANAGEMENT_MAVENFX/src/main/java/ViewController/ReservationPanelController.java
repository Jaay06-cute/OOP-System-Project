
package com.mycompany.Library_Management_Maven.ViewController;

import Helper.DateTimeFormat;
import Model.Book;
import Presenter.ReservationPresenter;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ReservationPanelController {
    @FXML
    private Label BookTitle, BookAuthor, BookDateofPublished, BookStatus,BookAvailableTime;
    @FXML
    private ImageView BookImage;
    @FXML
    public AnchorPane ReservationLayout;
    private Book book;
    private ReservationPresenter presenter;
    private DateTimeFormat format;
    
    
    public void setBookData(Book book){
        this.format = new DateTimeFormat();
        this.book = book;
        BookTitle.setText(book.getBookTitle());
        BookAuthor.setText(book.getBookAuthor());
        BookDateofPublished.setText(book.getBookDateOfPublished().toString());
        BookImage.setImage(book.getBookImage());
        IsBorrow(book.getIsAvailable(),book.getBookToReturnDate());
    }
    private void IsBorrow(Boolean IsBorrowed, LocalDate date){
        LocalDate today = LocalDate.now();
        if(IsBorrowed){
             if(today.isEqual(date)){
                BookStatus.setText("BORROWED BOOKS");
                BookAvailableTime.setText("Due Date: "+format.MonthFormat(date));
            }
            else if (today.isAfter(date)){
                BookStatus.setStyle("-fx-text-fill: red;");
                BookStatus.setText("LATE RETURN");
                BookAvailableTime.setText(format.MonthFormat(date));
            }else{
                BookStatus.setText("BORROWED BOOKS");
                BookAvailableTime.setText("Due Date: "+format.MonthFormat(date));
            }
               
        }else{
            if(today.isEqual(date)){
                BookStatus.setText("AVAILABLE NOW");
                BookAvailableTime.setText(format.MonthFormat(date));
            }
            else if (today.isAfter(date)){
                BookStatus.setText("AVAILABLE NOW");
                BookAvailableTime.setText(format.MonthFormat(date));
            }
            else{
                BookStatus.setText("AVAILABLE ON");
                BookAvailableTime.setText(format.MonthFormat(date));
              
            }
        }
      
       
    }
    public void setPresenter(ReservationPresenter presenter){
        this.presenter = presenter;
    }
    
    @FXML
    private void CancelBookReservation(){
        presenter.CancelBookReservation(ReservationLayout, book);
    }
          
   
}
