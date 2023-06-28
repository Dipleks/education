package dipleks.controller.en;

import dipleks.database.WriterBackupWordInDB;
import dipleks.model.en.Favorites;
import dipleks.view.en.FavoritesWindow;
import dipleks.view.en.RootWindow;
import dipleks.database.entity.DictionaryEntity;
import dipleks.model.en.ListWords;
import dipleks.view.en.NewWordWindow;
import dipleks.view.settings.Root;
import dipleks.view.settings.SizeWindow;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnglishTabController implements Initializable {

    @FXML
    private MenuBar menuBar;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField search;
    @FXML
    private VBox topTableWordPane;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<DictionaryEntity> topTableWord;
    @FXML
    private TableColumn<DictionaryEntity, String> original;
    @FXML
    private TableColumn<DictionaryEntity, String> translation;
    @FXML
    private TableColumn<DictionaryEntity, Boolean> favorites;

    private static final String FXML_URL_TASK = "/dipleks/view.en/tasks-in-english.fxml";
    private static final double WIDTH = SizeWindow.getRootWindowWIDTH();
    private static final double HEIGHT = SizeWindow.getRootWindowHEIGHT();

    private ObservableList<DictionaryEntity> dictionary;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getSizeView();
        topTableWordPane.setLayoutY(HEIGHT / 6);
        getSearchableDictionary();
    }

    @FXML
    private void addFavorites() {
        Favorites.getListFavorites(dictionary);
        RootWindow.getAlert("Избранное", "Ваш выбор сохранен!");
    }

    @FXML
    private void addWord() {
        NewWordWindow.getWordsWindow();
    }

    @FXML
    private void passTest() {
        rootPane.getChildren().clear();
        try {
            rootPane.getChildren().add(
                    new FXMLLoader(Root.class.getResource(EnglishTabController.FXML_URL_TASK)).load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getSearchableDictionary() {

        original.setCellValueFactory(new PropertyValueFactory<>("original"));
        translation.setCellValueFactory(new PropertyValueFactory<>("translation"));
        favorites.setCellValueFactory(new PropertyValueFactory<>("favorites"));

        try {
            dictionary = ListWords.getListWords();
            topTableWord.setItems(dictionary);

            FilteredList<DictionaryEntity> filteredList =
                    new FilteredList<>(dictionary, b -> true);
            search.textProperty().addListener((observable, oldValue, newValue) ->
                    filteredList.setPredicate(topWordsEntity -> {

                        if (newValue.isEmpty() || newValue.isBlank()) {
                            return true;
                        }

                        String searchKeyword = newValue.toLowerCase();

                        if (topWordsEntity.getOriginal().toLowerCase().contains(searchKeyword)) {
                            return true;
                        } else return topWordsEntity.getTranslation().toLowerCase().contains(searchKeyword);
                    }));

            SortedList<DictionaryEntity> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(dictionary.sorted().comparatorProperty());
            topTableWord.setItems(sortedList);
        } catch (Exception e) {
            RootWindow.getAlert("Information error",
                    "Error: no database connection." +
                    "\nОтсутствует подключение к базе данных!"
            );
        }
    }

    private void getSizeView() {
        menuBar.setPrefWidth(SizeWindow.WIDTH.setSize(1));
        tabPane.setPrefWidth(SizeWindow.WIDTH.setSize(1));

        //favoritesOriginal.setPrefWidth(WIDTH / 5);
        original.setPrefWidth(WIDTH / 5);
       // favoritesTranslation.setPrefWidth(WIDTH / 5);
        translation.setPrefWidth(WIDTH / 5);
        favorites.setPrefWidth(WIDTH / 10);
    }

    @FXML
    private void openFavorites() {
        FavoritesWindow.getWordsWindow();
    }

    @FXML
    private void getBackup() {
        rootPane.getChildren().clear();
        WriterBackupWordInDB.writeDown();
        RootWindow.getGeneralWindows();
        RootWindow.getAlert("Backup", "Значения обновлены в Базе Данных!");
    }
}