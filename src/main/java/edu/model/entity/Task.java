package edu.model.entity;

public class Task {
    private int number;
    private String condition;
    private String answer;
    private boolean status;

    public Task() {}

    public Task(int number, String condition, String answer, boolean status) {
        this.number = number;
        this.condition = condition;
        this.answer = answer;
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                "number=" + number +
                ", condition='" + condition + '\'' +
                ", answer='" + answer + '\'' +
                ", status=" + status +
                '}';
    }
}
