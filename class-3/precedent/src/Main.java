import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Precedent<Person>> people[] = new List[2];
        people[0] = new ArrayList<>();
        Person p1 = new Person("Alberto", "000.000.000-00");
        Person p2 = new Person("Adalberto", "000.000.000-01");
        Person p3 = new Person("Dagoberto", "000.000.000-02");
        Person p4 = new Person("Felisberto", "000.000.000-03");
        Person p5 = new Person("Roberto", "000.000.000-04");
        people[0].add(p5);
        people[0].add(p1);
        people[0].add(p3);
        people[0].add(p4);
        people[0].add(p2);

        people[1] = new ArrayList<>();
        Person p6 = new Person("Alice", "000.000.000-10");
        Person p7 = new Person("Berenice", "000.000.000-11");
        Person p8 = new Person("Clarice", "000.000.000-12");
        Person p9 = new Person("Felice", "000.000.000-13");
        Person p0 = new Person("Klarice", "000.000.000-14");
        people[1].add(p0);
        people[1].add(p9);
        people[1].add(p7);
        people[1].add(p6);
        people[1].add(p8);

        SortUtil.sort(people);
        for (List<Precedent<Person>> e : people) {
            e.forEach(System.out::println);
            System.out.println("-----");
        }

    }
}
