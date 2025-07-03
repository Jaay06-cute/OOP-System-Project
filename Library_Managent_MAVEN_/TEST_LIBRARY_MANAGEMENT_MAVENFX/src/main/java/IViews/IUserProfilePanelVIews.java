
package IViews;

import Model.Book;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


public interface IUserProfilePanelVIews {
    void setUsername(String UserName);
    void setUserEmail(String UserEmail);
    void setStudentId(String StudentId);
    void setImage(Image image);
    void setBookList(ObservableList<String> bookDataListBorrowed);
}
