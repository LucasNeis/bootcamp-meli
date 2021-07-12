package Exercise2;

public class CounterMain {
    public static void main(String[] args) {
        Counter c = new Counter();
        System.out.println(c);
        c.increment();
        System.out.println(c);
        c.decrement();
        System.out.println(c);
        c.set(100);
        System.out.println(c);
        System.out.println(c.get());
    }
}
