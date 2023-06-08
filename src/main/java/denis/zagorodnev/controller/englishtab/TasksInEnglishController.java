package denis.zagorodnev.controller.englishtab;

import denis.zagorodnev.RootWindow;
import denis.zagorodnev.view.englishtab.TasksInEnglish;
import javafx.fxml.FXML;

public class TasksInEnglishController {

    @FXML
    public void openRootWindow() {
        RootWindow.getGeneralWindows();
        TasksInEnglish.getWINDOW().close();
    }
}
