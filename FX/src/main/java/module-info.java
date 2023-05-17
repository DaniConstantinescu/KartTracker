module com.example.fx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;
    requires org.junit.jupiter.api;

    opens com.example.fx to javafx.fxml;
    exports com.example.fx;
}