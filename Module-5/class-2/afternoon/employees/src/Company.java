import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Professional> employees = new ArrayList<>();
    private BigDecimal lastYearsProfit;

    public Company(BigDecimal lastYearsProfit) {
        this.lastYearsProfit = lastYearsProfit;
    }

    public void addEmployee(Professional employee) {
        this.employees.add(employee);
        employee.setEmployer(this);
    }

    public BigDecimal getLastYearsProfit() {
        return this.lastYearsProfit;
    }
}
