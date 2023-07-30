package edu.model.entity;

public class Buffer {

    private int id;
    private String condition;
    private String answer;
    private int count;

    public Buffer() {
    }

    public Buffer(int id, String condition, String answer, int count) {
        this.id = id;
        this.condition = condition;
        this.answer = answer;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
