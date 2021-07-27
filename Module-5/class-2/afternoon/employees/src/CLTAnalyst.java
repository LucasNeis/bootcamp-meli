import java.math.BigDecimal;

public class CLTAnalyst  extends CLTGratifiedProfessional {
    public CLTAnalyst(int completedGoals) {
        super(completedGoals, 0.08f, new BigDecimal(4000));
    }
}
