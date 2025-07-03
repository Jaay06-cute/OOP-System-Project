
package Model;

import java.time.LocalDate;
import javafx.scene.image.Image;


public class Book {
    private Image BookImage;
    private String BookTitle;
    private String BookAuthor;
    private LocalDate BookDateOfPublished;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    private LocalDate BookDateAvailability;
    private Boolean IsFavorite;
    private LocalDate BookToReturnDate;
    private int bookId;
    
    public Book(){
        
    }
    
    public Book(int BookId, String Title, String Author, LocalDate dateOfPublished, Image image){
        this.bookId = BookId;
        this.BookTitle = Title;
        this.BookAuthor = Author;
        this.BookDateOfPublished = dateOfPublished;
        this.BookImage = image;
    }
    
    
     public Book( int bookId, Image bookImage,String BookTitle, String BookAuthor, LocalDate BookDateOfPublished, Boolean IsFavorite, Boolean IsAvailable, LocalDate BookDateAvailability, LocalDate BookToReturnDate) {
        this.BookImage = bookImage;
        this.bookId = bookId;
        this.BookTitle = BookTitle;
        this.BookAuthor = BookAuthor;
        this.BookDateOfPublished = BookDateOfPublished;
        this.IsFavorite = IsFavorite;
        this.IsAvailable = IsAvailable;
        this.BookDateAvailability= BookDateAvailability;
        this.BookToReturnDate = BookToReturnDate;
    }

    public LocalDate getBookDateAvailability() {
        return BookDateAvailability;
    }

    public void setBookDateAvailability(LocalDate BookDateAvailability) {
        this.BookDateAvailability = BookDateAvailability;
    }

    public Boolean getIsAvailable() {
        return IsAvailable;
    }

    public void setIsAvailable(Boolean IsAvailable) {
        this.IsAvailable = IsAvailable;
    }
    private Boolean IsAvailable;

   

    public LocalDate getBookToReturnDate() {
        return BookToReturnDate;
    }

    public void setBookToReturnDate(LocalDate BookToReturnDate) {
        this.BookToReturnDate = BookToReturnDate;
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

    public LocalDate getBookDateOfPublished() {
        return BookDateOfPublished;
    }

    public void setBookDateOfPublished(LocalDate BookDateOfPublished) {
        this.BookDateOfPublished = BookDateOfPublished;
    }
    
}
