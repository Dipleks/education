package denis.zagorodnev;

import denis.zagorodnev.englishtab.EnglishTab;
import denis.zagorodnev.mathtab.MathTab;
import denis.zagorodnev.settings.SizeWindow;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class GeneralWindows {
    private static final double WIDTH = SizeWindow.WIDTH.setSize(1.2);
    private static final double HEIGHT = SizeWindow.HEIGHT.setSize(1.2);
    private static final Stage WINDOW = new Stage();
    private static final TabPane LESSON_TABS = new TabPane();

    public static void getGeneralWindows() {
        LESSON_TABS.getTabs().addAll(EnglishTab.getTab(), MathTab.getTab());
        WINDOW.setTitle("Образование");
        WINDOW.getIcons().add(new Image("/icone.png"));
        WINDOW.setScene(new Scene(LESSON_TABS, WIDTH, HEIGHT));
        WINDOW.show();
    }
}