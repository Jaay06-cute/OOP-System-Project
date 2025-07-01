
package IViews;

import javafx.scene.image.Image;


public interface IBookView {
    void setBookTitle(String bookTitle);
    void setBookAuhtor(String bookAuthor);
    void setBookDateofPublished(String bookDate);
    void setStatus(String bookStatus);
    void checkStatus(String checkStatus);
    void setImage(Image image);
   
}
