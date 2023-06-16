package dipleks.view.en;

import dipleks.view.settings.NewWindow;
import dipleks.view.settings.SizeWindow;
import javafx.stage.Stage;

public class FavoritesWindow {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(2.5);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(1.5);
    private static final Stage WINDOW = new Stage();
    private static final boolean ALWAYS_ON_TOP = true;
    private static final String TITLE_WINDOW = "Избранное";
    private static final String FXML_URL = "/dipleks/view.en/favorites-window.fxml";

    private FavoritesWindow() {
    }

    public static void getWordsWindow() {
        NewWindow.getNewWindow(
                FXML_URL,
                WINDOW,
                WIDTH,
                HEIGHT,
                TITLE_WINDOW,
                ALWAYS_ON_TOP
        );
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
