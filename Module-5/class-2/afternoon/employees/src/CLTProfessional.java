import java.math.BigDecimal;

public abstract class CLTProfessional extends Professional {
    protected int goalsCompleted;
    public CLTProfessional(float bonus, int completedGoals, float gratification, float hoursWorked, BigDecimal baseWage) {
        super(bonus, gratification, hoursWorked, baseWage);
        this.goalsCompleted = completedGoals;
    }


    public int getGoalsCompleted() {
        return goalsCompleted;
    }

    public void setGoalsCompleted(int goalsCompleted) {
        this.goalsCompleted = goalsCompleted;
    }

    public CLTProfessional(float bonus, float gratification, float hoursWorked, BigDecimal wage) {
        super(bonus, gratification, hoursWorked, wage);
    }
}
