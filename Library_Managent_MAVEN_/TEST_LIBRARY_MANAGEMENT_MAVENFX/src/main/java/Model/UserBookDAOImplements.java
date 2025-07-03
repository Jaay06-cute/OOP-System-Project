package Model;

import DAO.UserBookDAO;
import Services.DbConnection;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

public class UserBookDAOImplements implements UserBookDAO {

    private Connection connection;

    public UserBookDAOImplements() {
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
    public void markAsFavorite(int bookId, int userId, Boolean IsFavorite) {
        String sql = "INSERT INTO favoritebook (UserId, BookId, IsFavorite) VALUES (?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE IsFavorite = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setBoolean(3, IsFavorite);
            stmt.setBoolean(4, IsFavorite);

            stmt.executeUpdate();
            System.out.println("Book has favorite has changed");
        } catch (SQLException e) {
            System.out.println("failed book added to favorite");
            e.printStackTrace();
        }
    }

    @Override
    public void borrowBook(int bookId, int userId, LocalDate borrowedDate, LocalDate dueDate) {
        String sql = "INSERT INTO borrowedbook ( BookId, UserId, BorrowedDate, DueDate, IsDelayedReturn) VALUES (?, ?, ?, ?, ?) ";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            stmt.setInt(2, userId);
            stmt.setDate(3, java.sql.Date.valueOf(borrowedDate));
            stmt.setDate(4, java.sql.Date.valueOf(dueDate));
            stmt.setBoolean(5, false);

            stmt.executeUpdate();
            System.out.println("Book has been borrowed");
        } catch (SQLException e) {
            System.out.println("Book failed to borrow");
            e.printStackTrace();
        }
    }

    @Override
    public Boolean isBookFavorite(int bookid, int userid) {
        String sql = "SELECT isFavorite FROM favoritebook WHERE UserId = ? AND  BookId =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userid);
            statement.setInt(2, bookid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getBoolean("isFavorite");
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to check IdNumber in database");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean isBookBorrowed(int bookId) {
        String sql = "SELECT * FROM borrowedbook WHERE BookId =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookId);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Failed to check if book is borrowed");
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean IsDelayedReturn(int bookId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean isUserBorrowedBook(int Userid) {
        String sql = "SELECT * FROM borrowedbook WHERE UserId =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Userid);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            System.out.println("Failed to check if book is borrowed");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Book> getAllBorrowedBooks(int userId) {
        String sql = "SELECT * FROM borrowedbook WHERE UserId =?";
        List<Book> borrowedBooks = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Book bookStatus = new Book();

                bookStatus.setBookId(rs.getInt("BookId"));
                bookStatus.setBookTitle(rs.getString("Title"));
                bookStatus.setBookAuthor(rs.getString("Author"));
                bookStatus.setBookDateOfPublished(rs.getDate("DateofPublished").toLocalDate());

                // Get image as InputStream
                InputStream inputStream = rs.getBinaryStream("BookImage");
                Image image = null;
                if (inputStream != null) {
                    image = new Image(inputStream);
                }

                bookStatus.setBookImage(image);

                borrowedBooks.add(bookStatus);
            }

            System.out.println("Books Load Successfuully!");

        } catch (Exception e) {
            System.out.println("Failed to load books");
            e.printStackTrace();
        }

        return borrowedBooks;
    }

}
