
package IViews;


public interface ICardLayoutView {
    void getBookTitle(String bookTitle);
    void getBookAuhtor(String bookAuthor);
    void getBookDateofPublished(String DateofPublished);
    Boolean IsBorrow();
    void setStatus(String bookStatus);
}
