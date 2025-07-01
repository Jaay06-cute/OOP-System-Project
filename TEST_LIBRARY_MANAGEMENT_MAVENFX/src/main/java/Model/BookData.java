
package Model;

import java.util.List;
import javafx.scene.image.Image;


public class BookData {
    
    private Image book1 = new Image(getClass().getResourceAsStream("/Icon/book1.jpg"));
    private Image book2 = new Image(getClass().getResourceAsStream("/Icon/book2.jpg"));
    private Image book3 = new Image(getClass().getResourceAsStream("/Icon/book3.jpg"));
    private Image book4 = new Image(getClass().getResourceAsStream("/Icon/book4.jpg"));
    private Image book5 = new Image(getClass().getResourceAsStream("/Icon/book5.jpg"));
    
    
    public List<Book> book(){
        
           List<Book> books = List.of(
            new Book(book1,"Never Ending Sky", "Joseph Kirkland", "05/12/18",false,true),
            new Book(book2,"The Sum of All Things", "Nicolas Douglas", "05/12/21",true,true),
            new Book(book3,"Soul", "Alexis Ejercito", "12/10/70",true,false),
            new Book(book4,"Hanging House", "Ryan Reynolds", "12/12/25",true,false),
            new Book(book5,"The Hobbit", "Lea Jhona", "05/12/18",false,true)
        );
           
           return books;
    }
    
    
    
    
}
