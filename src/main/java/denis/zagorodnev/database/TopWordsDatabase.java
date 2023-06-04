package denis.zagorodnev.database;

import denis.zagorodnev.model.entity.TopWordsEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class TopWordsDatabase {

    private TopWordsDatabase() {
    }

    public static List<TopWordsEntity> getTopWords() {

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
