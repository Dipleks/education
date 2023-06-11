package dipleks.model.database;

import dipleks.model.database.entity.TopWordsEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class ListWordsDatabase {

    private ListWordsDatabase() {
    }

    public static List<TopWordsEntity> getTopWords() throws Exception {

        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

        return template.query(
                "SELECT original, translation FROM words ORDER BY id DESC LIMIT 10;",
                (rs, rowNum) -> new TopWordsEntity(
                        rs.getString("original"),
                        rs.getString("translation")
                )
        );
    }
}
