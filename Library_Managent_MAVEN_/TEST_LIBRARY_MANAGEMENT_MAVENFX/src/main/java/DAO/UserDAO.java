
package DAO;

import Model.User;
import java.util.List;

public interface UserDAO {
    
    void addUser(User user);
    User getUserById(int id);
    Boolean IsPasswordExist(String Password, String Email);
    List<User> getAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
    Boolean IsIdNumberExist(int idNumber);
    Boolean IsStudentEmail(String StudentEmail);
    User getUserbySchoolEmail(String StudentEmail);
    
}
