module com.example.week4migration {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.week4migration to javafx.fxml;
    exports com.example.week4migration;
}