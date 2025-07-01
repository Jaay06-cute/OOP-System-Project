
package Model;

import javafx.scene.image.Image;


public class Book {
    private Image BookImage;
    private String BookTitle;
    private String BookAuthor;
    private String BookDateOfPublished;
    private Boolean IsFavorite;
    private Boolean IsAvailable;

    public Book( Image bookImage,String BookTitle, String BookAuthor, String BookDateOfPublished, Boolean IsFavorite, Boolean IsAvailable) {
        this.BookImage = bookImage;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.BookDateOfPublished = BookDateOfPublished;
        this.IsFavorite = IsFavorite;
        this.IsAvailable = IsAvailable;
    }
    
    public Boolean getIsBorrowed() {
        return IsAvailable;
    }

    public void setIsBorrowed(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
  
    public Boolean getIsFavorite() {
        return IsFavorite;
    }

    public void setIsFavorite(Boolean IsFavorite) {
        this.IsFavorite = IsFavorite;
    }

    public Image getBookImage() {
        return BookImage;
    }

    public void setBookImage(Image BookImage) {
        this.BookImage = BookImage;
    }

    public String getBookTitle() {
        return BookTitle;
    }

    public void setBookTitle(String BookTitle) {
        this.BookTitle = BookTitle;
    }

    public String getBookAuthor() {
        return BookAuthor;
    }

    public void setBookAuthor(String BookAuthor) {
        this.BookAuthor = BookAuthor;
    }

    public String getBookDateOfPublished() {
        return BookDateOfPublished;
    }

    public void setBookDateOfPublished(String BookDateOfPublished) {
        this.BookDateOfPublished = BookDateOfPublished;
    }
    
}
