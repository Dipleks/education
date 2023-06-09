package dipleks.model.database;

import dipleks.model.database.entity.WordsEntity;
import dipleks.view.englishtab.NewWord;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewWordDatabase {

    public static void addWord(String original, String translation) {
        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

        WordsEntity wordsEntity = new WordsEntity()
                .setOriginal(original)
                .setTranslation(translation);
        try {
            template.update(
                    String.format("INSERT INTO words (original, translation) VALUES ('%s', '%s')",
                            wordsEntity.getOriginal(),
                            wordsEntity.getTranslation())
            );
        } catch (Exception e) {
            NewWord.getErrorAddWord(
                    "Error: no database connection." +
                            "\nОтсутствует подключение к базе данных!" +
                            "\nСлова добавлены в локальное хранилище!");
        }

    }
}
