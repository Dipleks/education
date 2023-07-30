package edu.model.mathematicks;

import edu.model.config.TaskConfig;
import edu.model.database.TasksBuffer;
import edu.model.database.TasksDAO;
import edu.model.entity.Buffer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tasks {

    private static final AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(TaskConfig.class);

    private static final TasksDAO TASK_HANDLER =
            context.getBean("tasksDAO", TasksDAO.class);

    private static final TasksBuffer TASKS_BUFFER =
            context.getBean("tasksBuffer", TasksBuffer.class);

    public static String showCondition() {
        try {
            String condition = TASKS_BUFFER.getTaskBuffer().getCondition();
            context.close();
            return condition;
        } catch (Exception e) {
            TASKS_BUFFER.checkCount();
        }
        return TASK_HANDLER.getTask().getCondition();
    }

    public static String checkAnswer() {
        String answer = TASKS_BUFFER.getTaskBuffer().getAnswer();
        context.close();
        return answer;
    }

    public static int getID() {
        int id = TASKS_BUFFER.getTaskBuffer().getId();
        context.close();
        return id;
    }

    public static void deleteTasksFromBuffer() {
        TASKS_BUFFER.delete(TASKS_BUFFER.getTaskBuffer().getId());
        context.close();
    }

    public static String tryingDecide() {
        Buffer buffer = TASKS_BUFFER.getTaskBuffer();
        int count = buffer.getCount();
        buffer.setCount(--count);
        TASKS_BUFFER.update(buffer.getId(), buffer.getCount());

        return showCondition();
    }

    public static void copyTasksInBufferTable() {
        TASKS_BUFFER.add(TASK_HANDLER.getAll());
        context.close();
    }

    public static void clearBufferTable() {
        TASKS_BUFFER.deleteAll();
        context.close();
    }
}
