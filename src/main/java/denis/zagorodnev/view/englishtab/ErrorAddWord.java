package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;

public class ErrorAddWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(4);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(4);
    private static final Stage ERROR = new Stage();
    private static Stage WINDOW;

    public static void getErrorAddWord(Stage window) {
        WINDOW = window;
        NewWindow.getNewWindow(
                "/denis/zagorodnev/error-add-word.fxml",
                ERROR,
                WIDTH,
                HEIGHT,
                "Error",
                true
        );

        if (window != null) {
            ERROR.setOnCloseRequest(event -> window.show());
            window.close();
        }
    }

    public static void getPushOK() {
        ERROR.close();
        WINDOW.show();
    }
}
