package denis.zagorodnev;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;

public class RootWindow {

    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();
    private static final Stage WINDOW = new Stage();

    public static void getGeneralWindows() {
        NewWindow.getNewWindow(
                "/denis/zagorodnev/root-window.fxml",
                WINDOW,
                WIDTH,
                HEIGHT,
                "Образование",
                false
        );
    }
}
