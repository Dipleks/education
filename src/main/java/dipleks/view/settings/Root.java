package dipleks.view.settings;

import dipleks.view.en.RootWindow;
import javafx.application.Application;
import javafx.stage.Stage;

public class Root extends Application {

    @Override
    public void init() throws Exception {
        //TODO тут будет проверка настроек БД из файла
        System.out.println("Настройки БД подтянуты!");
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RootWindow.getGeneralWindows();
    }
}