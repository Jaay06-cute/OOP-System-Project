
package Helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateTimeFormat {
    public String MonthFormat(LocalDate date){
        DateTimeFormatter month = DateTimeFormatter.ofPattern("MMMM d yyyy");
        return date.format(month);
    }
}
