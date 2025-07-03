
package Model;

import java.time.LocalDate;

public class UserBookStatus {
    private int userId;
    private int bookId;
    private boolean isBorrowed;
    private boolean isInFavorites;
    private boolean hasDelayedReturn;
    private LocalDate borrowedDate;
    private LocalDate dueDate;
    
    public UserBookStatus(){
        
    }
    public UserBookStatus(int userId,int bookId, Boolean isBorrowed, Boolean IsInfavorite, Boolean HasDelayedReturn, LocalDate borrowedDate, LocalDate dueDate)
    {
        this.userId = userId;
        this.bookId = bookId;
        this.isBorrowed = isBorrowed;
        this.isInFavorites = IsInfavorite;
        this.hasDelayedReturn = HasDelayedReturn;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean isIsInFavorites() {
        return isInFavorites;
    }

    public void setIsInFavorites(boolean isInFavorites) {
        this.isInFavorites = isInFavorites;
    }

    public boolean isHasDelayedReturn() {
        return hasDelayedReturn;
    }

    public void setHasDelayedReturn(boolean hasDelayedReturn) {
        this.hasDelayedReturn = hasDelayedReturn;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    
}
