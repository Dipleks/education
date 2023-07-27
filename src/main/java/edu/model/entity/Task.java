package edu.model.entity;

public class Task {
    private int id;
    private String condition;
    private String answer;
    private boolean status;

    public Task() {}

    public Task(int id, String condition, String answer, boolean status) {
        this.id = id;
        this.condition = condition;
        this.answer = answer;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", condition='" + condition + '\'' +
                ", answer='" + answer + '\'' +
                ", status=" + status +
                '}';
    }
}
