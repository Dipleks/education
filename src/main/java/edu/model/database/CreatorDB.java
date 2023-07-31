package edu.model.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class CreatorDB {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CreatorDB(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
     * Выполняем провкерку: существует ли БД и таблицы.
     * Если нет, создать недостающий элемент.
     * */
    public void createDB() {
        // Создаем БД
    }

    public void createTableBuffer() {
        // Создаем таблицу Буффера
    }

    public void createTableTasks() {
        // Создаем таблицу Задач
    }
}
