import java.math.BigDecimal;
import java.math.MathContext;

public abstract class CLTGratifiedProfessional extends CLTProfessional {

    public CLTGratifiedProfessional(int completedGoals, float gratification, BigDecimal baseWage) {
        super(0, completedGoals, gratification, 0, baseWage);
    }

    @Override
    public String toString() {
        return "Professional has:\n baseWage = " + baseWage +
                "\n bonus = " + bonus +
                "\n gratification = " + gratification +
                "\n hoursWorked = " + hoursWorked +
                "\n objectives compl = " + getGoalsCompleted() +
                "\n totalling " + this.getWage() +
                "\n";
    }

    @Override
    protected BigDecimal calculateWage() {
        BigDecimal bonus = new BigDecimal(this.goalsCompleted*this.gratification, MathContext.DECIMAL32).multiply(this.baseWage);
        return this.baseWage.add(bonus);
    }
}
