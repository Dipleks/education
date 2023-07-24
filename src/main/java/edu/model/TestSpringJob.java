package edu.model;

import edu.config.TaskConfig;
import edu.database.TaskHandlerDB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpringJob {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                TaskConfig.class
        );

//        TaskDAO taskDAO = new TaskDAO();
//        System.out.println(taskDAO.getCondition(FakeDB.getTasks().get(1)));

//        TaskHandler taskHandler = context.getBean("taskHandler", TaskHandler.class);
//        taskHandler.addTask("test1", "t1");

//        TaskHandlerDB taskHandlerDB = context.getBean("taskHandlerDB", TaskHandlerDB.class);
//        taskHandlerDB.add("test2", "t2");

//        System.out.println(taskHandlerDB.getTask().getCondition());
//        System.out.println(taskHandlerDB.getTask().getNumber());
//        System.out.println(taskHandlerDB.getTask().isStatus());
//        taskHandlerDB.updateStatus(taskHandlerDB.getTask().getNumber());

//        System.out.println(taskHandlerDB.getNextID(3));

        context.close();
    }
}
