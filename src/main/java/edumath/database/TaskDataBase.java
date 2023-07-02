package edumath.database;

import edumath.entity.TaskEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public enum TaskDataBase {
    TASKS {
        @Override
        public void add(int number, String condition, String answer) {
            TaskEntity taskEntity = new TaskEntity()
                    .setNumber(number)
                    .setCondition(condition)
                    .setAnswer(answer);
            TEMPLATE.update(
                String.format(
                        "INSERT INTO task (number, condition, answer) VALUES ('%s', '%s', '%s')",
                        taskEntity.getNumber(),
                        taskEntity.getCondition(),
                        taskEntity.getAnswer()
                )
            );
        }

        @Override
        public List<TaskEntity> get() {
            return TEMPLATE.query(
                    "SELECT condition FROM task WHERE status = false LIMIT 1;",
                    (rs, rowNum) -> new TaskEntity(
                            rs.getString("condition")
                    )
            );
        }

        @Override
        public List<TaskEntity> getAll() {
            return TEMPLATE.query(
                    "SELECT * FROM task",
                    (rs, rowNum) -> new TaskEntity(
                            rs.getInt("number"),
                            rs.getString("condition"),
                            rs.getString("answer"),
                            rs.getBoolean("status")
                    )
            );
        }

        @Override
        public void edit(int number, String condition, String answer, boolean status) {
            TEMPLATE.update(
                    String.format(
                            "UPDATE task " +
                                    "SET (condition, answer, status) = ('%s', '%s', %s) " +
                                    "WHERE number = %s;",
                            condition,
                            answer,
                            status,
                            number
                    )
            );
        }

        @Override
        public void delete(int number) {
            TEMPLATE.update(String.format("DELETE FROM task WHERE number = %s;", number)
            );
        }

        @Override
        public void deleteAll() {
            TEMPLATE.update("TRUNCATE task;"); // удаляем все значения из таблицы, во избежание дублекатов
//            for (String requestSQL : Backup.LIST.getListSQL()) {
//                TEMPLATE.update(requestSQL);
//            }
        }
    };

    private static final JdbcTemplate TEMPLATE =
            new JdbcTemplate(DataSourceProvider.INSTANCE.getDataSource());

    public abstract void add(int number, String condition, String answer);
    public abstract List<TaskEntity> get();
    public abstract List<TaskEntity> getAll();
    public abstract void edit(int number, String condition, String answer, boolean status);
    public abstract void delete(int number);
    public abstract void deleteAll();
}
