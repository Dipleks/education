package edumath.view;

import javafx.scene.control.Alert;

public class AlertWindow {

    public static Alert getAlertInformation(String title, String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(info);
        alert.setHeaderText(null);
        return alert;
    }
}
