import java.math.BigDecimal;
import java.math.MathContext;

public abstract class CLTLeadership extends CLTProfessional {
    public CLTLeadership(float bonus, BigDecimal baseWage) {
        super(bonus, 0, 0, 0, baseWage);
    }

    @Override
    protected BigDecimal calculateWage() {
        BigDecimal bonus = this.employer.getLastYearsProfit().multiply(new BigDecimal(this.bonus, MathContext.DECIMAL32));
        return this.baseWage.add(bonus);
    }
}
