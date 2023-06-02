package denis.zagorodnev.view.englishtab;

import denis.zagorodnev.controller.NewWordControllerOld;
import denis.zagorodnev.view.settings.Root;
import denis.zagorodnev.view.settings.SizeWindow;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWord {
    private static final double WIDTH = SizeWindow.WIDTH.setSize(3);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(2);

    public static void getWordsWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(
                "/denis/zagorodnev/new-word.fxml"));
        Stage WINDOW = new Stage();
        WINDOW.setScene(new Scene(fxmlLoader.load(),WIDTH,HEIGHT));
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setTitle("Добавить новое слово");
        WINDOW.setAlwaysOnTop(true);
        WINDOW.show();
    }
}
