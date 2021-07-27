import java.math.BigDecimal;

public class CLTTechnician extends CLTGratifiedProfessional {
    public CLTTechnician(int completedGoals) {
        super(completedGoals, 0.05f, new BigDecimal(3200));
    }

}
