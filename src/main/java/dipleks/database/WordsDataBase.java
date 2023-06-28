package dipleks.database;

import dipleks.database.entity.DictionaryEntity;
import dipleks.database.entity.WordsEntity;
import dipleks.model.en.Backup;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public enum WordsDataBase {
    LIST {
        public void add(String original, String translation) {

            WordsEntity wordsEntity = new WordsEntity()
                    .setOriginal(original)
                    .setTranslation(translation);
            TEMPLATE.update(
                    String.format("INSERT INTO words (original, translation) VALUES ('%s', '%s')",
                            wordsEntity.getOriginal(),
                            wordsEntity.getTranslation())
            );
        }

        public List<DictionaryEntity> get() {

            return TEMPLATE.query(
                    "SELECT original, translation, favorites FROM words ORDER BY id DESC;",
                    (rs, rowNum) -> new DictionaryEntity(
                            rs.getString("original"),
                            rs.getString("translation"),
                            rs.getBoolean("favorites")
                    )
            );
        }

        public void updateFavorites(boolean valueFavorites, String original) {

            TEMPLATE.update("UPDATE words SET favorites = "
                    + valueFavorites + " WHERE original = '" + original + "';");
        }

        public List<DictionaryEntity> showFavorites() {

            return TEMPLATE.query(
                    "SELECT original, translation, favorites FROM words WHERE favorites = true;",
                    (rs, rowNum) -> new DictionaryEntity(
                            rs.getString("original"),
                            rs.getString("translation"),
                            rs.getBoolean("favorites")
                    )
            );
        }

        public void restoreFromBackup() {

            TEMPLATE.update("TRUNCATE words;"); // удаляем все значения из таблицы, во избежание дублекатов
            for (String requestSQL : Backup.LIST.getListSQL()) {
                TEMPLATE.update(requestSQL);
            }
        }
    };

    private static final JdbcTemplate TEMPLATE =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    public abstract void add(String original, String translation);

    public abstract List<DictionaryEntity> get();

    public abstract void updateFavorites(boolean valueFavorites, String original);

    public abstract List<DictionaryEntity> showFavorites();

    public abstract void restoreFromBackup();
}