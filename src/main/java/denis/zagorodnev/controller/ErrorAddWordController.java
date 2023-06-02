package denis.zagorodnev.controller;

import denis.zagorodnev.view.settings.ErrorAddWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ErrorAddWordController {
    @FXML
    public void pushForExit(ActionEvent actionEvent) throws IOException {
        ErrorAddWord.getPushOK();
    }
}
