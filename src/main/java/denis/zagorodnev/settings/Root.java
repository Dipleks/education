package denis.zagorodnev.settings;

import denis.zagorodnev.RootWindow;
import denis.zagorodnev.controller.NewWordController;
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
        if (NewWordController.isSAVE()) {
            // TODO резервное копирование БД перед закрытием
            System.out.println("Проверяем были изменеия в БД и сохраняем БД");
        }
        super.stop();
    }
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Root.class.getResource("denis.zagorodnev.root-window.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
}