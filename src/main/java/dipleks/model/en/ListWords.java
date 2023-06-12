package dipleks.model.en;

import dipleks.model.database.ListWordsDatabase;
import dipleks.model.database.entity.DictionaryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListWords {

    public static ObservableList<DictionaryEntity> getListWords() throws Exception{

        return FXCollections.observableArrayList(ListWordsDatabase.getTopWords());
    }
}
