package dipleks.database;

import dipleks.database.entity.DictionaryEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ListWordsDatabase {

    private ListWordsDatabase() {
    }

    public static List<DictionaryEntity> getTopWords() throws Exception {

        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

        return template.query(
                "SELECT original, translation FROM words ORDER BY id DESC;",
                (rs, rowNum) -> new DictionaryEntity(
                        rs.getString("original"),
                        rs.getString("translation")
                )
        );
    }
}
