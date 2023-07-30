package edu.model.database;

import edu.model.entity.Buffer;
import edu.model.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class TasksBuffer {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TasksBuffer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Buffer getTaskBuffer() {
        return jdbcTemplate.query(
                "SELECT * FROM buffer WHERE count > 0  ORDER BY id LIMIT 1",
                new BeanPropertyRowMapper<>(Buffer.class)).stream().findAny().orElse(null);
        // TODO в дальнейшем null заменить!
    }

    public void checkCount() {
        jdbcTemplate.update("UPDATE buffer SET count=3");
    }

    public void add(List<Task> list) {
        jdbcTemplate.batchUpdate(
                "INSERT INTO buffer (id, condition, answer) VALUES (?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(@Nullable PreparedStatement ps, int i) throws SQLException {
                        assert ps != null;
                        ps.setInt(1, list.get(i).getId());
                        ps.setString(2, list.get(i).getCondition());
                        ps.setString(3, list.get(i).getAnswer());
                    }

                    @Override
                    public int getBatchSize() {
                        return list.size();
                    }
                });
    }

    public void update(int id, int updateCount) {
        jdbcTemplate.update("UPDATE buffer SET count=? WHERE id=?", updateCount, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM buffer WHERE id=?", id);
    }

    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM buffer");
    }
}