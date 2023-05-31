package denis.zagorodnev.englishtab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EnglishTab {

    private static final Tab ENGLISH_TAB = new Tab("Английский");
    private final Button NEW_WORD = new Button("Добавить новое слово");
    private final BorderPane ROOT = new BorderPane();

    private EnglishTab() {
    }

    public static Tab getTab() {

        EnglishTab englishTab = new EnglishTab();
        ENGLISH_TAB.setContent(englishTab.getElementsTab());
        ENGLISH_TAB.closableProperty().setValue(false);
        return ENGLISH_TAB;
    }

    private BorderPane getElementsTab() {

        NEW_WORD.setOnAction(event -> NewWord.getWordsWindow());

        ROOT.setTop(getTopPane());
        ROOT.setCenter(getCenterPane());
        return ROOT;
    }

    private HBox getTopPane() {
        HBox topPane = new HBox();
        topPane.setPadding(new Insets(20,20,20,20));
        topPane.setSpacing(20);
        topPane.getChildren().addAll(NEW_WORD, new Label("В дальнейшем добавить: БД отключена/подключена!"));
        return topPane;
    }

    private VBox getCenterPane() {
        VBox centerPane = new VBox();
        centerPane.setPadding(new Insets(80,20,20,20));
        centerPane.setAlignment(Pos.TOP_CENTER);
        centerPane.setMaxWidth(300);
        centerPane.setSpacing(20);
        centerPane.getChildren().addAll(
                new Label("Слово для перевода"),
                new TextField("Тут Пишем перевод"),
                new Button("Проверить результат"),
                new Label("ТУТ ВЫВОДИМ РЕЗУЛЬТАТ ПРОВЕРКИ!!!")
        );
        return centerPane;
    }
}
