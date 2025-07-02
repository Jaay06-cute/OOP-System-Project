/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_Management_Maven.Authentication;
        
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ravin
 */
public class UserDAO<T extends Identifiable> {
    private List<T> userList = new ArrayList<>();
    private Class<T> userSession;
    
    public UserDAO(Class<T> userSession) {
        this.userSession = userSession;
    }

    // CREATE
    public void addUser(String firstName, String lastName, int idNumber, String email){
        // find a way to instatiate the UserDAO<T> generic
        try{
            Constructor<T> constructor = userSession.getConstructor(String.class, String.class, int.class, String.class);
            T user = constructor.newInstance(firstName, lastName, idNumber, email);
            userList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // READ
    public T getUserByID(int id) {
        for (T user : userList) {
            if (id == user.getIDNumber()) {
                return user;
            }
        }
        return null;
    }
    
    // UPDATE TO COME!!!! sabutan pa ni siya
    
    // DELETE
    public boolean deleteUser(int id) {
        T user = getUserByID(id);
        if (user != null){
            userList.remove(user);
            return true;
        }
        return false;
    }
}
