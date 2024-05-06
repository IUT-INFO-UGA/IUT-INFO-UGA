module com.example.exo1_tp1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exo1_tp1 to javafx.fxml;
    exports com.example.exo1_tp1;
}