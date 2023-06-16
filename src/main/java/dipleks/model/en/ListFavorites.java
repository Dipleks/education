package dipleks.model.en;

import dipleks.database.ListWordsDatabase;
import dipleks.database.entity.DictionaryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListFavorites {

    public static ObservableList<DictionaryEntity> getListFavorites() throws Exception{

        return FXCollections.observableArrayList(ListWordsDatabase.getWordsFavorites());
    }
}
