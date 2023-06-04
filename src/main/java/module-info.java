module denis.zagorodnev {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    requires spring.jdbc;
    requires java.naming;
    requires com.fasterxml.jackson.databind;

    opens denis.zagorodnev to javafx.fxml;
    exports denis.zagorodnev;
    exports denis.zagorodnev.view.settings;
    opens denis.zagorodnev.view.settings to javafx.fxml;
    exports denis.zagorodnev.controller.englishtab;
    opens denis.zagorodnev.controller.englishtab to javafx.fxml;
    exports denis.zagorodnev.model.entity;
    opens denis.zagorodnev.model.entity to javafx.fxml;
    exports denis.zagorodnev.view.englishtab;
    opens denis.zagorodnev.view.englishtab to javafx.fxml;
}