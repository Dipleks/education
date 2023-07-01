package dipleks.controller;

import dipleks.view.en.RootWindow;
import javafx.fxml.FXML;

public class DictionaryWordController {

    @FXML
    public void openRootWindow() {
        RootWindow.getGeneralWindows();
    }
}
