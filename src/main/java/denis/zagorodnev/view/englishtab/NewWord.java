package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.NewWindow;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.stage.Stage;
import java.io.IOException;

public class NewWord {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);
    private static final Stage WINDOW = new Stage();

    public static void getWordsWindow() throws IOException {
        NewWindow.getNewWindow(
                "/denis/zagorodnev/new-word.fxml",
                WINDOW,
                WIDTH,
                HEIGHT,
                "Добавить новое слово",
                true
        );
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
