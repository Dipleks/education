package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.view.englishtab.ErrorConnectDatabase;
import javafx.event.ActionEvent;

public class ErrorConnectController {
    public void pushForExit(ActionEvent actionEvent) {
        ErrorConnectDatabase.getPushOK();
    }
}
