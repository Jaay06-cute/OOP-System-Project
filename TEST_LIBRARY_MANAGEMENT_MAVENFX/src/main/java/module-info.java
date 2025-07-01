module com.mycompany.Library_Management_Maven {
    requires javafx.controls;
    requires javafx.fxml;

    opens Library_Management_Maven to javafx.fxml;
    exports Library_Management_Maven;
    
    opens com.mycompany.Library_Management_Maven.ViewController to javafx.fxml;
    exports com.mycompany.Library_Management_Maven.ViewController;
    
    opens IViews to javafx.fxml;
    exports IViews;
    
}
