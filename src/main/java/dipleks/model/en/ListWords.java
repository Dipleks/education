package dipleks.model.en;

import dipleks.database.ListWordsDatabase;
import dipleks.database.entity.DictionaryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListWords {

    public static ObservableList<DictionaryEntity> getListWords() throws Exception{

        return FXCollections.observableArrayList(ListWordsDatabase.getTopWords());
    }
}
