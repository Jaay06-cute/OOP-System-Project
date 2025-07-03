
package IViews;

import javafx.scene.image.Image;


public interface IBookView {
    void setBookTitle(String bookTitle);
    void setBookAuhtor(String bookAuthor);
    void setBookDateofPublished(String bookDate);
    void setStatus(String bookStatus, String color);
    void checkStatus(String checkStatus, Boolean check);
    void setImage(Image image);
    void setBookNote(int visible,String note);
   
}
