package denis.zagorodnev.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewWordController {

    @FXML
    public TextField original;
    @FXML
    public TextField translation;

    @FXML
    public void addWord(ActionEvent actionEvent) {
        String inputInEng = original.getText();
        String inputTranslation = translation.getText();

    }
}
