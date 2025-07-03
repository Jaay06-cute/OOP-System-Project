
package Model;

import java.time.LocalDate;


public class ActionLog {
    private LocalDate ActionTime;
    private String ActionDescription;
    private Book book;
    
     public ActionLog(Book book, LocalDate ActionTime, String ActionDescription){
        this.ActionDescription = ActionDescription;
        this.ActionTime = ActionTime;
        this.book = book;
    }

    public LocalDate getActionTime() {
        return ActionTime;
    }

    public void setActionTime(LocalDate ActionTime) {
        this.ActionTime = ActionTime;
    }

    public String getActionDescription() {
        return ActionDescription;
    }

    public void setActionDescription(String ActionDescription) {
        this.ActionDescription = ActionDescription;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
    
    
}
