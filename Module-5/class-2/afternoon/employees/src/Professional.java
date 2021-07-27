import java.math.BigDecimal;

public abstract class Professional {
    protected BigDecimal baseWage;
    protected float bonus;
    protected float gratification;
    protected float hoursWorked;
    protected Company employer;

    public Professional(float bonus, float gratification, float hoursWorked, BigDecimal baseWage) {
        this.bonus = bonus;
        this.gratification = gratification;
        this.hoursWorked = hoursWorked;
        this.baseWage = baseWage;
    }

    @Override
    public String toString() {
        return "Professional has:\n baseWage = " + baseWage +
                "\n bonus = " + bonus +
                "\n gratification = " + gratification +
                "\n hoursWorked = " + hoursWorked +
                "\n totalling " + this.getWage() +
                "\n";
    }

    public void setEmployer(Company company) {
        this.employer = company;
    }

    public Company getEmployer() {
        return employer;
    }

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

    public float getGratification() {
        return gratification;
    }

    public void setGratification(float gratification) {
        this.gratification = gratification;
    }

    public void setBaseWage(BigDecimal baseWage) {
        this.baseWage = baseWage;
    }

    public BigDecimal getWage() {
        return calculateWage();
    }

    protected abstract BigDecimal calculateWage();
}
