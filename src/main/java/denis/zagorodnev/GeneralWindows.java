package denis.zagorodnev;

import denis.zagorodnev.controller.NewWordController;
import denis.zagorodnev.englishtab.EnglishTab;
import denis.zagorodnev.mathtab.MathTab;
import denis.zagorodnev.settings.SizeWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GeneralWindows extends Application {
    private static final double WIDTH = SizeWindow.WIDTH.setSize(1.2);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(1.2);
    private static final Stage WINDOW = new Stage();
    private static final TabPane LESSON_TABS = new TabPane();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        // TODO проверка наличие БД если нет использовать локльно word.json
        super.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        getGeneralWindows();
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
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
    private static void getGeneralWindows() {
        LESSON_TABS.getTabs().addAll(EnglishTab.getTab(), MathTab.getTab());
        WINDOW.setTitle("Образование");
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setScene(new Scene(LESSON_TABS, WIDTH, HEIGHT));
        WINDOW.show();
    }
}