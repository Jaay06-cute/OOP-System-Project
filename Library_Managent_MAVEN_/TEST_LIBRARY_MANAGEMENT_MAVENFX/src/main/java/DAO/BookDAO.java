
package DAO;

import Model.Book;
import java.io.File;
import java.util.List;

public interface BookDAO {
    void addBook(Book book, File bookImage);
    List<Book>getAllBook();
    Book getBookById(int id);
    void updateBook(Book book);
    void deleteBook(int id);
    
            
//    void addUser(User user);
//    User getUserById(int id);
//    Boolean IsPasswordExist(String Password, String Email);
//    void updateUser(User user);
//    void deleteUser(int id);
//    List<User> getAllUsers();
}
