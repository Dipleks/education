package denis.zagorodnev.view.settings;

import denis.zagorodnev.RootWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Root extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RootWindow.getGeneralWindows();
    }
}