
package IViews;

public interface ILoginView {
    String getSchoolEmail();
    String getPassword();
    
    void setSchoolEmail(String color, String setText,Boolean clearText);
    void setPassword(String color, String setText,Boolean clearText);
    
    void setPromptSchoolEmail(String color, String PromptText);
    void setPromptPassword(String color, String PromptText);
    
   
}
