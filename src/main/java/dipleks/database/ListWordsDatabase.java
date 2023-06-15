package dipleks.database;

import dipleks.database.entity.DictionaryEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ListWordsDatabase {

    private static final JdbcTemplate TEMPLATE =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    private ListWordsDatabase() {
    }

    public static List<DictionaryEntity> getTopWords() {

        return TEMPLATE.query(
                "SELECT original, translation, favorites FROM words ORDER BY id DESC;",
                (rs, rowNum) -> new DictionaryEntity(
                        rs.getString("original"),
                        rs.getString("translation"),
                        rs.getBoolean("favorites")
                )
        );
    }

    public static void changeFavoritesList(boolean valueFavorites, String original) {

        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());
        template.update("UPDATE words SET favorites = "
                + valueFavorites + " WHERE original = '" + original + "';");
    }
}
