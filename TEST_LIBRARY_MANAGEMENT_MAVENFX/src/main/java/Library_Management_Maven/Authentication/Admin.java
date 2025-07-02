/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_Management_Maven.Authentication;

/**
 *
 * @author Ravin
 */
public class Admin extends User {
    private AccessStatus accessStatus = AccessStatus.GRANTED;
    
    public Admin(String firstName, String lastName, int idNumber, String email){
        super(firstName, lastName, idNumber, email);
    }
    
    public AccessStatus checkAccessStatus() { return accessStatus; }
}
