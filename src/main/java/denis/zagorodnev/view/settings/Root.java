package denis.zagorodnev.view.settings;

import denis.zagorodnev.RootWindow;
import denis.zagorodnev.controller.NewWordControllerOld;
import javafx.application.Application;
import javafx.stage.Stage;

public class Root extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        // TODO проверка наличие БД если нет использовать локльно word.json
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        RootWindow.getGeneralWindows();
    }

    @Override
    public void stop() throws Exception {
        if (NewWordControllerOld.isSAVE()) {
            // TODO резервное копирование БД перед закрытием
            System.out.println("Проверяем были изменеия в БД и сохраняем БД");
        }
        super.stop();
    }
}