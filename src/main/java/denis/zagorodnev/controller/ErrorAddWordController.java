package denis.zagorodnev.controller;

import denis.zagorodnev.view.settings.ErrorAddWord;
import javafx.fxml.FXML;

public class ErrorAddWordController {
    @FXML
    public void pushForExit() {
        ErrorAddWord.getPushOK();
    }
}
