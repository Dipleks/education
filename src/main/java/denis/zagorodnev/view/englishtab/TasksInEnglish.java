package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;

public class TasksInEnglish {

    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();
    private static final Stage WINDOW = new Stage();
    private static final String TITLE_WINDOW = "Задания";
    private static final String FXML_URL = "/denis/zagorodnev/tasks-in-english.fxml";

    private TasksInEnglish() {
    }

    public static void getTasksInEnglish() {
        NewWindow.getNewWindow(
                FXML_URL,
                WINDOW,
                WIDTH,
                HEIGHT,
                TITLE_WINDOW,
                true
        );
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
