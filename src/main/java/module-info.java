module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires com.fasterxml.jackson.databind;
    requires kotlin.stdlib;

    opens dipleks to javafx.fxml;
    exports dipleks;
    exports dipleks.view.settings;
    opens dipleks.view.settings to javafx.fxml;
    exports dipleks.controller.en;
    opens dipleks.controller.en to javafx.fxml;
    exports dipleks.database.entity;
    opens dipleks.database.entity to javafx.fxml;
    exports dipleks.view.en;
    opens dipleks.view.en to javafx.fxml;
    exports dipleks.model.en;
    opens dipleks.model.en to javafx.fxml;
}