package denis.zagorodnev.settings;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ErrorWindow {

    private static final Button OK = new Button("OK");
    private static final double WIDTH = SizeWindow.WIDTH.setSize(3.5);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(4);

    private ErrorWindow() {
    }

    public static void getErrorWindow(Stage window, String textError) {

        VBox panel = new VBox(new Label(textError), OK);
        panel.setSpacing(HEIGHT / 10);
        panel.setAlignment(Pos.CENTER);

        Stage error = new Stage();
        error.setScene(new Scene(panel,WIDTH,HEIGHT));
        error.setTitle("Error");
        error.setAlwaysOnTop(true);
        error.show();

        if (window != null) {
            error.setOnCloseRequest(event -> window.show());
            window.close();
            OK.setOnAction(event -> {
                error.close();
                window.show();
            });
        } else {
            OK.setOnAction(event -> error.close());
        }
    }
}
