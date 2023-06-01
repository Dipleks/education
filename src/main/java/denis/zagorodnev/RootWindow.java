package denis.zagorodnev;

import denis.zagorodnev.settings.Root;
import denis.zagorodnev.settings.SizeWindow;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class RootWindow {

    private static final double WIDTH = SizeWindow.WIDTH.setSize(1.2);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(1.2);
    private static final Stage WINDOW = new Stage();

    public static void getGeneralWindows() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource(
                "/denis/zagorodnev/root-window.fxml"));
        WINDOW.setTitle("Образование");
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setScene(new Scene(fxmlLoader.load(), WIDTH, HEIGHT));
        WINDOW.show();
    }
}
