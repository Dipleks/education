package dipleks.model.en;

import dipleks.database.ListWordsDatabase;
import dipleks.database.entity.DictionaryEntity;
import javafx.collections.ObservableList;

public class Favorites {

    public static void getListFavorites(ObservableList<DictionaryEntity> listWord) {
        try {
            for (DictionaryEntity d : listWord) {
                boolean isSelected = d.getFavorites().isSelected();
                ListWordsDatabase.changeFavoritesList(isSelected, d.getOriginal());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
