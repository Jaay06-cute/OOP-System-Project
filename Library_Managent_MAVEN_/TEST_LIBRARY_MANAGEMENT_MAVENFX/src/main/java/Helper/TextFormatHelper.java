package Helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;

public class TextFormatHelper {

    public TextFormatter<String> createMaxLengthFormatter(int maxLength) {
        return new TextFormatter<>(change
                -> change.getControlNewText().length() <= maxLength ? change : null);
    }
    
    public boolean validateFields(String firstName, String lastName, String studentId, String studentEmail) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return false;
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            return false;
        }
        if (studentId == null || studentId.trim().isEmpty()) {
            return false;
        }
        if (studentEmail == null || studentEmail.trim().isEmpty()) {
            return false;
        }
        return true;
    }
    
    public boolean isEmailCorrectAddress(String checkEmail,String verifyEmail){
        Pattern pattern = Pattern.compile(verifyEmail);
        Matcher matcher = pattern.matcher(checkEmail);
        if(matcher.find()){
            return true;
        }else{
            return false;
        }
    }
    
    public Boolean IsIdNumber(String idNumber){
            if(5>idNumber.length()){
                return false;
            }
            
            return true;
           
    }
}
