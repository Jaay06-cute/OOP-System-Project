
package Model;

import javafx.scene.image.Image;

public class User {
    private String email;
    private String FirstName;
    private String LastName;
    private Image image;
    private int studentId;
    private int userId;
    private String Password;
    
     public User() {
    }

    public User(int userId, String FirstName, String LastName, int studentId, String email,String Password) {
        this.userId = userId;
        this.FirstName= FirstName;
        this.LastName =LastName;
        this.studentId=studentId;
        this.email=email;
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    

 
}
