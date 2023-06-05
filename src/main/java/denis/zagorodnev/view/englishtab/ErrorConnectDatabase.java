package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.NewWindow;
import javafx.stage.Stage;

public class ErrorConnectDatabase {

    private ErrorConnectDatabase() {
    }

    private static final Stage ERROR = new Stage();

    public static void getErrorConnectWindow() {
        NewWindow.getNewWindow(
                "/denis/zagorodnev/error-connect-window.fxml",
                ERROR,
                330,
                150,
                "Error",
                true
        );
    }

    public static void getPushOK() {
        ERROR.close();
    }
}
