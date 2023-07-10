module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires com.fasterxml.jackson.databind;

    exports edumath.controller;
    opens edumath.controller to javafx.fxml;
    exports edumath;
    opens edumath to javafx.fxml;
    exports edumath.view;
    opens edumath.view to javafx.fxml;
    exports edumath.settings;
    opens edumath.settings to javafx.fxml;
    exports edumath.controller.math;
    opens edumath.controller.math to javafx.fxml;
    exports edumath.model.json;
    opens edumath.model.json to com.fasterxml.jackson.databind;
    exports edumath.model.entity;
    opens edumath.model.entity to com.fasterxml.jackson.databind;
}