package edu.database;

import edu.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class TaskHandlerDB {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskHandlerDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(String condition, String answer) {
        jdbcTemplate.update(
                "INSERT INTO tasks (condition, answer) VALUES (?, ?)",
                condition, answer);
    }

    public void updateStatus(int id) {
        jdbcTemplate.update("UPDATE tasks SET status=true WHERE id=?", id);
    }

    public Task getTask(int id) {
        return jdbcTemplate.query("SELECT * FROM tasks WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Task.class)).stream().findAny().orElse(null);
        // TODO в дальнейшем null заменить!
    }

    public int getID() {
        return Objects.requireNonNull(jdbcTemplate.query(
                "SELECT * FROM tasks WHERE status = false LIMIT 1", new BeanPropertyRowMapper<>(Task.class))
                .stream().findAny().orElse(null)).getId();
        // TODO в дальнейшем null заменить!
    }

    public int getNextID(int limit) {
        List<Task> tasks = jdbcTemplate.query(
                        "SELECT * FROM tasks WHERE status = false LIMIT ?", new Object[]{limit},
                        new BeanPropertyRowMapper<>(Task.class));
        return tasks.get(tasks.size() - 1).getId();
        // TODO в дальнейшем null заменить!
    }

    public void delete() {

    }
}
