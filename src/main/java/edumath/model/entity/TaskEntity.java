package edumath.model.entity;

public class TaskEntity {
    private int id;
    private int number;
    private String condition;
    private String answer;
    private boolean status;

    public TaskEntity() {
    }

    public TaskEntity(String condition) {
        this.condition = condition;
    }

    public TaskEntity(int number, String condition, String answer, boolean status) {
        this.number = number;
        this.condition = condition;
        this.answer = answer;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getCondition() {
        return condition;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isStatus() {
        return status;
    }

    public TaskEntity setNumber(int number) {
        this.number = number;
        return this;
    }

    public TaskEntity setCondition(String condition) {
        this.condition = condition;
        return this;
    }

    public TaskEntity setAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public TaskEntity setStatus(boolean status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "TaskEntity{" +
                "id=" + id +
                ", number=" + number +
                ", condition='" + condition + '\'' +
                ", answer='" + answer + '\'' +
                ", answerDefault=" + status +
                '}';
    }
}
