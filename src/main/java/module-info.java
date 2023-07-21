module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires spring.core;
    requires spring.beans;
    requires spring.context;

    exports edu;
    opens edu to javafx.fxml;
    exports edu.startApp;
    opens edu.startApp to javafx.fxml;
    exports edu.controller.mathematics;
    opens edu.controller.mathematics to javafx.fxml;
    exports edu.controller.english;
    opens edu.controller.english to javafx.fxml;
    exports edu.controller;
    opens edu.controller to javafx.fxml;
}