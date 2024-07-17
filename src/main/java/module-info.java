module org.example.lab3java {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab3java to javafx.fxml;
    exports org.example.lab3java;
}