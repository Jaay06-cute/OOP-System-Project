
package DAO;

import Model.Book;
import Model.UserBookStatus;
import java.time.LocalDate;
import java.util.List;


public interface UserBookDAO {
    void markAsFavorite(int bookId, int userId, Boolean IsFavorite);
    void borrowBook(int bookId, int userId,LocalDate borrowedDate, LocalDate dueDate);
    Boolean isBookFavorite(int bookid, int userid);
    Boolean isBookBorrowed(int bookId);
    Boolean isUserBorrowedBook(int Userid);
    Boolean IsDelayedReturn(int bookId, int userId);
    List<Book> getAllBorrowedBooks(int userId);
    
}
