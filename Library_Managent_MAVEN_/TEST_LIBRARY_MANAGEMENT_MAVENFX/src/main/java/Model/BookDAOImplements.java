package Model;

import DAO.BookDAO;
import Services.DbConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class BookDAOImplements implements BookDAO {

    private Connection connection;

    public BookDAOImplements() {
        this.connection = DbConnection.getConnection();
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addBook(Book book, File bookImage) {
        String sql = "INSERT INTO book ( Title, Author, DateofPublished, BookImage) VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql); 
                FileInputStream fis = new FileInputStream(bookImage)) {

            statement.setString(1, book.getBookTitle());
            statement.setString(2, book.getBookAuthor());
            statement.setDate(3, java.sql.Date.valueOf(book.getBookDateOfPublished()));
            statement.setBinaryStream(4, fis, (int) bookImage.length());

            statement.executeUpdate();

            System.out.println("Book Added Succefully!");
        } catch (Exception e) {
            System.out.println("Book Added Failed");
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getAllBook() {
        List<Book> bookList = new ArrayList<>();
        String sql = "SELECT BookId, Title, Author, DateofPublished, BookImage FROM book";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet rs = statement.executeQuery();
                
            while (rs.next()) {
                Book book = new Book();
                
                book.setBookId(rs.getInt("BookId"));
                book.setBookTitle(rs.getString("Title"));
                book.setBookAuthor(rs.getString("Author"));
                book.setBookDateOfPublished(rs.getDate("DateofPublished").toLocalDate());   
                
                // Get image as InputStream
                InputStream inputStream = rs.getBinaryStream("BookImage");
                Image image = null;
                if (inputStream != null) {
                    image = new Image(inputStream);
                }
                
                book.setBookImage(image);
                    
                bookList.add(book);
            }
            
            System.out.println("Books Load Successfuully!");

        } catch (Exception e) {
            System.out.println("Failed to load books");
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE BookId =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Book book = new Book();
                book.setBookId(resultSet.getInt("BookId"));
                book.setBookTitle(resultSet.getString("Title"));
                book.setBookAuthor(resultSet.getString("Author"));
                book.setBookDateOfPublished(resultSet.getDate("IdNumber").toLocalDate());
                
                InputStream inputStream = resultSet.getBinaryStream("BookImage");
                Image image = null;
                if (inputStream != null) {
                    image = new Image(inputStream);
                }
                
                book.setBookImage(image);

                return book;
            }
        } catch (SQLException e) {
            System.out.println("Failed to find book by id");
            e.printStackTrace();
        }
        return null; 
    }

    @Override
    public void updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteBook(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
