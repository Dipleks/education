package edumath.entity;

public class AnswerEntity {
    private int id;
    private String date;
    private int number;
    private boolean decision;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }

    @Override
    public String toString() {
        return "AnswerEntity{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", number=" + number +
                ", decision=" + decision +
                '}';
    }
}
