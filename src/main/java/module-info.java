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
    exports dipleks.controller;
    opens dipleks.controller to javafx.fxml;
    exports dipleks.entity;
    opens dipleks.entity to javafx.fxml;
    exports dipleks.view.en;
    opens dipleks.view.en to javafx.fxml;
    exports dipleks.model;
    opens dipleks.model to javafx.fxml;
}