import java.math.BigDecimal;

public class CLTManager extends CLTGratifiedProfessional {
    public CLTManager(int completedGoals) {
        super(completedGoals,0.125f, new BigDecimal(6000));
    }
}
