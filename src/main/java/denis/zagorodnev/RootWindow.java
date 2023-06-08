package denis.zagorodnev;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;

public class RootWindow {

    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();
    private static final Stage WINDOW = new Stage();
    private static final String TITLE_WINDOW = "Образование";
    private static final String FXML_URL = "/denis/zagorodnev/root-window.fxml";

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

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
