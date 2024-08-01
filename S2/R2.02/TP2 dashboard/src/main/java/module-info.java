module com.example.tp2dashboard {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.tp2dashboard to javafx.fxml;
    exports com.example.tp2dashboard;
}