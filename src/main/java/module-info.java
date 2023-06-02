module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires com.fasterxml.jackson.databind;

//    opens denis.zagorodnev;
//    exports denis.zagorodnev;
    opens denis.zagorodnev to javafx.fxml;
    exports denis.zagorodnev;
    exports denis.zagorodnev.view.settings;
    opens denis.zagorodnev.view.settings to javafx.fxml;
    exports denis.zagorodnev.controller;
    opens denis.zagorodnev.controller to javafx.fxml;
}