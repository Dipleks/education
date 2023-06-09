package dipleks.view.en;

import dipleks.view.settings.NewWindow;
import dipleks.view.settings.SizeWindow;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class RootWindow {

    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();
    private static final Stage WINDOW = new Stage();
    private static final String TITLE_WINDOW = "Образование";
    private static final String FXML_URL = "/dipleks/view.en/root-window.fxml";

    private RootWindow() {
    }

    public static void getGeneralWindows() {
        NewWindow.getNewWindow(
                FXML_URL,
                WINDOW,
                WIDTH,
                HEIGHT,
                TITLE_WINDOW,
                false
        );
    }

    public static void getErrorDatabaseConnect() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information error");
        alert.setContentText("Error: no database connection." +
                "\nОтсутствует подключение к базе данных!");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
