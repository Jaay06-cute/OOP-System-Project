
package IViews;


public interface IRegisterViews {
    String getFirstName();
    String getLastName();
    String getStudentId();
    String getEmail();
    String getPassword();
    
    void setFirstName(String color, String PromptText,Boolean clearText);
    void setLastName(String color, String PromptText,Boolean clearText);
    void setStudentId(String color, String PromptText,Boolean clearText);
    void setEmail(String color, String PromptText,Boolean clearText);
    void setPassword(String color, String PromptText,Boolean clearText);
    
    void setPromptFirstName(String color, String PromptText);
    void setPromptLastName(String color, String PromptText);
    void setPromptStudentId(String color, String PromptText);
    void setPromptEmail(String color, String PromptText);
    void setPromptPassword(String color, String PromptText);
    
    void ShowMessage(String message);
    
}
