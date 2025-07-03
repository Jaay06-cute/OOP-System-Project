
package Presenter;

import Enums.Status;
import Helper.DateTimeFormat;
import IViews.IBookView;
import Model.Book;
import Model.User;
import Model.UserBookDAOImplements;
import java.time.LocalDate;


public class BookViewPresenter {
    private IBookView views;
    private Status status;
    private DateTimeFormat format;
    private User user;
    private Book book;
    private UserBookDAOImplements userbookContext;
    
    public BookViewPresenter(IBookView view){
        format = new DateTimeFormat();
        this.views= view;
    }
    
    public void loadBook(Book book, User user){
        this.book = book;
        this.user = user;
        this.userbookContext = new UserBookDAOImplements();
        
        loadContent(book);
        boolean checkBook = userbookContext.isBookBorrowed(book.getBookId());
        views.setStatus(status.CheckStatus(checkBook),setColor(checkBook) );
        views.checkStatus((checkBook)?"BORROW":"RESERVE",true);
    }
    
    public void loadBookFromProfile(Book book){
        loadContent(book);
        views.setStatus((LocalDate.now().isAfter(book.getBookDateAvailability())? "Late Return": "On Going"), (LocalDate.now().isAfter(book.getBookDateAvailability())?"red":"green"));
        views.checkStatus("RETURN THE BOOK",false);
    }
    
    
    
    private void loadContent(Book book){
        views.setImage(book.getBookImage());
        views.setBookTitle(book.getBookTitle());
        views.setBookAuhtor(book.getBookAuthor());
        views.setBookDateofPublished(format.MonthFormat(book.getBookDateOfPublished()));
    }
    
    private String setColor (Boolean IsAvailable){
        if(IsAvailable){
            return "green";
         }else
        {
            return "red";
        }
    }
}
