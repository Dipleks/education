package edu.view;

import edu.view.settings.NewWindow;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class RootWindow {
    private static final Stage WINDOW = new Stage();
    private static final String TITLE_WINDOW = "Школьный Мастер";
    private static final String FXML_URL = "/view/schoolMaster.fxml";
//    private static final String FXML_URL = "/fxml/root.fxml";

    private RootWindow() {
    }

    public static void getGeneralWindows() {
        WINDOW.setResizable(true);
        NewWindow.WINDOW.create(
                FXML_URL,
                WINDOW,
                TITLE_WINDOW,
                false
        );
    }

    public static void getAlert(String title, String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(contentText);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}