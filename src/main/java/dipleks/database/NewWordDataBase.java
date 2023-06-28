package dipleks.database;

import dipleks.database.entity.WordsEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public enum NewWordDataBase {
    NEW_WORD {
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
    };

    private static final JdbcTemplate TEMPLATE =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    public abstract void add(String original, String translation);

}
