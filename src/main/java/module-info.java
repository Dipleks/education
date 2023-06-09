module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires com.fasterxml.jackson.databind;

    opens dipleks to javafx.fxml;
    exports dipleks;
    exports dipleks.view.settings;
    opens dipleks.view.settings to javafx.fxml;
    exports dipleks.controller.englishtab;
    opens dipleks.controller.englishtab to javafx.fxml;
    exports dipleks.model.database.entity;
    opens dipleks.model.database.entity to javafx.fxml;
    exports dipleks.view.englishtab;
    opens dipleks.view.englishtab to javafx.fxml;
}