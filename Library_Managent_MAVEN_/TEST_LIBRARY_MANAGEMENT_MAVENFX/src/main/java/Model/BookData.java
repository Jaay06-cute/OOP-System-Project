/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.List;
import javafx.scene.image.Image;


public class BookData {
    
    private Image book1 = new Image(getClass().getResourceAsStream("/Icon/book1.jpg"));
    private Image book2 = new Image(getClass().getResourceAsStream("/Icon/book2.jpg"));
    private Image book3 = new Image(getClass().getResourceAsStream("/Icon/book3.jpg"));
    private Image book4 = new Image(getClass().getResourceAsStream("/Icon/book4.jpg"));
    private Image book5 = new Image(getClass().getResourceAsStream("/Icon/book5.jpg"));
    
    private LocalDate day1,day2,day3,day4,day5, Availday1, Availday2,Availday3,Availday4,Availday5,
                        NeedToReturnBookDate1,NeedToReturnBookDate2,NeedToReturnBookDate3,NeedToReturnBookDate4,NeedToReturnBookDate5;
    
    
    
    public List<Book> book(){
            
            day1 = LocalDate.of(1999, 2, 12);
            day2 = LocalDate.of(1982, 2, 10);
            day3 = LocalDate.of(1999, 3, 11);
            day4 = LocalDate.of(2019, 2, 22);
            day5 = LocalDate.of(1989, 4, 11);
            
            Availday1 = LocalDate.of(2025, 7, 1);
            Availday2 = LocalDate.of(2025, 7, 2);
            Availday3 = LocalDate.of(2025, 6, 10);
            Availday4 = LocalDate.of(2025, 7, 22);
            Availday5 = LocalDate.of(2025, 7, 11);
            
                    
            NeedToReturnBookDate1 = LocalDate.of(2025, 7, 22);
            NeedToReturnBookDate2 = LocalDate.of(2025, 7, 21);
            NeedToReturnBookDate3 = LocalDate.of(2025, 6, 23);
            NeedToReturnBookDate4 = LocalDate.of(2025, 7, 24);
            NeedToReturnBookDate5 = LocalDate.of(2025, 4, 02);
        
           List<Book> books = List.of(
            new Book(1,book1,"Never Ending Sky", "Joseph Kirkland", day1,false,true,Availday1,NeedToReturnBookDate1),
            new Book(2,book2,"The Sum of All Things", "Nicolas Douglas", day2,true,true,Availday2,NeedToReturnBookDate2),
            new Book(3,book3,"Soul", "Alexis Ejercito", day3,true,false,Availday3,NeedToReturnBookDate3),
            new Book(4,book4,"Hanging House", "Ryan Reynolds", day4,true,false,Availday4,NeedToReturnBookDate4),
            new Book(5,book5,"The Hobbit", "", day5 ,false,true,Availday5,NeedToReturnBookDate5)
        );
           
           return books;
    }
    
    
    
    
   
    
    
    
    
}
