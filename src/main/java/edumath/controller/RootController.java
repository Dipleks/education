package edumath.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private Pane math;
    @FXML
    private Pane en;

    @FXML
    private void getMath() {
        math.setVisible(false);
        en.setVisible(true);
    }

    @FXML
    private void getEn() {
        en.setVisible(false);
        math.setVisible(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
