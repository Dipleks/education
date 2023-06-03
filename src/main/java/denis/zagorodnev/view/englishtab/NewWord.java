package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.view.settings.Root;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class NewWord {
    private static final Stage WINDOW = new Stage();

    public static void getWordsWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(
                "/denis/zagorodnev/new-word.fxml"));
        WINDOW.setScene(new Scene(fxmlLoader.load()));
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setTitle("Добавить новое слово");
        WINDOW.setAlwaysOnTop(true);
        WINDOW.show();
    }

    public static Stage getWINDOW() {
        return WINDOW;
    }
}
