import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class TestProfessional {
    public static void main(String[] abs) {
        List<Professional> employees = List.of(
                new PJProfessional(10, new BigDecimal("30.00")),
                new CLTAnalyst(0),
                new CLTAnalyst(3),
                new CLTAnalyst(9),
                new CLTTechnician(3),
                new CLTTechnician(2),
                new CLTTechnician(1),
                new CLTManager(12),
                new CLTManager(6),
                new CLTDirector()
        );
        Company company = new Company(new BigDecimal("100000"));
        employees.stream().forEach(company::addEmployee);
        employees.stream().forEach(System.out::println);
    }
}
