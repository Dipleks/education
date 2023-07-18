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
    requires spring.web;
    requires spring.webmvc;
    requires thymeleaf.spring5;

    exports edu.controller;
    opens edu.controller to javafx.fxml;
    exports edu.mathematics.controller;
    opens edu.mathematics.controller to javafx.fxml;
    exports edu;
    opens edu to javafx.fxml;
    exports edu.view;
    opens edu.view to javafx.fxml;
    exports edu.view.settings;
    opens edu.view.settings to javafx.fxml;
}