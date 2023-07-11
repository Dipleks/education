module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;

    exports edu.controller;
    opens edu.controller to javafx.fxml;
    exports edu;
    opens edu to javafx.fxml;
    exports edu.view;
    opens edu.view to javafx.fxml;
    exports edu.view.settings;
    opens edu.view.settings to javafx.fxml;
}