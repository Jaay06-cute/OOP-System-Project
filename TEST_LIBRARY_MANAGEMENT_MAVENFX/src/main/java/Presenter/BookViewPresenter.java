
package Presenter;

import Enums.Status;
import IViews.IBookView;
import Model.Book;


public class BookViewPresenter {
    private IBookView views;
    private Status status;
    
    public BookViewPresenter(IBookView view){
        this.views= view;
    }
    
    public void loadBook(Book book){
        views.setImage(book.getBookImage());
        views.setBookTitle(book.getBookTitle());
        views.setBookAuhtor(book.getBookAuthor());
        views.setBookDateofPublished(book.getBookDateOfPublished());
        views.setStatus(status.CheckStatus(book.getIsBorrowed()).toString());
        views.checkStatus((book.getIsBorrowed())?"BORROW":"RESERVE");
    }
}
