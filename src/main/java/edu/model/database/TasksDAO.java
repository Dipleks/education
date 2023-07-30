package edu.model.database;

import edu.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class TasksDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TasksDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Task> getAll() {
        return Objects.requireNonNull(jdbcTemplate.query(
                        "SELECT * FROM tasks WHERE status = false",
                new BeanPropertyRowMapper<>(Task.class)));
    }

    public void add(String condition, String answer) {
        jdbcTemplate.update(
                "INSERT INTO tasks (condition, answer) VALUES (?, ?)",
                condition, answer);
    }

    public void update(int id, Task updateTask) {
        jdbcTemplate.update("UPDATE tasks SET condition=?, answer=?, status=? WHERE id=?",
                updateTask.getCondition(), updateTask.getAnswer(), updateTask.isStatus(), id);
    }

    public void updateStatus(int id) {
        jdbcTemplate.update("UPDATE tasks SET status=true WHERE id=?", id);
    }

    public Task getTask() {
        return Objects.requireNonNull(jdbcTemplate.query(
                        "SELECT * FROM tasks WHERE status = false LIMIT 1", new BeanPropertyRowMapper<>(Task.class))
                .stream().findAny().orElse(null));
        // TODO в дальнейшем null заменить!
    }

    public void delete() {

    }
}