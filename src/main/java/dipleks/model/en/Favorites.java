package dipleks.model.en;

import dipleks.database.entity.DictionaryEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Favorites {

    public static void getListFavorites(ObservableList<DictionaryEntity> listWord) {
        try {
            ObservableList<DictionaryEntity> list = FXCollections.observableArrayList();
            for (DictionaryEntity d : listWord) {
                if (d.getFavorites().isSelected()) {
                    list.add(d);
                }
            }
            list.forEach(System.out::println);
            System.out.println(list.get(0).getOriginal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
