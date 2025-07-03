package Model;

import DAO.UserDAO;
import Services.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplements implements UserDAO {

    private Connection connection;

    public UserDAOImplements() {
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
    public void addUser(User user) {
        String sql = "INSERT INTO user(FirstName,LastName,IdNumber,SchoolEmail, Password ) VALUES(?,?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getStudentId());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());

            statement.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            System.out.println("User added failed");
            e.printStackTrace();
        }
    }

    @Override
    public User getUserById(int id) {
        String sql = "SELECT * FROM user WHERE UserId =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getInt("UserId"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setStudentId(resultSet.getInt("IdNumber"));
                user.setEmail(resultSet.getString("SchoolEmail"));

                return user;
            }
        } catch (SQLException e) {
            System.out.println("Failed to find user by id");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";
        List<User> userList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User user = new User();

                user.setUserId(resultSet.getInt("UserId"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                user.setStudentId(resultSet.getInt("IdNumber"));
                user.setEmail(resultSet.getString("SchoolEmail"));

                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println("Failed load all users");
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE user SET FirstName = ?, LastName = ?,IdNumber =?, SchoolEmail=? , Password = ? WHERE UserId  = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setInt(3, user.getStudentId());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.setInt(6, user.getUserId());

            int rowsUpdate = statement.executeUpdate();
            if (rowsUpdate > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No user found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update user");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE UserId = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete user");
            e.printStackTrace();
        }
    }

    @Override
    public Boolean IsIdNumberExist(int idNumber) {
        String sql = "SELECT IdNumber FROM user WHERE IdNumber = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to check IdNumber in database");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean IsStudentEmail(String StudentEmail) {
        String sql = "SELECT SchoolEmail FROM user WHERE SchoolEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, StudentEmail);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to check STUDENT EMAIL in database");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean IsPasswordExist(String Password, String Email) {
        String sql = "SELECT Password FROM user WHERE SchoolEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, Email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    if (resultSet.getString("Password").equals(Password)) {
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Failed to check STUDENT EMAIL in database");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getUserbySchoolEmail(String StudentEmail) {
        String sql = "SELECT * FROM user WHERE SchoolEmail = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, StudentEmail);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    
                    user.setUserId(rs.getInt("UserId"));
                    user.setFirstName(rs.getString("FirstName"));
                    user.setLastName(rs.getString("LastName"));
                    user.setStudentId(rs.getInt("IdNumber"));
                    user.setEmail(rs.getString("SchoolEmail"));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
