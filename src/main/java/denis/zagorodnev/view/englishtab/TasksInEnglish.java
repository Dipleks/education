package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;

public class TasksInEnglish {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();

    public static void getTasksInEnglish() {
        NewWindow.getNewWindow(
                "/denis/zagorodnev/tasks-in-english.fxml",
                WINDOW,
                798,
                599,
                "Задания",
                true
        );
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
