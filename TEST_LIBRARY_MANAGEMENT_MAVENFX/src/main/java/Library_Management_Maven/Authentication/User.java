/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Library_Management_Maven.Authentication;

/**
 *
 * @author Ravin
 */

enum AccessStatus {
    GRANTED,
    DENIED,
    SUSPENDED,
    READ_ONLY;
}

interface Identifiable {
    int getIDNumber();
}

abstract class User implements Identifiable{
    private String firstName;
    private String lastName;
    private int idNumber;
    private String email;
    
    public User(){}

    public User(String firstName, String lastName, int idNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.email = email;
    }
    
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    
    @Override
    public int getIDNumber() {return idNumber;}
    public String getEmail() {return email;}
}
