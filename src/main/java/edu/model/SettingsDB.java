package edu.model;

import edu.model.config.TaskConfig;
import edu.model.database.CreatorDB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SettingsDB {
    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(TaskConfig.class);

    private static final CreatorDB CREATOR_DB =
            context.getBean("creatorDB", CreatorDB.class);

    public static void createDB() {
        CREATOR_DB.createDB();
        context.close();
    }

    public static void createTableBuffer() {
        CREATOR_DB.createTableBuffer();
        context.close();
    }

    public static void createTableTasks() {
        CREATOR_DB.createTableTasks();
        context.close();
    }
}