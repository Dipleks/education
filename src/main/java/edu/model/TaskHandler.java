package edu.model;

import edu.config.TaskConfig;
import edu.database.TaskHandlerDB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskHandler {

    private static AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(TaskConfig.class);
    private static TaskHandlerDB TASK_HANDLER =
            context.getBean("taskHandlerDB", TaskHandlerDB.class);

    public static void addNewTask(String condition, String answer) {
        TASK_HANDLER.add(condition, answer);
        context.close();
    }

    public static String getCondition() {
        String condition = TASK_HANDLER.getTask(getTaskID()).getCondition();
        context.close();
        return condition;
    }

    public static String getAnswer() {
        String answer = TASK_HANDLER.getTask(getTaskID()).getAnswer();
        context.close();
        return answer;
    }

    public static void isStatus() {
        TASK_HANDLER.updateStatus(getTaskID());
        context.close();
    }
    private static int getTaskID() {
        int number = TASK_HANDLER.getID();
        context.close();
        return number;
    }
}
