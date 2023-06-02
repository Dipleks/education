package denis.zagorodnev.database;

import denis.zagorodnev.database.DataSourceProvider;
import denis.zagorodnev.model.entity.WordsEntity;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewWordDatabase {

    public static void addWord(String original, String translation) {
        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

        WordsEntity wordsEntity = new WordsEntity()
                .setOriginal(original)
                .setTranslation(translation);

        template.update(
                String.format("INSERT INTO words (original, translation) VALUES ('%s', '%s')",
                        wordsEntity.getOriginal(),
                        wordsEntity.getTranslation())
        );
    }
}
