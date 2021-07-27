import java.math.BigDecimal;
import java.math.MathContext;

public class PJProfessional extends Professional {
    public PJProfessional() {
        super(0f, 0f, 0f, new BigDecimal(0));
    }

    public PJProfessional(float hoursWorked, BigDecimal paymentPerHour) {
        super(0, 0, hoursWorked, paymentPerHour);
    }

    @Override
    protected BigDecimal calculateWage() {
        return new BigDecimal(this.hoursWorked, MathContext.DECIMAL64).multiply(this.baseWage);
    }
}
