package dipleks.model.database;

import dipleks.model.database.entity.TopWordsEntity;
import javafx.scene.control.Alert;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class TopWordsDatabase {

    private TopWordsDatabase() {
    }

    public static List<TopWordsEntity> getTopWords() {

        JdbcTemplate template = new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());
        List<TopWordsEntity> list = new ArrayList<>();
        try {
            list = template.query(
                    "SELECT original, translation FROM words ORDER BY id DESC LIMIT 10;",
                    (rs, rowNum) -> new TopWordsEntity(
                            rs.getString("original"),
                            rs.getString("translation")
                    )
            );
        } catch (Exception e) {
            getErrorDatabaseConnect();
        }
        return list;
    }

    private static void getErrorDatabaseConnect() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information error");
        alert.setContentText("Error: no database connection." +
                "\nОтсутствует подключение к базе данных!");
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
